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
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class ControllerSettings implements ActionListener {
    private Settings settings;
    private ControllerDashboard dash;

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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
