package com.uca.entity;

import java.sql.Timestamp;
import java.util.*;

public class ArticleEntity {
    private String name;
    private Timestamp created_time;
    private String content;
    private String author;
    private int id;
    private ArrayList<CommentEntity> comments;

    public ArticleEntity() {
        //Ignored !
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ArrayList<CommentEntity> getComment(){
        return comments;
    }

    public void setComment(ArrayList<CommentEntity> comments){
        
        this.comments = comments;
    }
}
