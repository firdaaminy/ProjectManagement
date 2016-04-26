/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.kelompok2.projectmanagement.projects;

import id.kelompok2.projectmanagement.employees.Programmer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Iwan Ma'ruf
 */
public class Project implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1L;
	private int projectId;
    private String projectName;
    private String projectClient;
    private String projectDesc;
    private ArrayList<Programmer> programmers;
    private ArrayList<Task> tasks;
        
    public Project(int projectId, String projectName, String projectClient, String projectDesc){
        this.projectId=projectId;
        this.projectName=projectName;
        this.projectClient=projectClient;
        this.projectDesc = projectDesc;
        programmers = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectClient() {
        return projectClient;
    }

    public void setProjectClient(String projectClient) {
        this.projectClient = projectClient;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }
    
    public ArrayList<Programmer> getProgrammers(){
        return programmers;
    }
    
    public void addProgrammer(Programmer programmer) {
    	if(programmer != null) {
    		programmers.add(programmer);
    	}
    }

    public void removeProgrammer(Programmer programmer) {
    	programmers.remove(programmer);
    }
    
    public ArrayList<Task> getTasks(){
        return tasks;
    }
    
    public Task getTask(int id){
        return tasks.get(id);
    }
    
    public void addTask(String name, int taskId, double kesulitan) {
    	tasks.add(new Task(name, taskId, kesulitan));
    }
    
    public double getTotalDifficulty() {
    	double total = 0;
    	for(Task task: tasks) {
    		total += task.getKesulitan();
    	}
    	return total;
    }
}