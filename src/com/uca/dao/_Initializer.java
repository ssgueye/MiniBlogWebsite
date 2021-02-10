package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement article_table;
            PreparedStatement comment_table;
            PreparedStatement user_table;

            //Creation de la table Article
            article_table = connection.prepareStatement("CREATE TABLE IF NOT EXISTS articles (id int primary key auto_increment, name varchar(100), author varchar(100), created_at timestamp, content longnvarchar(25000)); ");
            article_table.executeUpdate();

            //Creation de la table Comments
            comment_table = connection.prepareStatement("CREATE TABLE IF NOT EXISTS comments (id int primary key auto_increment, id_article int, author varchar(100), created_at timestamp, content longnvarchar(25000), FOREIGN KEY(id_article) REFERENCES articles(id)); ");
            comment_table.executeUpdate();

            //Creation de la table User
            user_table = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (user_name varchar(20) primary key, password varchar(50), isAdmin boolean, isBanned boolean); ");
            user_table.executeUpdate();

            //Insertion
            article_table = connection.prepareStatement("INSERT INTO articles(name, author, created_at, content) VALUES(?, ?, ?, ?);");
            article_table.setString(1, "La Crise Sanitaire et ses conséquences sur l'économie mondiale !");
            article_table.setString(2, "Saliou");
            article_table.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            article_table.setString(4, "Le covid 19 a eu des conséquences très grave dans l'économie mondiale (...)");
            article_table.executeUpdate();


            comment_table = connection.prepareStatement("INSERT INTO comments(id_article, author, created_at, content) VALUES(?, ?, ?, ?);");
            comment_table.setInt(1, 1);
            comment_table.setString(2, "Elodie");
            comment_table.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            comment_table.setString(4, "je suis parfaitement d'accord");
            comment_table.executeUpdate();

            
            // select articles.author from comments inner join articles on articles.id = comments.id_article where comments.id_article = 2
            //Pour afficher l'auteur des articles auxquels le commentaire id  égale à 1

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
