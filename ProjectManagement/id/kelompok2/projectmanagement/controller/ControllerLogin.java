/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.data.Application;
import id.kelompok2.projectmanagement.view.View;
import id.kelompok2.projectmanagement.view.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Iwan Ma'ruf
 */
public class ControllerLogin implements ActionListener {
    private View view;
    private Application app;
    
    public ControllerLogin(){
        app=new Application();
        Login login = new Login();
        login.setVisible(true);
        login.addListener(this);
        login.setLocationRelativeTo(null);
        view = login;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object a = e.getSource();
        if (view instanceof Login){
            Login login = (Login) view;
            if (a.equals(login.getBtnLogin())){
                try {
                    app.userLogin(login, login.getUser(), login.getPass());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(login, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(a.equals(login.getBtnSignUp())) {
                String name = login.getFirstName() +" "+ login.getLastName();
                String email = login.getEmail();
                String userName = login.getUserSignup();
                String passWord = login.getPassSignup();
                Date birthDate = login.getBirthDate();
                String gender = null;
                if(login.getRadioFemale().isSelected()) {
                    gender = "Female";
                }
                else if(login.getRadioMale().isSelected()) {
                    gender = "Male";
                }
                try {
                    app.signUp(name, email, userName, passWord, birthDate, gender, 1);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(login, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
