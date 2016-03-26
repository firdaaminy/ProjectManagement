/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;
import id.kelompok2.projectmanagement.projects.Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    		System.out.println("1. Create Project");
    		System.out.println("2. See Projects");
    		System.out.println("3. Hire A Programmer");
    		System.out.println("4. See Programmers");
    		try {
    			switch(Integer.parseInt(inputPilihan("Pilih menu"))) {
	    			case 1:
	    				createProject();
	    				break;
	    			case 2:
	    				printProjects();
	    				break;
	    			case 3:
	    				createProgrammer();
	    				break;
    			}
    		} catch(NumberFormatException | IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    private void printProjects() {
    	System.out.println("PROJECTS OF "+ Driver.getUser().getName().toUpperCase());
    	ProjectManager projMan = (ProjectManager) Driver.getUser();
    	for(Project proj: projMan.getProjects()) {
    		if(proj != null) {
    			System.out.println(proj.getId()+". "+ proj.getName());
    		}
    	}
    	try {
    		int projId = Integer.parseInt(inputPilihan("Masukkan Project ID (0 untuk kembali): "));
    		if(projectExists(projId)) {
    			showMenuProject(projId);
    		}
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
	}

	private void showMenuProject(int projId) {
		ProjectManager projMan = (ProjectManager) Driver.getUser();
		Project proj = projMan.findProject(projId);
		System.out.println("Project: "+ proj.getName() +"("+ proj.getId() +")");
		System.out.println("Client: "+ proj.getClient());
		for(Programmer programmer: proj.getProgrammers()) {
			if(programmer != null) {
				System.out.println("Programmer: "+ programmer.getName());
			}
		}
		System.out.println("============ MENU ===============");
		System.out.println("1. Create Task");
		System.out.println("2. Assign Programmer To Project");
		System.out.println("3. Remove Programmer From Project");
		try {
			switch(Integer.parseInt(inputPilihan("Masukkan pilihan anda: "))) {
				case 1:
					proj.addTask(inputPilihan("Masukkan nama task: "), 
							Integer.parseInt(inputPilihan("Masukkan ID Task: ")));
					break;
				case 2:
					Programmer prog = getProgrammer(inputPilihan("Masukkan ID/Nama Programmer: "));
					if(prog != null) {
						projMan.assignProject(prog, proj.getId());
					}
					else System.out.println("ID/Nama yang anda masukkan salah!");
					break;
				case 3:
					Programmer uProg = getProgrammer(inputPilihan("Masukkan ID/Nama Programmer: "));
					if(uProg != null) {
						projMan.unassignProject(uProg, proj.getId());
					}
					break;
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private Programmer getProgrammer(String inputPilihan) {
		boolean number = true;
		long num = 0;
		try {
			num = Integer.parseInt(inputPilihan);
		} catch(NumberFormatException | NullPointerException e) {
			number = false;
		}
		if(number) {
			for(Programmer p: ConsoleMain.app.getProgrammers()) {
				if(p != null) {
					if(p.getId() == num) {
						return p;
					}
				}
			}
		}
		else {
			for(Programmer p: ConsoleMain.app.getProgrammers()) {
				if(p != null) {
					if(p.getName().equalsIgnoreCase(inputPilihan)) {
						return p;
					}
				}
			}
		}
		return null;
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
	    	else {
	    		System.out.println("ID yang anda masukkan sudah digunakan!");
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

	public void createProgrammer() {
		try {
			String namaProgrammer = inputPilihan("Masukkan nama programmer: ");
			String idProgrammer = inputPilihan("Masukkan ID programmer: ");
			String gajiProgrammer = inputPilihan("Masukkan gaji programmer: ");
			String passwordProgrammer = inputPilihan("Masukkan password untuk programmer: ");
			if(getProgrammer(namaProgrammer) == null && getProgrammer(idProgrammer) == null) {
				ConsoleMain.app.getProgrammers().add(new Programmer(namaProgrammer, Integer.parseInt(idProgrammer), Double.parseDouble(gajiProgrammer), passwordProgrammer));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
/*    public static void main(String[] main) throws IOException {
        inputPilihan();
    }*/
}
