/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.kelompok2.projectmanagement.projects;

import id.kelompok2.projectmanagement.employees.Programmer;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Iwan Ma'ruf
 */
/*public class Project {
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
        programmers = new Programmer[100];
        tasks = new Task[100];
        numOfProgrammers = 0;
        numOfTasks = 0;
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
    		System.out.println("DEBUG Project.addProgrammer: "+ programmer.getName());
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
*/
public class Project {
    private int projectId;
    private String projectName;
    private String projectClient;
    private ArrayList<Programmer> programmers;
    private ArrayList<Task> tasks;
    
    private int numOfProgrammers;
    private int numOfTasks;
    
    public Project(int projectId, String projectName, String projectClient){
        this.projectId=projectId;
        this.projectName=projectName;
        this.projectClient=projectClient;
        programmers = new ArrayList<>();
        tasks = new ArrayList<>();
        numOfProgrammers = 0;
        numOfTasks = 0;
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
    
    public ArrayList<Programmer> getProgrammers(){
        return programmers;
    }
    
    public void addProgrammer(Programmer programmer) {
    	if(programmer != null) {
    		System.out.println("DEBUG Project.addProgrammer: "+ programmer.getName());
    		programmers.add(programmer);
    		numOfProgrammers++;
    	}
    }

    public void removeProgrammer(Programmer programmer) {
    	programmers.remove(programmer);
    }
    
    public ArrayList<Task> getTask(){
        return tasks;
    }
    
    public Task getTask(int id){
        return tasks.get(id);
    }
    
    public void addTask(String name, int taskId) {
    	tasks.add(new Task(name, taskId));
    	numOfTasks++;
    }
}

