package com.uca;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.uca.core.*;
import com.uca.dao.*;
import com.uca.entity.*;
import com.uca.gui.*;
import com.uca.token.*;

import spark.Request;

import java.util.*;

import static spark.Spark.*;

import java.sql.Timestamp;


public class StartServer {

    public static void main(String[] args) throws Exception{

        //Configure Spark
        staticFiles.location("/static/");
        port(8081);


        _Initializer.Init();

    
        //Defining our routes

        //Les méthodes GET
        get("/", (req, res) -> {
            return ArticleGUI.getAllArticles();
        });

        get("/connexion", (req, res) -> {
            return ConnexionGUI.showConnexionForm();
        });

        get("/newArticle", (req, res) -> {
            return CreateNewArticleGUI.ShowNewArticleForm();
        });

        get("/inscription", (req, res)-> {
            return InscriptionGUI.showInscriptionForm();
        });

        get("/articelForConnected", (req, res)-> {
            return ArticleCommentGUI.getAllArticles();
        });


        // Les méthodes POST
        //Pour recupérer les infos pendant l'inscription
        post("/register", (req, res)-> {
            String user_name = req.queryParams("user_name") != null ? req.queryParams("user_name"): "anonymous";
            String password = req.queryParams("password") != null ? req.queryParams("password"): "unknown";

            UserEntity usr = new UserEntity();
            String hashedPassword = usr.HashingMD5(password);
            usr.setUser_name(user_name);
            usr.setPassword(hashedPassword);
            usr.setIsAdmin(true); // Tout le monde est admin
            usr.setIsBanned(false);

            new UserCore().Newuser(usr);

            res.redirect("/connexion", 301);

            return "";
        });
        // Pour recupérer les infos de connexion
        post("/signIn", (req, res)-> {
            String user_name = req.queryParams("user_name") != null ? req.queryParams("user_name"): "anonymous";
            String password = req.queryParams("password") != null ? req.queryParams("password"): "unknown";
            
            System.out.println(PostConnexionGUI.isLoggin(user_name, password));
            
            if(PostConnexionGUI.isLoggin(user_name, password)){

                String TOKEN = Token.createJWT(user_name, "ed916c75-8e80-4370-ac0d-6c0f257f4e9b");

                req.session(true);
                req.session().attribute("auth", TOKEN);
                res.cookie("auth",TOKEN, 100*60*60);

                return PostConnexionGUI.succesPage(user_name);
            }
            else{
                return PostConnexionGUI.signInWrong();
            }
        });
        //Pour créer un nouveau article
        post("/newArticlePost", (req, res)-> {

            String title = req.queryParams("title") != null ? req.queryParams("title"): "No define";
            String author = req.queryParams("author") != null ? req.queryParams("author"): "No define";
            String content = req.queryParams("content") != null ? req.queryParams("content"): "No define";

            ArticleEntity article = new ArticleEntity();

            Timestamp created_at = new Timestamp(System.currentTimeMillis());

            article.setName(title);
            article.setAuthor(author);
            article.setContent(content);
            article.setCreated_time(created_at);

            ArticleEntity obj = new ArticleDAO().create(article);

            res.redirect("/articelForConnected", 301);

            return "";
        });
        //Pour créer un commentaire
        post("/newCommentPost", (req, res)->{

            String author = req.queryParams("author") != null ? req.queryParams("author"): "No define";
            String content = req.queryParams("content") != null ? req.queryParams("content"): "No define";
            String id_article = req.queryParams("id_article") != null ? req.queryParams("id_article"): "No define";
            int idArticle = Integer.parseInt(id_article); //Recupérer l'ID de l'article sous format int

            CommentEntity comment = new CommentEntity();

            Timestamp created_at = new Timestamp(System.currentTimeMillis());

            comment.setId_article(idArticle);
            comment.setAuthor(author);
            comment.setContent(content);
            comment.setCreated_time(created_at);

            new CommentDAO().create(comment);

            ArrayList<CommentEntity> comments = new ArrayList<CommentEntity>();
            comments.add(comment);

            ArticleEntity obj = new ArticleDAO().getArticle(idArticle);
            obj.setComment(comments);

            res.redirect("/articelForConnected", 301);
            
            return "";
        });
        //Pour se déconnecter
        post("/logOut", (req, res)->{

            req.session(false);
            req.session().removeAttribute("auth");
            res.removeCookie("auth");

            res.redirect("/", 301);
            
            return "";
        });
        // API
        get("/api/articles", (req, res) -> {
            Boolean useXML = useXML(req);
            if (useXML == null) {
                res.status(406);
                return "";
            }

            ArrayList<ArticleEntity> entities = ArticleCore.getAllArticles();
            if (entities == null || entities.size() == 0) {
                res.status(204);
                return "";
            }

            res.header("Content-Type", useXML ? "application/xml" : "application/json");
            return parseContent(useXML, entities);
        });
    }

    private static Boolean useXML(Request req) {
        if (req.headers("Accept") != null && !req.headers("Accept").isEmpty() && !req.headers("Accept").equals("*/*")) {
            int json = req.headers("Accept").indexOf("application/json");
            int xml = req.headers("Accept").indexOf("application/xml");
            if (json == -1 && xml == -1) {
                return null;
            }
            if (xml == -1) {
                return false;
            } else {
                return json == -1 || json >= xml;
            }
        }
        return true;
    }

    private static String parseContent(boolean useXML, Object obj) throws JsonProcessingException {
        if (obj.getClass().getName().equals("java.util.ArrayList")) {
            Map<String, Object> map = new HashMap<>();
            map.put("content", obj);
            obj = map;
        }

        if (useXML) {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(obj);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}