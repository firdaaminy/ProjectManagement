/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.kelompok2.projectmanagement.employees;

import id.kelompok2.projectmanagement.data.EmployeeData;

/**
 *
 * @author Iwan Ma'ruf
 */
public class Programmer extends Person{
    	
    public Programmer(String name, long id, double salary){
        super(name, id, salary);
        new EmployeeData().addProgrammer(this);
    }
}
