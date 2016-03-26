/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.employees.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam
 */
public class Driver {
    private static Person user;
    
	public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
