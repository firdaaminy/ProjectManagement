/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.data.App;
import id.kelompok2.projectmanagement.employees.Person;
import id.kelompok2.projectmanagement.employees.Programmer;

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
    public void run() {
    	while(true) {
    		showAllMenu();
    	}
    }
    
    void showMenuSatu() {
        System.out.println("Menu satu");
        System.out.println("");
        
        
    }
    
    public void showAllMenu() {
    	System.out.println("Welcome, "+ Driver.getUser().getName() +"!");
    	if(Driver.getUser() instanceof Programmer) {
    		Programmer programmer = (Programmer) Driver.getUser();
    		System.out.println("1. Active Projects");
    		System.out.println("2. Assigned Tasks");
        	try {
    			switch(Integer.parseInt(inputPilihan("Pilih menu"))) {
    				case 1:
    					programmer.getOngoingProjects();
    					break;
    				case 2:
    					System.out.println("Ho");
    					break;
    			}
    		} catch (NumberFormatException | IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public String inputPilihan(String question) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        
        System.out.print(question+": ");
        String a = br.readLine();
		return a;
    }
    
/*    public static void main(String[] main) throws IOException {
        inputPilihan();
    }*/
}
