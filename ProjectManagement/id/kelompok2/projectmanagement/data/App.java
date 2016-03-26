package id.kelompok2.projectmanagement.data;

import id.kelompok2.projectmanagement.employees.Person;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
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
        this.serialize();
    }
    
    public void addProjectManager(ProjectManager projectManager) {
        projMans.add(projectManager);
        this.serialize();
    }
    
    public void removeProgrammer(Programmer programmer) {
        programmers.remove(programmer);
        this.serialize();
    }
    
    public void removeProjectManager(ProjectManager projectManager) {
        programmers.remove(projectManager);
        this.serialize();
    }
    
    public List<ProjectManager> getProjectManagers() {
        this.serialize();
        return projMans;
    }
    
    public List<Programmer> getProgrammers() {
        this.serialize();
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
