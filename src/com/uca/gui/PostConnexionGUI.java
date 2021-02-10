package com.uca.gui;

import com.uca.core.*;
import com.uca.entity.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;
import static spark.Spark.*;
import com.uca.token.*;

//Affiche l'état d'une requête de connexion. Une page d'erreur est renvoyé si les infos de connexions ne sont pas bonnes
public class PostConnexionGUI {

    public static String signInWrong() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();
       
        Map<String, Object> input = new HashMap<>();

        input.put("error", "Mauvais nom d'utilisateur/mot de passe");

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("articles/Error.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
        
    }

    //Vérifie si les infos de connexion sont bonnes
    public static boolean isLoggin(String user_name, String password){

        if(UserCore.authenticate(user_name, password)){
            return true;
        }

        return false;
    }

    public static String succesPage(String user_name)throws IOException, TemplateException{

        Configuration configuration = _FreeMarkerInitializer.getContext();
       
        Map<String, Object> input = new HashMap<>();

        input.put("user_name", user_name);

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("articles/Success.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
