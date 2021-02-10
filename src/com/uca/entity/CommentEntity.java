package com.uca.entity;

import java.sql.Timestamp;

public class CommentEntity{
    private int id;
    private int id_article;
    private String author;
    private String content;
    private Timestamp created_time;

    public CommentEntity() {
        //Ignored !
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId_article() {
        return this.id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public Timestamp getCreated_time() {
        return this.created_time;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}