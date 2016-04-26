/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.data.Application;
import id.kelompok2.projectmanagement.employees.Person;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam
 */
public class Menu {
    private Application app;
    private Console console;
    
    public Menu(Application app, Console console) {
        this.app = app;
        this.console = console;
        run();
    }
    
    public final void run() {
        while(true) {
            showAllMenu();
        }
    }
    
    public void showAllMenu() {
        Console.clearScreen();
        Person user = Application.getUser();
        if(user instanceof Programmer) {
            System.out.println("1. Active Projects");
            System.out.println("2. User Details");
            switch(Integer.parseInt(Console.inputQuestion("Pilihan"))) {
                case 1:
                    console.showMyProjects();
                    break;
                case 2:
                    console.showUserDetail();
                    break;
                default:
                    break;
            }
        }
        else if(user instanceof ProjectManager) {
            System.out.println("*********************************************************");
            System.out.println("*+++>                  ON-BOARD                     <+++*");
            System.out.println("*=======================================================*");
            System.out.println("*          Everybody is on board with ON-BOARD          *");
            System.out.println("*        The easiest way to manage your projects        *");
            System.out.println("*                   NO FUSS, NO RUSH                    *");
            System.out.println("*=======================================================*");
            System.out.println("*               1. Start a new project                  *");
            System.out.println("*               2. Show all projects          		*");
            System.out.println("*               3. Create your team an account          *");
            System.out.println("*               4. Show available programmers           *");
            System.out.println("*               0. Log-out                              *");
            System.out.println("*********************************************************");
            switch(Integer.parseInt(Console.inputQuestion("Pilihan"))) {
                case 1:
                    startProject();
                    break;
                case 2:
                    console.showMyProjects();
                    break;
                case 3:
                    createTeamAccount();
                    break;
                case 4:
                    console.showProgrammers();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private void startProject() {
        System.out.println("*********************************************************");
        System.out.println("*   Starting a new project is easy with these 3 steps   *");
        System.out.println("*********************************************************");
        String projectName = Console.inputQuestion("What's the name of your project?");
        String projectClient = Console.inputQuestion("Who's your client for this project?");
        String projectDesc = Console.inputQuestion("What's your project's description?");
        try {
            app.createProject(projectName, projectClient, projectDesc);
        } catch (SQLException ex) {
            System.out.println("Project gagal dibuat: "+ ex.getMessage());
        }
    }

    private void createTeamAccount() {
        System.out.println("*********************************************************");
        System.out.println("*  Create an account for each of your project manager   *");
        System.out.println("*********************************************************");
        String userNameProgrammer = Console.inputQuestion("Enter manager's username");
        String fullNameProgrammer = Console.inputQuestion("Enter manager's full name");
        String passwordProgrammer = Console.inputQuestion("Enter manager's default password");
        try {
            app.signUp(fullNameProgrammer, "", userNameProgrammer, passwordProgrammer, null, "", 99);
        } catch (Exception ex) {
            System.out.println("Project Manager gagal dibuat: "+ ex.getMessage());
        }
    }
}
