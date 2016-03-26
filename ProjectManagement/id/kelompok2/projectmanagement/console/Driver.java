/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.employees.Person;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Febby
 */
public class Driver {
    private Person user;
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        Console console = System.console();

        System.out.println("Project Management Application");
        System.out.println("You need to login to proceed!");
        try {
            System.out.print("Username: ");
            String username = br.readLine();
            System.out.print("Password: ");
            if(console != null) {
                char[] password = null;
                password = console.readPassword();
                System.out.println(password);
            }
            else {
                String password = null;
                password = br.readLine();
                System.out.println(password);
                userLogin(username, password);
            }
        } catch (IOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void userLogin(String username, String password) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(username);
        lines.add(password);
        Path file = Paths.get(username+".txt");
        File f = new File(file.toString());
        if(f.exists()) {
            Files.readAllLines(file);
            if(password.equals(lines.get(1))) {
                Programmer programmer = new Programmer()
            }
        }
        else System.out.println("Wrong username!");
    }
}
