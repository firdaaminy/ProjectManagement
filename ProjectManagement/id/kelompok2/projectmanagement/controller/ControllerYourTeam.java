/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.database.Database;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Iwan Ma'ruf
 */
public class ControllerYourTeam implements ActionListener {

    private ListTeam YT;
    private Database db;
    private ControllerDashboard dash;
    
    public ControllerYourTeam(ControllerDashboard cd) {
        for(Component comp: cd.getComponents()) {
            JPanel content = (JPanel) comp;
            if(content instanceof ListTeam) {
                YT = (ListTeam) content;
                YT.addListener(this);                
            }
        }
        dash = cd;
        populateTable();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object oo =  e.getSource();
        if(oo.equals(YT.getBtnSearchYT())){        
            clearRow();
            try {
                String search = YT.getJxSearchId().getText();
                ResultSet rs = dash.getApplication().searchListTeam(search);
                DefaultTableModel modelTable = (DefaultTableModel) YT.getTableMember().getModel();
                while(rs.next())
                {
                    modelTable.addRow(new Object[]{rs.getInt(1),rs.getString(2), rs.getDouble(5), ""});
                }
            } catch (Exception ex) {
                Logger.getLogger(ControllerYourTeam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void clearRow(){
        DefaultTableModel modelTable = (DefaultTableModel) this.YT.getTableMember().getModel();
        modelTable.setRowCount(0);
    }

    public void populateTable() {
        try {
            clearRow();
            ResultSet rs = dash.getApplication().getAllProgrammers();
            DefaultTableModel tableModel = (DefaultTableModel) YT.getTableMember().getModel();
            while(rs.next()) {
                tableModel.addRow(new Object[]{rs.getInt("id"),rs.getString("username"), rs.getDouble("salary"), ""});        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerYourTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        YT.resetText();
    }
}
