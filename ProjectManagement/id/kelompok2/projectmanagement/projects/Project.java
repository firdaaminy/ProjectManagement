/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.kelompok2.projectmanagement.projects;

import id.kelompok2.projectmanagement.employees.Programmer;
import java.util.ArrayList;

/**
 *
 * @author Iwan Ma'ruf
 */
public class Project {
    private int projectId;
    private String projectName;
    private String projectClient;
    private ArrayList<Programmer> programmers;
    private ArrayList<Task> tasks;
        
    public Project(int projectId, String projectName, String projectClient){
        this.projectId=projectId;
        this.projectName=projectName;
        this.projectClient=projectClient;
        programmers = new ArrayList<>();
        tasks = new ArrayList<>();
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
    
    public void addTask(String name, int taskId) {
    	tasks.add(new Task(name, taskId));
    }
}