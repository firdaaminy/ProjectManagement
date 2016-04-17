/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.view.CheckProgress;
import id.kelompok2.projectmanagement.view.ListTeam;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class ControllerCheckProgress implements ActionListener {
    private CheckProgress checkProgress;
    private ControllerDashboard dash;
    
    public ControllerCheckProgress(ControllerDashboard cd) {
        for(Component comp: cd.getComponents()) {
            JPanel content = (JPanel) comp;
            if(content instanceof CheckProgress) {
                checkProgress = (CheckProgress) content;
                checkProgress.addListener(this);                
            }
        }
        dash = cd;
        populateSelector();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(checkProgress.getProjectSelector())) {
            if(checkProgress.getProjectSelector().getSelectedItem() != null) {
                String value = checkProgress.getProjectSelector().getSelectedItem().toString();
                if(value.equals("Select a project")) {
                    clearFields();
                }
                else {
                    String[] projectDetails = value.split("\\. ");
                    System.out.println(projectDetails[1]);
                    int progress = dash.getApplication().getProgress(Integer.parseInt(projectDetails[0]));
                    checkProgress.getjProgressBar().setValue(progress);
                    checkProgress.getTxProgressDeadline().setText(dash.getApplication().getDeadline(Integer.parseInt(projectDetails[0])));
                    checkProgress.getTxProgressName().setText(projectDetails[1]);
                }
            }
        }
    }

    public void clearFields() {
        checkProgress.getTxProgressName().setText("");
        checkProgress.getTxProgressDeadline().setText("");
        checkProgress.getjProgressBar().setValue(0);
    }
    
    public void clearSelector() {
        checkProgress.getProjectSelector().removeAllItems();
    }
    
    public void populateSelector() {
        clearSelector();
        ResultSet rs = dash.getApplication().getAllProjects();
        try {
            checkProgress.getProjectSelector().addItem("Select a project");
            while(rs.next()) {
                checkProgress.getProjectSelector().addItem(rs.getInt("id") +". "+ rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCheckProgress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
