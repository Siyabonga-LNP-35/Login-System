/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

import java.util.regex.Pattern;

/**
 *
 * @author siyab
 */
public class Login {
     private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    // Method to check if username is valid or not
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
        // Method to check password complexity
    public boolean checkPasswordComplexity(String password) {
        Pattern upperCasePat = Pattern.compile("[A-Z]");
        Pattern digitPat = Pattern.compile("[0-9]");
        Pattern specialCharPat = Pattern.compile("[^a-zA-Z0-9]");
        return password.length() >= 8 && upperCasePat.matcher(password).find() &&
                digitPat.matcher(password).find() && specialCharPat.matcher(password).find();
    }

    public static void main(String[] args) {

    }
}
