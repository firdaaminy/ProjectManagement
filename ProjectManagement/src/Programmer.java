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
   
    private String name;
    
    public Programmer(String name, long id, double salary){
        super(name, id, salary);
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    
}
