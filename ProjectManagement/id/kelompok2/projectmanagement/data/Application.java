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
    
    public static Person getUser() {
        return user;
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
            rs = database.getData("select * from user where (id= '"+search+"' or fullName='"+search+"' or "
                    + "username = '"+ search +"') and tipeUser = 1");
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet searchProject(String searchText) {
        ResultSet rs = null;
        if(user instanceof ProjectManager) {
            try {
                rs=database.getData("select * from projects where (name= '"+searchText+"' or client= '"+searchText+"' or id = '"+ searchText+"') and managerid = '"
                        + user.getId() +"'");
            } catch (Exception ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(user instanceof Programmer) {
            try {
                rs = database.getData("select * from projects left join projects_assignment on "
                        + "projects.id = projects_assignment.projectid where (name = '"+searchText+"' or client = '"
                        +searchText +"' or id = '"+ searchText+"') and programmerid = '"+ user.getId() +"'");
            } catch (Exception ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        if(user instanceof ProjectManager) {
            try {
                rs = database.getData("select * from projects where managerid = '"+ user.getId() +"'");
            } catch (Exception ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(user instanceof Programmer) {
            try {
                rs = database.getData("select * from projects left join projects_assignment on projects.id = projects_assignment.projectid"
                        + " where programmerid = '"+ user.getId() +"'");
            } catch (Exception ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rs;
    }

    public void editUser(String fullName, String newEmail, String newPass, String oldPass) throws SQLException {
        if(oldPass.equals(user.getPassword())) {
            String query = "update user set fullname = ?, email = ?, password = ? where id = ?";
            PreparedStatement prepare = database.getConnection().prepareStatement(query);
            prepare.setString(1, fullName);
            prepare.setString(2, newEmail);
            prepare.setString(3, newPass);
            prepare.setInt(4, (int) user.getId());
            prepare.executeUpdate();
        }
    }

    public String getMemberSince(Person user) throws SQLException, Exception {
        ResultSet rs = null;
        rs = database.getData("select timestamp from user where id = '"+ user.getId() +"'");
        if(rs.next())
            return rs.getString("timestamp");
        return "NULL";
    }

    public void assignProject(int projId, String programmerName) throws Exception {
        int programmerId = 0;
        ResultSet rs = database.getData("select id from user where username = '"+ programmerName +"'");
        if(rs.next()) programmerId = rs.getInt("id");
        String query = "insert into projects_assignment values (?, ?, null)";
        PreparedStatement prepare = database.getConnection().prepareStatement(query);
        prepare.setInt(1, projId);
        prepare.setInt(2, programmerId);
        prepare.executeUpdate();
    }

    public void createTask(int projId, String text) throws SQLException {
        String query = "insert into tasks (taskdescription, projectid) values (?, ?)";
        PreparedStatement prepare = database.getConnection().prepareStatement(query);
        prepare.setString(1, text);
        prepare.setInt(2, projId);
        prepare.executeUpdate();
    }

    public String getDeadline(int projId) {
        String query = "select * from projects where id = '"+ projId +"'";
        ResultSet rs;
        try {
            rs = database.getData(query);
            if(rs.next()) {
                return rs.getString("deadline");
            }
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "N/A";
    }
    
    public int getProgress(int projId) {
        try {
            String query = "select * from projects left join tasks on projects.id = tasks.projectid where projects.id = '"
                    +projId+"'";
            ResultSet rs = database.getData(query);
            int difficulties = 0, donedifficulties = 0;
            while(rs.next()) {
                if(rs.getBoolean("tasks.done")) {
                    donedifficulties += rs.getInt("difficulties");
                }
                difficulties += rs.getInt("difficulties");
            }
            if(difficulties == 0) return 0;
            return (donedifficulties/difficulties*100);
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ResultSet getMyTasks(int projectId) {
        ResultSet rs = null;
        String query = "select * from tasks where projectid = '"+ projectId +"' and programmerid = '"+
                user.getId()+ "'";
        System.out.println(query);
        try {
            rs = database.getData(query);
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void toggleDoneTask(int projId, String done) throws SQLException {
        String query = "update tasks set done = ? where projectid = ?";
        PreparedStatement prepare = database.getConnection().prepareStatement(query);
        prepare.setBoolean(1, (done.equals("Done")? false: true));
        prepare.setInt(2, projId);
        prepare.executeUpdate();
    }
}
