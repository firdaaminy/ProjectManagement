/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.kelompok2.projectmanagement.projects;

import id.kelompok2.projectmanagement.employees.Programmer;

/**
 *
 * @author Iwan Ma'ruf
 */
public class Project {
    private int projectId;
    private String projectName;
    private String projectClient;
    private Programmer[] programmers;
    private Task[] tasks;
    
    private int numOfProgrammers;
    private int numOfTasks;
    
    public Project(int projectId, String projectName, String projectClient){
        this.projectId=projectId;
        this.projectName=projectName;
        this.projectClient=projectClient;
    }

    public Project() {
        System.out.println("Placeholder");
    }
    
    public int getId(){
        return projectId;
    }
    
    public String getName(){
        return projectName;
    }
    
    public String getClient(){
        return projectClient;
    }
    
    public void setId(int projectId){
        this.projectId=projectId;
    }
    
    public void setName(String projectName){
        this.projectName=projectName;
    }
    
    public void setClient(String projectClient){
        this.projectClient=projectClient;
    }
    
    public Programmer[] getProgrammers(){
        return programmers;
    }
    
    public void addProgrammer(Programmer programmer) {
    	if(programmer != null) {
    		programmers[numOfProgrammers] = programmer;
    		numOfProgrammers++;
    	}
    }

    public void removeProgrammer(Programmer programmer) {
    	if(programmer != null) {
    		for(int i = 0; i < numOfProgrammers; i++) {
    			if(programmer.getId() == programmers[i].getId()) {
    				programmers[i] = null;
    				for(int j = i; j < numOfProgrammers; j++) {
    					programmers[j] = programmers[j+1];
    				}
    				programmers[numOfProgrammers] = null;
    				numOfProgrammers--;
				}
    		}
    	}
    }
    
    public Task[] getTask(){
        return tasks;
    }
    
    public Task getTask(int id){
        return tasks[id];
    }
    
    public void addTask(String name, int taskId) {
    	tasks[numOfTasks] = new Task(name, taskId);
    	numOfTasks++;
    }
}
