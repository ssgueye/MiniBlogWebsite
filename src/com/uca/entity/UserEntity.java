package com.uca.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserEntity{
  
    private String user_name;
    private String password;
    private boolean isAdmin;
    private boolean isBanned;


    public UserEntity(){}

    //Getters
    public String getUser_name(){
        return this.user_name;
    }
    public String getPassword(){
        return this.password;
    }
    public boolean getIsAdmin(){
        return this.isAdmin;
    }
    public boolean getIsBanned(){
        return this.isBanned;
    }
   

    //Setters
    public void setUser_name(String user_name){
        this.user_name = user_name;
    }
    public void setPassword(String password){
        this.password = password;
        
    }
    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }
    public void setIsBanned(boolean isBanned){
        this.isBanned = isBanned;
    }
    

    //Méthode du hachage
    public String HashingMD5(String password){
        try{
            MessageDigest messageDigest  = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for(byte b : resultByteArray){
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        
        return "";
    }
}