package id.kelompok2.projectmanagement.data;

import id.kelompok2.projectmanagement.console.ConsoleMain;
import Database.Database;
import id.kelompok2.projectmanagement.employees.Person;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class App implements Serializable {
    /**
    * 
    */
    private static final long serialVersionUID = -1L;
    private List<ProjectManager> projMans;
    private List<Programmer> programmers;
    private Database database;
    
    public App() {
        projMans = new ArrayList<>();
        programmers = new ArrayList<>();
    }
    
    public void projectInit() {
    	String projectMan, projectName, projectClient;
    	int projectId;
    	try(BufferedReader br = new BufferedReader(new FileReader("Projects.txt"))) {
    	    for(String line; (line = br.readLine()) != null; ) {
    	    	String[] lineVals = line.split(" ");
    	    	projectMan = lineVals[0];
    	    	projectId = Integer.parseInt(lineVals[1]);
    	    	projectName = lineVals[2];
    	    	projectClient = lineVals[3];
    	    	ProjectManager projMan = (ProjectManager) findUser(projectMan);
    	    	projMan.recreateProject(projectId, projectName, projectClient);
    	    }
    	} catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProgrammer(Programmer programmer) {
        programmers.add(programmer);
    }
    
    public void addProjectManager(ProjectManager projectManager) {
        projMans.add(projectManager);
    }
    
    public void removeProgrammer(Programmer programmer) {
        programmers.remove(programmer);
    }
    
    public void removeProjectManager(ProjectManager projectManager) {
        projMans.remove(projectManager);
    }
    
    public List<ProjectManager> getProjectManagers() {
        return projMans;
    }
    
    public List<Programmer> getProgrammers() {
    	return programmers;
    }
    
    public Person findUser(String username) {
        for(Person p: programmers) {
            if(p != null) {
                if(p.getName().equalsIgnoreCase(username)) {
                        return p;
                }
            }
        }
        for(Person p: projMans) {
            if(p != null) {
                if(p.getName().equalsIgnoreCase(username)) {
                        return p;
                }
            }
        }
        return null;
    }

//    public void userLogin(String username, String password) {
//        Person person = ConsoleMain.app.findUser(username);
//        if(person == null) {
//            System.out.println("Wrong username!");
//        }
//        else {
//            String uname="select * from user where username="+username+";";
//            ResultSet result1=database.getData(uname);
//            String pass="select * from user where password= "+password+";";
//            ResultSet result2=database.getData(pass);
//            ProjectManager proMan=new ProjectManager();
//        }
//    }
}
