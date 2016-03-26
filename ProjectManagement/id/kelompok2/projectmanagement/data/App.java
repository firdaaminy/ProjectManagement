package id.kelompok2.projectmanagement.data;

import id.kelompok2.projectmanagement.console.ConsoleMain;
import id.kelompok2.projectmanagement.employees.Person;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class App implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;
	private List<ProjectManager> projMans;
    private List<Programmer> programmers;
//    private static Person user;
    
    public App() {
        projMans = new ArrayList<>();
        programmers = new ArrayList<>();
//        user = null;
        Programmer.setApp(this);
        ProjectManager.setApp(this);
    }
    
 /*   public static void setUser(Person person) {
    	user = person;
    }
    
    public static Person getUser() {
    	return user;
    }
    */
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
        programmers.remove(projectManager);
    }
    
    public List<ProjectManager> getProjectManagers() {
        return projMans;
    }
    
    public List<Programmer> getProgrammers() {
    	return programmers;
    }
    
    public void serialize() {
    	FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("App.txt");
	    	ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	    	objectOut.writeObject(this);
	    	objectOut.flush();
	    	objectOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public App deSerialize() {
    	FileInputStream fileIn;
    	App app;
		try {
			fileIn = new FileInputStream("App.txt");
	    	ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	    	app = (App) objectIn.readObject();
	    	objectIn.close();
	    	return app;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
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
}
