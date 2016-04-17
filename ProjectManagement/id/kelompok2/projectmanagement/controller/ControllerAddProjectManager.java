/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.view.Login;
import id.kelompok2.projectmanagement.view.Dashboard;
import id.kelompok2.projectmanagement.view.AddProjectManager;
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
 * @author Abbi PC
 */
public class ControllerAddProjectManager implements ActionListener {
    private AddProjectManager addProg;
    private ControllerDashboard dash;
     
    public ControllerAddProjectManager(ControllerDashboard cd){
        for(Component comp: cd.getComponents()) {
            JPanel content = (JPanel) comp;
            if(content instanceof AddProjectManager) {
                addProg = (AddProjectManager) content;
                addProg.addListener(this);                
            }
        }
        dash = cd;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object a = e.getSource();
        if (a.equals(addProg.getJbCancel())){
            dash.showHome();
            addProg.clearFields();
        }
        else if (a.equals((addProg.getJbCreate()))){
            String name = addProg.getProgrammerName();
            Double salary = Double.parseDouble(addProg.getProgrammerSalary());
            String password = addProg.getProgrammerPassword();
            try {
                dash.getApplication().signUp("", "", name, password, null, "", 99);
                JOptionPane.showMessageDialog(addProg, "You added "+ name +" as programmer!");
                dash.showHome();
                addProg.clearFields();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(addProg, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ControllerAddProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
