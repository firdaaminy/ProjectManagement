/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iwan Ma'ruf
 */
public abstract class Person {
    private String name;
    private long id;
    private double salary;
    
    public Person(String name, long id, double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    
    public Person(String name, long id){
        this.name=name;
        this.id=id;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setId(long id){
        this.id=id;
    }
    
    public void setSalary(double salary){
        this.salary=salary;
    }
    
    public String getName(){
        return name;
    }
    
    public long getId(){
        return id; 
    }
    
    public double getSalary(){
        return salary;
    }
}
