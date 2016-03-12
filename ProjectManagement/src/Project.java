/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iwan Ma'ruf
 */
public class Project {
    private int projectId;
    private String projectName;
    private String projectClient;
    private Programmer[] programmers;
    private Task[] task;
    
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
    
    public Task[] getTask(){
        return task;
    }
    
    public Task getTask(int id){
        return task[id];
    }
}
