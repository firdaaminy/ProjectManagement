/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.data;

import id.kelompok2.projectmanagement.controller.ControllerDashboard;
import id.kelompok2.projectmanagement.database.Database;
import id.kelompok2.projectmanagement.controller.ControllerLogin;
import id.kelompok2.projectmanagement.employees.Person;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;
import id.kelompok2.projectmanagement.view.Login;
import java.sql.Date;
import java.sql.PreparedStatement;
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
    private static Person user;
    
    public Application() {
        try {
            database = new Database();
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void userLogin(Login login, String username, String password) {
        ResultSet resultSet=null;
        String uname = "select * from user where username= '" + username + "'";
        try {
            resultSet = database.getData(uname);
            if(resultSet.next()) {
                String temp=resultSet.getString("password");
                if(password.equals(temp)) {
                    if(resultSet.getInt("tipeUser") == 99) {
                        user = new ProjectManager(username, resultSet.getInt("id"), 
                                resultSet.getDouble("salary"), temp);
                    }
                    else if(resultSet.getInt("tipeUser") == 1) {
                        user = new Programmer(username, resultSet.getInt("id"), resultSet.getDouble("salary"),
                                temp);
                    }
                    user.setFullName(resultSet.getString("fullName"));
                    login.dispose();
                    ControllerDashboard dash = new ControllerDashboard(this);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getFullName() {
        return user.getFullName();
    }

    public void signUp(String name, String email, String userName, String passWord, 
            Date birthDate, String gender, int userType) throws SQLException {
        String query = "insert into user (username, password, email, birthday, gender, fullName, tipeUser)"
                + " values(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement prepare = database.getConnection().prepareStatement(query);
        prepare.setString(1, userName);
        prepare.setString(2, passWord);
        prepare.setString(3, email);
        prepare.setDate(4, birthDate);
        prepare.setString(5, gender);
        prepare.setString(6, name);
        prepare.setInt(7, userType);
        database.updateQuery(prepare);
    }
    
    public void createProject(String projName, String projClient, String projDesc) throws SQLException {
        String query = "insert into projects(name, client, description, managerid, deadline)"
                + " values(?, ?, ?, ?, now()+interval 7 day)";
        PreparedStatement prepare = database.getConnection().prepareStatement(query);
        prepare.setString(1, projName);
        prepare.setString(2, projClient);
        prepare.setString(3, projDesc);
        prepare.setInt(4, (int) user.getId());
        database.updateQuery(prepare);
    }

    public ResultSet searchListTeam(String search) {
        ResultSet rs = null;
        try {
            rs = database.getData("select * from user where id= '"+search+"' or fullName='"+search+"'");
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet searchProject(String searchText) {
        ResultSet rs = null;
        try {
            rs=database.getData("select * from projects where name= '"+searchText+"' or client= '"+searchText+"' and managerid = '"
                    + user.getId() +"'");
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;       
    }

    public ResultSet getAllProgrammers() {
        ResultSet rs = null;
        try {
            rs = database.getData("select * from user where tipeUser = '1'");
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getAllProjects() {
        ResultSet rs = null;
        try {
            rs = database.getData("select * from projects where managerid = '"+ user.getId() +"'");
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
