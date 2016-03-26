/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.data.App;
import id.kelompok2.projectmanagement.employees.Person;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;

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
 * @author Adam
 */
public class Driver {
    private static Person user;
    
    public static void main(String[] args) {
	}

	public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Console console = System.console();

        System.out.println("Project Management Application");
        System.out.println("You need to login to proceed!");
        try {
            System.out.print("Username: ");
            String username = br.readLine();
            System.out.print("Password: ");
            String password = null;
            password = br.readLine();
            userLogin(username, password);
        } catch (IOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
	public void userLogin(String username, String password) {
		Person person = ConsoleMain.app.findUser(username);
		if(person == null) {
			System.out.println("Username yang anda masukkan salah!");
		}
		else {
			String pass = person.getPassword();
			if(password.toString().equalsIgnoreCase(pass)) {
				System.out.println("Password benar!");
				user = person;
				new Menu().run();
			}
			else System.out.println("Password salah!");
		}
	}
	
	public static Person getUser() {
		return user;
	}
}
