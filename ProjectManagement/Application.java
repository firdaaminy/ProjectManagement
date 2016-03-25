import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;
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
    private ArrayList<ProjectManager> daftarManajerProyek=new ArrayList<>();
    private ArrayList<Programmer> daftarProgrammer=new ArrayList<>();
    private ArrayList<Programmer> programmers=new ArrayList<>();
    
    public void addManajerProyek(ProjectManager projMan){
        daftarManajerProyek.add(projMan);
    }
    
    public void addProgrammer(Programmer programmer){
        daftarProgrammer.add(programmer);
    }
    
    public Programmer getProgrammer(int id) {
	return programmers.get(id);
    }
    
    public void deleteProgrammer(int id){
        
    }
    
    public void menuSatu (int login){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the ID of the project: ");
        int id = in.nextInt();
        System.out.println("Please enter the name of the project: ");
        String name = in.next();
        System.out.println("Please enter the name of the project : ");
        String client = in.next();
        daftarManajerProyek.get(login).createProject(id,name,client);
    }
}
