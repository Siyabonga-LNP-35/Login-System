/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import java.util.Scanner;
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
        // Method to register the user
        public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        this.username = username;
        this.password = password;
        return "User successfully registered!";
    }
     // Method to log in the user
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method to return login status message
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + this.firstName + " " + this.lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Login login = new Login();
        
          // User registration
        System.out.println("Enter first name:");
        login.firstName = sc.next();
        System.out.println("Enter last name:");
        login.lastName = sc.next();
        System.out.println("Create username:");
        String username = sc.next();
        System.out.println("Create password:");
        String password = sc.next();
        
 // Register user and display the appropriate message
        String registrationMessage = login.registerUser(username, password);
        System.out.println(registrationMessage);

        if (registrationMessage.equals("User successfully registered!")) {
            // User login
            System.out.println("Enter username to login:");
            String loginUsername = sc.next();
            System.out.println("Enter password:");
            String loginPassword = sc.next();

            boolean loginSuccess = login.loginUser(loginUsername, loginPassword);
            System.out.println(login.returnLoginStatus(loginSuccess));
        }
    }
}
