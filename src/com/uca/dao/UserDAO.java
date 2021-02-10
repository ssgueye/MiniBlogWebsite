package com.uca.dao;

import com.uca.entity.*;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO extends _Generic<UserEntity> {

    public UserEntity getUserByUserName(String user_name){

        UserEntity usr = null;
        try{
            PreparedStatement statement = this.connect.prepareStatement("SELECT* FROM users where user_name = ?;");
            statement.setString(1, user_name);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                usr = new UserEntity();
                usr.setUser_name(user_name);
                usr.setPassword(resultSet.getString("password"));
                usr.setIsAdmin(resultSet.getBoolean("isAdmin"));
                usr.setIsBanned(resultSet.getBoolean("isBanned"));
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usr;
    }

    @Override
    public UserEntity create(UserEntity obj) {

        try {
                PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO users(user_name, password, isAdmin, isbanned) VALUES(?, ?, ?, ?);");
                preparedStatement.setString(1, obj.getUser_name());
			    preparedStatement.setString(2, obj.getPassword());
			    preparedStatement.setBoolean(3, obj.getIsAdmin());
                preparedStatement.setBoolean(4, obj.getIsBanned());
			    preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return obj;
    }

    public boolean DeleteUser(String user_name) {
        boolean supprimee = true;
		try {
            
			PreparedStatement statement = this.connect.prepareStatement("DELETE FROM users when user_name = ?;");
            statement.setString(1, user_name);
			supprimee = statement.executeUpdate() > 0;
		} catch (SQLException e) {
            e.printStackTrace();
        }

        return supprimee;
		
    }

    //Méthode inutile
    @Override
    public boolean delete(int id){
        return true;
    }

}
