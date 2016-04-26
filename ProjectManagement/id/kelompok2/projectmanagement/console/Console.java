/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.data.Application;
import id.kelompok2.projectmanagement.employees.Programmer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam
 */
public class Console {
    private Application app;
    private Menu menu;
    
    public Console(Application app) {
        this.app = app;
        menu = new Menu(app, this);
    }
    
    public void showMyProjects() {
        clearScreen();
        try {
            ResultSet rs = app.getAllProjects();
            while(rs.next()) {
                System.out.println("------ ("+ rs.getInt("id") +") ------");
                System.out.println("Project's Name: "+ rs.getString("name"));
                System.out.println("Project's Client: "+ rs.getString("client"));
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
    }
    
    public void showUserDetail() {
        clearScreen();
        System.out.println("------ ("+ Application.getUser().getName() +") ------");
        System.out.println("Name: "+ Application.getFullName());
        System.out.println("Salary: "+ Application.getUser().getSalary());
        System.out.println("Position: "+ (Application.getUser() instanceof Programmer?
                                            "Programmer": "Project Manager"));
        System.out.println();
    }
    
    public static String inputQuestion(String question) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print(question+": ");
        String a = null;
        try {
            a = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showProgrammers() {
        try {
            ResultSet rs = app.getAllProgrammers();
            while(rs.next()) {
                System.out.println("------ ("+ rs.getString("userName") +") ------");
                System.out.println("Name: "+ rs.getString("fullName"));
                System.out.println("Email: "+ rs.getString("email"));
                System.out.println("Salary: "+ rs.getString("salary"));
                System.out.println();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
