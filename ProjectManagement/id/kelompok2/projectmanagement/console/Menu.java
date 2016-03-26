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
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

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
    		System.out.println("2. User Details");
        	try {
    			switch(Integer.parseInt(inputPilihan("Pilih menu"))) {
    				case 1:
    					programmer.getOngoingProjects();
    					break;
    				case 2:
    					System.out.println("Username: "+ programmer.getName());
    					System.out.println("Salary: "+ String.valueOf(programmer.getSalary()));
    					System.out.println("ID: "+ programmer.getId());
    					break;
    			}
    		} catch (NumberFormatException | IOException e) {
    			e.printStackTrace();
    		}
    	}
    	else if(Driver.getUser() instanceof ProjectManager) {
    		ProjectManager projectManager = (ProjectManager) Driver.getUser();
    		System.out.println("1. Create Project");
    		System.out.println("2. See Projects");
    		System.out.println("3. Hire A Programmer");
    		System.out.println("4. See Programmers");
    		try {
    			switch(Integer.parseInt(inputPilihan("Pilih menu"))) {
	    			case 1:
	    				createProject();
	    				break;
    			}
    		} catch(NumberFormatException | IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    private void createProject() {
    	try {
			String projectName = inputPilihan("Masukkan nama project");
	    	int projectId = Integer.parseInt(inputPilihan("Masukkan ID project"));
	    	String projectClient = inputPilihan("Masukkan Client project");
	    	if(!projectExists(projectId)) {
		    	ProjectManager projMan = (ProjectManager) Driver.getUser();
		    	projMan.createProject(projectId, projectName, projectClient);
	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean projectExists(int projectId) {
    	int pId;
    	boolean exists = false;
    	try(BufferedReader br = new BufferedReader(new FileReader("Projects.txt"))) {
    	    for(String line; (line = br.readLine()) != null; ) {
    	    	String[] lineVals = line.split(" ");
    	    	pId = Integer.parseInt(lineVals[1]);
    	    	if(pId == projectId) exists = true;
    	    }
    	} catch (IOException e) {
			e.printStackTrace();
		}
		return exists;
	}

	public String inputPilihan(String question) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print(question+": ");
        String a = br.readLine();
		return a;
    }
    
/*    public static void main(String[] main) throws IOException {
        inputPilihan();
    }*/
}
