/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.data.Application;
import id.kelompok2.projectmanagement.view.EditProfile;
import id.kelompok2.projectmanagement.view.NewProject;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class ControllerEditProfile implements ActionListener {
    private EditProfile editProfile;
    private ControllerDashboard dash;
    
    public ControllerEditProfile(ControllerDashboard cd) {
        for(Component comp: cd.getComponents()) {
            JPanel content = (JPanel) comp;
            if(content instanceof EditProfile) {
                editProfile = (EditProfile) content;
                editProfile.addListener(this);                
            }
        }
        dash = cd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(editProfile.getBtnCancel())) {
            dash.showHome();
        }
        else if(source.equals(editProfile.getBtnSave())) {
            String fullName = editProfile.getFullName();
            String newEmail = editProfile.getNewEmail();
            String newPass = editProfile.getNewPass();
            String oldPass = editProfile.getOldPass();
            
            try {
                dash.getApplication().editUser(fullName, newEmail, newPass, oldPass);
                JOptionPane.showMessageDialog(editProfile, "Data berhasil diupdate!");
                Application.getUser().setFullName(fullName);
                dash.setGreetingLabel(fullName);
                dash.showHome();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(editProfile, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ControllerEditProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
