/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.data.Application;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;
import id.kelompok2.projectmanagement.projects.Project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;
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
            LinkedList<Project> projects = new LinkedList<>();
            while(rs.next()) {
                projects.add(new Project(rs.getInt("id"), rs.getString("name"), 
                        rs.getString("client"), rs.getString("description")));
            }

            int idx = 0;
            while(true) {
                if(idx == -1)
                    return;
                
                int projId = projects.get(idx).getProjectId();
                
                clearScreen();
                System.out.println("------ ("+ projId +") ------");
                System.out.println("Project's Name: "+ projects.get(idx).getProjectName());
                System.out.println("Project's Client: "+ projects.get(idx).getProjectClient());
                System.out.println("Project's Description: "+ projects.get(idx).getProjectDesc());
                System.out.println("Progress: "+ app.getProgress(projId) +"%");
                System.out.println();
                
                if(Application.getUser() instanceof Programmer)
                    rs = app.getMyTasks(projects.get(idx).getProjectId());
                else
                    rs = app.getAllTasks(projects.get(idx).getProjectId());
                
                while(rs.next()) {
                    System.out.println("Task 0"+ rs.getInt("id") +": "+ rs.getString("taskdescription"));
                    System.out.println("Status: "+ (rs.getBoolean("done")? "Done": "Not done"));
                    if(Application.getUser() instanceof ProjectManager)
                        System.out.println("Programmer: "+ rs.getString("username"));
                    
                    System.out.println();
                }
                
                if(Application.getUser() instanceof ProjectManager) {
                    System.out.println("1. Create a Task");
                    System.out.println("2. Assign Programmer");
                }
                
                System.out.println("Enter the ID of the task (0X) to change its status!");
                String action;
                if(Application.getUser() instanceof ProjectManager)
                     action = inputQuestion("Action (next/prev/menu's number/exit/task ID)");
                else action = inputQuestion("Action (next/prev/exit/task ID)");
                switch(action) {
                    case "next":
                        if((idx+1) < projects.size()) {
                            idx += 1;
                        }
                        else idx = 0;
                        break;
                    case "prev":
                        if((idx-1) > -1) {
                            idx -= 1;
                        }
                        else idx = projects.size()-1;
                        break;
                    case "exit":
                        idx = -1;
                        break;
                   case "1":
                        createTask(projId);
                        break;
                    case "2":
                        assignProgrammer(projId);
                        break;
                    default:
                        toggleStatus(projId, action);
                        break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
        promptEnterKey();
    }
    
    public void assignProgrammer(int projId) {
        try {
            String nameOrId = inputQuestion("Enter programmer's name or ID");
            ResultSet rs = app.searchUser(nameOrId);
            if(rs.next()) {
                app.assignProject(projId, rs.getString("userName"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void toggleStatus(int projId, String action) {
        if(action.charAt(0) == '0') {
            action = action.substring(1);
            try {
                app.toggleDoneTask(projId, Integer.parseInt(action));
            } catch (SQLException ex) {
                System.out.println("ERROR: "+ ex.getMessage());
                promptEnterKey();
            }
        }
        else return;
    }
    
    public void showUserDetail() {
        clearScreen();
        System.out.println("------ ("+ Application.getUser().getName() +") ------");
        System.out.println("Name: "+ Application.getFullName());
        System.out.println("Salary: "+ Application.getUser().getSalary());
        System.out.println("Position: "+ (Application.getUser() instanceof Programmer?
                                            "Programmer": "Project Manager"));
        System.out.println();
        promptEnterKey();
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
    
    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    
    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showProgrammers() {
        clearScreen();
        try {
            ResultSet rs = app.getAllProgrammers();
            while(true) {
                System.out.println("------ ("+ rs.getString("userName") +") ------");
                System.out.println("Name: "+ rs.getString("fullName"));
                System.out.println("Email: "+ rs.getString("email"));
                System.out.println("Salary: "+ rs.getString("salary"));
                System.out.println();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
        promptEnterKey();
    }

    private void createTask(int projId) {
        String taskDesc = inputQuestion("Enter task's description: ");
        try {
            app.createTask(projId, taskDesc);
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
    }
}
