/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.kelompok2.projectmanagement.employees;

import id.kelompok2.projectmanagement.data.App;
import id.kelompok2.projectmanagement.projects.Project;
import java.util.ArrayList;

/**
 *
 * @author Iwan Ma'ruf
 */
public class Programmer extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;
    private static App app;
    
    public Programmer(String name, long id, double salary, String password){
        super(name, id, salary, password);
    }
    
    public static void setApp(App app) {
        Programmer.app = app;
    }
    
    public ArrayList<Project> getOngoingProjects() { //munculin project yang lagi di kerjain 
    	ArrayList<Project> arrayProject = new ArrayList<>();
    	for(ProjectManager pMan: app.getProjectManagers()) {
    		if(pMan != null) {
    			for(Project proj: pMan.getProjects()) {
    				if(proj != null) {
    					for(Programmer programmer: proj.getProgrammers()) {
    						if(programmer != null) {
    							if(programmer == this) {
    								arrayProject.add(proj);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	return arrayProject;
    }
}

