/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.data.Application;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam
 */
public class ConsoleLogin {
    private Application app;   
            
    public ConsoleLogin() {
        Console.clearScreen();
        app = new Application();
        run();
    }
    
    public final void run() {
        loginRegisterMenu();
    }
    
    public void loginRegisterMenu() {
        Console.clearScreen();
        System.out.println("WELCOME TO ON-BOARD, YOUR PROJECT MANAGEMENT SOLUTION");
        System.out.println("1. Login");
        System.out.println("2. Register");
        int pilihan = Integer.parseInt(Console.inputQuestion("Pilihan"));
        switch(pilihan) {
            case 1:
                loginScreen();
                break;
            case 2:
                registerScreen();
                break;
            default:
                System.out.println("Pilihan yang anda masukkan salah!");
                break;
        }
    }
    
    public void loginScreen() {        
        Console.clearScreen();
        System.out.println("ON-BOARD - PROJECT MANAGEMENT - LOGIN");
        String username = Console.inputQuestion("Username");
        String password = Console.inputQuestion("Password");
        try {
            app.userLogin(null, username, password);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void registerScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
