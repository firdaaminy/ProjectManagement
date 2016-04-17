/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.data.Application;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;
import id.kelompok2.projectmanagement.view.EditProfile;
import id.kelompok2.projectmanagement.view.Home;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class ControllerHome {
    private Home home;
    private ControllerDashboard dash;
    
    public ControllerHome(ControllerDashboard cd) {
        for(Component comp: cd.getComponents()) {
            JPanel content = (JPanel) comp;
            if(content instanceof Home) {
                home = (Home) content;              
            }
        }
        dash = cd;
        updateData();
    }
    
    public void updateData() {
        home.setLabelName(Application.getFullName());
        home.setTxFullname(Application.getFullName());
        home.setTxPosition((Application.getUser() instanceof Programmer? "Programmer": "ProjectManager"));
        try {
            home.setTxSince(dash.getApplication().getMemberSince(Application.getUser()));
        } catch (Exception ex) {
            Logger.getLogger(ControllerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setTxUsername(Application.getUser().getName());
    }
}
