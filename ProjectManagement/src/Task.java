/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iwan Ma'ruf
 */
public class Task {
    private String taskName;
    private int taskId;
    private boolean done;
    
    public Task(String taskName, int taskId){
        this.taskName=taskName;
        this.taskId=taskId;
    }
    
    public String getName(){
        return taskName;
    }
    
    public int getId(){
        return taskId;
    }
    
    public void setName(String taskName){
        this.taskName=taskName;
    } 
}
