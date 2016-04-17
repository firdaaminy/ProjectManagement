/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.view.AddProgrammer;
import id.kelompok2.projectmanagement.view.NewProject;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class ControllerNewProject implements ActionListener {
    private NewProject newProject;
    private ControllerDashboard dash;
    
    public ControllerNewProject(ControllerDashboard cd) {
        for(Component comp: cd.getComponents()) {
            JPanel content = (JPanel) comp;
            if(content instanceof NewProject) {
                newProject = (NewProject) content;
                newProject.addListener(this);                
            }
        }
        dash = cd;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(newProject.getBtnCancel())) {
            dash.showHome();
            newProject.clearFields();
        }
        else if(source.equals(newProject.getBtnCreate())) {
            String projName = newProject.getProjectName();
            String projClient = newProject.getProjectClient();
            String projDesc = newProject.getProjectDesc();
            try {
                dash.getApplication().createProject(projName, projClient, projDesc);
                JOptionPane.showMessageDialog(newProject, "You added "+ projName +" as your project!");
                dash.showHome();
                newProject.clearFields();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(newProject, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ControllerNewProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
