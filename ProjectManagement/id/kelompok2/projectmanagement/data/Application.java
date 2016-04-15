/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.data;

import Database.Database;
import id.kelompok2.projectmanagement.controller.ControllerLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iwan Ma'ruf
 */
public class Application {
    private Database database;
    
    public void userLogin(String username, String password) {
        try {
            ResultSet resultset=null;
            String uname = "select (username,password) from user where username= '" + username + "'";
            
            try {
                resultset = database.getData(uname);
            } catch (Exception ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            String temp=resultset.getString(1);
            if(password.equals(temp)){
                ControllerLogin cl= new ControllerLogin();
                cl.goToDashboard();
            }
            else if(resultset==null){
                
            }
            else{
                //JOptionPane.showConfirmDialog(,"salah password");
            }
                
//            String pass = "select * from user where password= " + password + ";";
//            ResultSet result2 = database.getData(pass);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
