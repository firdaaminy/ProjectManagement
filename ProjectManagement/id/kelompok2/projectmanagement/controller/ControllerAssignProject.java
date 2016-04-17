/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.view.AssignProject;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class ControllerAssignProject implements ActionListener {
    private AssignProject assignProject;
    private ControllerDashboard dash;
    private int projId;
    private String programmerName;
    
    public ControllerAssignProject(ControllerDashboard cd) {
        for(Component comp: cd.getComponents()) {
            JPanel content = (JPanel) comp;
            if(content instanceof AssignProject) {
                assignProject = (AssignProject) content;
                assignProject.addListener(this);                
            }
        }
        dash = cd;
    }
    
    public void clearFields() {
        try {
            assignProject.getAssignTo().removeAllItems();
            assignProject.getComboProgTask().removeAllItems();
            assignProject.getComboTask().removeAllItems();
            assignProject.getTxDetail().setText("");
            List<String> programmers = new ArrayList<>();
            ResultSet rs = dash.getApplication().getAllProgrammers();
            while(rs.next()) {
                assignProject.getAssignTo().addItem(rs.getString("username"));
            }
            
            rs = dash.getApplication().getAssignedProgrammers(projId);
            while(rs.next()) {
                assignProject.getComboProgTask().addItem(rs.getString("username"));
            }
            
            rs = dash.getApplication().getIncompleteTasks(projId);
            while(rs.next()) {
                assignProject.getComboTask().addItem(rs.getInt("id")+". "+rs.getString("taskdescription"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAssignProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(assignProject.getBtnCancel()) || source.equals(assignProject.getBtnCancelTask())) {
            dash.showListProject();
        }
        else if(source.equals(assignProject.getBtnSend())) {
            try {
                programmerName = assignProject.getAssignTo().getSelectedItem().toString();
                dash.getApplication().assignProject(projId, programmerName);
                JOptionPane.showMessageDialog(assignProject, "Anda mengassign project untuk "+ programmerName +"!");
                dash.showHome();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(assignProject, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ControllerAssignProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(source.equals(assignProject.getBtnSubmitTask())) {
            try {
                dash.getApplication().createTask(projId, assignProject.getTxTaskDesc().getText());
                JOptionPane.showMessageDialog(assignProject, "Task berhasil dibuat!");
                dash.showHome();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(assignProject, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ControllerAssignProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(source.equals(assignProject.getBtnSubmitAssTask())) {
            String[] taskdetail = assignProject.getComboTask().getSelectedItem().toString().split("\\. ");
            String programmerName = assignProject.getComboProgTask().getSelectedItem().toString();
            try {
                dash.getApplication().assignTask(Integer.parseInt(taskdetail[0]), programmerName);
                JOptionPane.showMessageDialog(assignProject, "Task berhasil diassign ke "+ programmerName +"!");
                dash.showHome();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(assignProject, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ControllerAssignProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setText(int projId, String projName) {
        this.projId = projId;
        assignProject.setTxDetail(projName, projId);
    }
    
}
