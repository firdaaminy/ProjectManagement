/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Iwan Ma'ruf
 */
public class Menu {
    Person user;
    
    void showMenuSatu() {
        System.out.println("Menu satu");
        System.out.println("");
        
        
    }
    
    void logIn(){
        String username = null, password = null;
        System.out.println("Masukkan username: ");
        System.out.println("Masukkan password: ");
        if(username.equals("ASD") && password.equals("DSA")) {
            user = 
        }
    }
    
    void showAll() {
        System.out.println("asdasdasdsad");
    }
    
    static void inputPilihan() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        
        System.out.print("A: ");
        String a = br.readLine();
    }
    
    public static void main(String[] main) throws IOException {
        inputPilihan();
    }
}
