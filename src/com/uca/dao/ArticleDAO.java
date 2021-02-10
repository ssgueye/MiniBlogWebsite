package com.uca.dao;

import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;

public class ArticleDAO extends _Generic<ArticleEntity> {

    public ArrayList<ArticleEntity> getAllArticles() {

        ArrayList<ArticleEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT* FROM articles ORDER BY created_at DESC;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                ArticleEntity entity = new ArticleEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setAuthor(resultSet.getString("author"));
                entity.setContent(resultSet.getString("content"));
                entity.setCreated_time(resultSet.getTimestamp("created_at"));
                entity.setName(resultSet.getString("name"));


                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public ArticleEntity create(ArticleEntity obj) {

        try {
                PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO articles(name, author, created_at, content) VALUES(?, ?, ?, ?);");
                preparedStatement.setString(1, obj.getName());
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
            
			PreparedStatement statement = this.connect.prepareStatement("DELETE FROM comments where id = ?;");
            statement.setInt(1, id);
			supprimee = statement.executeUpdate() > 0;
		} catch (SQLException e) {
            e.printStackTrace();
        }

        return supprimee;
		
    }

    //Pour séléctionner un article via son id
    public ArticleEntity getArticle(int id){

        ArticleEntity art = null;
        try{
            PreparedStatement statement = this.connect.prepareStatement("SELECT* FROM articles where id = ?;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                art = new ArticleEntity();
                art.setId(id);
                art.setAuthor(resultSet.getString("author"));
                art.setContent(resultSet.getString("content"));
                art.setCreated_time(resultSet.getTimestamp("created_at"));
                art.setName(resultSet.getString("name"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return art;
    }

}
