package com.uca.core;

import com.uca.dao.*;
import com.uca.entity.*;

import java.util.ArrayList;


public class ArticleCore {

    //Recupérer tous les articles et leurs commentaires
    public static ArrayList<ArticleEntity> getAllArticles() {

        ArrayList<ArticleEntity> entities = new ArticleDAO().getAllArticles();
        entities.forEach(e -> e.setComment(new CommentDAO().getCommentByArticle_id(e.getId())));

        return entities;
    }

    //Obtenir un article 
    public static ArticleEntity getArticleById(int id){

        ArticleEntity ar = new ArticleDAO().getArticle(id);
        ar.setComment(new CommentDAO().getCommentByArticle_id(id));

        return ar;
    }

}
