/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

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

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
