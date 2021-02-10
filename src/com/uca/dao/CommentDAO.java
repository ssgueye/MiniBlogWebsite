package com.uca.dao;

import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;

public class CommentDAO extends _Generic<CommentEntity> {

    public ArrayList<CommentEntity> getAllArticles() {

        ArrayList<CommentEntity> comments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT* FROM comments ORDER BY created_at DESC;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                CommentEntity comment = new CommentEntity();
                comment.setId(resultSet.getInt("id"));
                comment.setAuthor(resultSet.getString("author"));
                comment.setContent(resultSet.getString("content"));
                comment.setCreated_time(resultSet.getTimestamp("created_at"));
                comment.setId_article(resultSet.getInt("id_article"));


                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    @Override
    public CommentEntity create(CommentEntity obj) {

        try {
                PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO comments(id_article, author, created_at, content) VALUES(?, ?, ?, ?);");
                preparedStatement.setInt(1, obj.getId_article());
			    preparedStatement.setString(2, obj.getAuthor());
			    preparedStatement.setTimestamp(3, obj.getCreated_time());
                preparedStatement.setString(4, obj.getContent());
			    preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public boolean delete(int id) {

        boolean supprimee = true;
		try {
            
			PreparedStatement statement = this.connect.prepareStatement("DELETE FROM comments when id = ?;");
            statement.setInt(1, id);
			supprimee = statement.executeUpdate() > 0;
		} catch (SQLException e) {
            e.printStackTrace();
        }

        return supprimee;
		
    }

    //Pour séléctionner un commentaire via son id
    public ArrayList<CommentEntity> getCommentByArticle_id(int id_article){
        
        ArrayList<CommentEntity> comment = new ArrayList<>();
        try{
            PreparedStatement statement = this.connect.prepareStatement("SELECT* FROM comments where id_article = ?;");
            statement.setInt(1, id_article);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                CommentEntity com = new CommentEntity();
                com.setId(resultSet.getInt("id"));
                com.setAuthor(resultSet.getString("author"));
                com.setContent(resultSet.getString("content"));
                com.setCreated_time(resultSet.getTimestamp("created_at"));
                com.setId_article(id_article);
            comment.add(com);            
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comment;
    }

}
