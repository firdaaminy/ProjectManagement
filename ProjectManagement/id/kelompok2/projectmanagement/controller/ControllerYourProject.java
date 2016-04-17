/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.database.Database;
import id.kelompok2.projectmanagement.view.ListProject;
import id.kelompok2.projectmanagement.view.ListTeam;
import id.kelompok2.projectmanagement.view.NewProject;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iwan Ma'ruf
 */
public class ControllerYourProject implements ActionListener{
    private ListProject YP;
    private Database database;
    private ControllerDashboard dash;
    
    public ControllerYourProject(ControllerDashboard cd){
        for(Component comp: cd.getComponents()) {
            JPanel content = (JPanel) comp;
            if(content instanceof ListProject) {
                YP = (ListProject) content;
                YP.addListener(this);                
            }
        }
        dash = cd;
        populateTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Object oo =  e.getSource();
        if(oo.equals(YP.getBtnSearchYP())){
            clearRow();
            try {
                ResultSet rs = dash.getApplication().searchProject(YP.getSearchText());
                DefaultTableModel modelTable=(DefaultTableModel) this.YP.getTableYourProject().getModel();
                while(rs.next()){
                    modelTable.addRow(new Object[]{rs.getString(2), rs.getString(3), rs.getString(6)});
                }
            } catch (Exception ex) {
                Logger.getLogger(ControllerYourProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void clearRow(){
        DefaultTableModel modelTable = (DefaultTableModel) YP.getTableYourProject().getModel();
        modelTable.setRowCount(0);
    }

    public void populateTable() {
        try {
            clearRow();
            ResultSet rs = dash.getApplication().getAllProjects();
            DefaultTableModel tableModel = (DefaultTableModel) YP.getTableYourProject().getModel();
            while(rs.next()) {
                tableModel.addRow(new Object[]{rs.getString("name"),rs.getString("client"), "", (rs.getBoolean("done")? "Done": "Not done")});        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerYourTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        YP.resetText();
    }
}
