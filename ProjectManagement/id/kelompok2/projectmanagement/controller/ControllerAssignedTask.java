/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.view.AssignedTask;
import id.kelompok2.projectmanagement.view.ListProject;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adam
 */
public class ControllerAssignedTask {
    private AssignedTask assignedTask;
    private ControllerDashboard dash;
    private int projID;
    
    public ControllerAssignedTask(ControllerDashboard cd) {
        for(Component comp: cd.getComponents()) {
            JPanel content = (JPanel) comp;
            if(content instanceof AssignedTask) {
                assignedTask = (AssignedTask) content;
            }
        }
        dash = cd;
        assignedTask.getTableTasks().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int projId;
                    int row = assignedTask.getTableTasks().getSelectedRow();
                    String projName = (String) assignedTask.getTableTasks().getValueAt(row, 1);
                    String done = assignedTask.getTableTasks().getValueAt(row, 2).toString();
                    try {
                        dash.getApplication().toggleDoneTask(projID, done);
                        assignedTask.getTableTasks().setValueAt((done.equals("Done")? "Not done": "Done"), row, 2);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerAssignedTask.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    public void setLabel(int projectId, String projectName) {
        projID = projectId;
        assignedTask.getLabelProject().setText(projectName);
    }
    
    public void clearRow(){
        DefaultTableModel modelTable = (DefaultTableModel) assignedTask.getTableTasks().getModel();
        modelTable.setRowCount(0);
    }

    public void populateTable() {
        try {
            clearRow();
            ResultSet rs = dash.getApplication().getMyTasks(projID);
            DefaultTableModel tableModel = (DefaultTableModel) assignedTask.getTableTasks().getModel();
            while(rs.next()) {
                tableModel.addRow(new Object[]{rs.getInt("id"), rs.getString("taskdescription"), (rs.getBoolean("done")? "Done": "Not done")});        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerYourTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
