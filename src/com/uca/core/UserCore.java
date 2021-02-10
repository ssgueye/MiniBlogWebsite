package com.uca.core;

import com.uca.dao.*;
import com.uca.entity.*;

import java.util.ArrayList;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserCore {

    //Créer un nouveau utilisateur
    public static UserEntity Newuser(UserEntity usr){

        return new UserDAO().create(usr);
    }
    //Vérifier si l'utilsateur est authentifié
    public static boolean authenticate(String user_name, String password){

        if (user_name.isEmpty() || password.isEmpty()) {
            return false;
        }
        
        UserEntity user = new UserDAO().getUserByUserName(user_name);

        if (user == null) {
            return false;
        }

        String hashedPassword = UserCore.HashingMD5(password);

        return ((user_name.equals(user.getUser_name()))&& (hashedPassword.equals(user.getPassword())));
    }

    //Méthode du hachage: Méthode utilisé juste pour hacher le mot de passe donné et faire sa comparaison avec celle dans la base
    public static String HashingMD5(String password){

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
