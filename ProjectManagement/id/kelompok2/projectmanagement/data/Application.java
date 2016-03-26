package id.kelompok2.projectmanagement.data;

import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;
import id.kelompok2.projectmanagement.projects.Project;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iwan Ma'ruf
 */
public class Application {
    private static ArrayList<ProjectManager> daftarManajerProyek=new ArrayList<>();
    private static ArrayList<Programmer> daftarProgrammer=new ArrayList<>();
    Scanner in = new Scanner(System.in);
    
    public static void addManajerProyek(ProjectManager projMan){
        daftarManajerProyek.add(projMan);
    }
    
    public static void addProgrammer(Programmer programmer){
        daftarProgrammer.add(programmer);
    }
    
    public static Programmer getProgrammer(int id) {
    	return daftarProgrammer.get(id);
    }
    
    public static void deleteProgrammer(Programmer programmer){
        daftarProgrammer.remove(programmer);
    }
    
    public void startProject (int login){
        System.out.println("Please enter the ID of the project: ");
        int id = in.nextInt();
        System.out.println("Please enter the name of the project: ");
        String name = in.next();
        System.out.println("Please enter the name of the project : ");
        String client = in.next();
        daftarManajerProyek.get(login).createProject(id,name,client);
    }
    
    public void checkProgress(int login){
        double tampung=0;
        double total=0;
        ArrayList<Project> proyek=new ArrayList<>();
        proyek=daftarManajerProyek.get(login).getProjects();
        
        for (int i=0; i<proyek.size();i++){
            System.out.println((i+1)+". Nama project: "+proyek.get(i).getName());
        }
        System.out.println("Masukkan nomor proyek yang anda ingin check: ");
        int id=in.nextInt();
        
        for(int i=0;i<proyek.get(id).getTasks().size();i++){
            if(proyek.get(id).getTasks().get(i).getStatuS()==true){
                tampung=tampung+proyek.get(id).getTasks().get(i).getKesulitan();
                total=total+proyek.get(id).getTasks().get(i).getKesulitan();
            }
            total=total+proyek.get(id).getTasks().get(i).getKesulitan();
        }
        System.out.println("Progress dari project adalah: "+(tampung/total*100)+"%");
    }
}
