/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iwan Ma'ruf
 */
public class Programmer extends Person{
    private String nama;
    private long id;
    private double salary;
    
    public Programmer(String nama, long id, double salary){
        this.nama=nama;
        this.id=id;
        this.salary=salary;
    }
    
    @Override
    public long getId(){
        return this.id;
    }
    
    @Override
    public void setId(long id){
        this.id=id;
    }
    
    @Override
    public double getSalary(){
        return this.salary;
    }
    
    @Override
    public void setSalary(double salary){
        this.salary=salary;
    }
}
