/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.view.ListProject;
import id.kelompok2.projectmanagement.view.Settings;
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
public class ControllerSettings implements ActionListener {
    private Settings settings;
    private ControllerDashboard dash;
    private int searchedId;

    public ControllerSettings(ControllerDashboard cd) {
        for(Component comp: cd.getComponents()) {
            JPanel content = (JPanel) comp;
            if(content instanceof Settings) {
                settings = (Settings) content;
                settings.addListener(this);                
            }
        }
        dash = cd;
    }
    
    public void clearFields() {
        settings.getTxSearch().setText("");
        settings.getTxPassword().setText("");
        settings.getTxUsername().setText("");
        settings.getTxSalary().setText("");
        searchedId = 0;
    }
    
    public void setTxPass(String pass) {
        settings.getTxPassword().setText(pass);
    }
    
    public void setTxUser(String user) {
        settings.getTxUsername().setText(user);
    }
    
    public void setTxSalary(String salary) {
        settings.getTxSalary().setText(salary);
    }
    
    public void setSearchedId(int id) {
        searchedId = id;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(settings.getBtnSubmit())) {
            dash.getApplication().searchUser(this, settings.getTxSearch().getText());
        }
        else if(source.equals(settings.getBtnSaveUser())) {
            try {
                dash.getApplication().updateUserUsername(searchedId, settings.getTxUsername().getText());
                JOptionPane.showMessageDialog(settings, "Username baru berhasil disave!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(settings, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ControllerSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(source.equals(settings.getBtnSaveSalary())) {
            try {
                dash.getApplication().updateUserSalary(searchedId, settings.getTxSalary().getText());
                JOptionPane.showMessageDialog(settings, "Salary baru berhasil disave!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(settings, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ControllerSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(source.equals(settings.getBtnSavePass())) {
            try {
                dash.getApplication().updateUserPassword(searchedId, settings.getTxPassword().getText());
                JOptionPane.showMessageDialog(settings, "Password baru berhasil disave!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(settings, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ControllerSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
