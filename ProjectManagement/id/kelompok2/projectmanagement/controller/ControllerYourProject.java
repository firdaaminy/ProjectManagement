/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.database.Database;
import id.kelompok2.projectmanagement.view.YourProject;
import id.kelompok2.projectmanagement.view.YourTeam;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iwan Ma'ruf
 */
public class ControllerYourProject implements ActionListener{
    YourProject YP;
    Database database;
    
    public ControllerYourProject(){
        try {
            YP=new YourProject();
            database=new Database();
            
            YP.setVisible(true);
            YP.addListener(this);
        } catch (Exception ex) {
            Logger.getLogger(ControllerYourProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Object oo =  e.getSource();
        if(oo.equals(YP.getBtnSearchYP())){
            clearRow();
        try {
            ResultSet rs=database.getData("select * from projects where name= '"+YP.getJxSearch().getText()+"' or client= '"+YP.getJxSearch().getText()+"'");
//            System.out.println("select * from projects where name= '" +YP.getJxSearch().getText()+"' or client= '"+YP.getJxSearch().getText()+"'");
            List<Object> data=new ArrayList<Object>();
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
        try{
            DefaultTableModel modelTable=(DefaultTableModel) this.YP.getTableYourProject().getModel();
            for(int i=0;i<modelTable.getRowCount();i++){
                modelTable.removeRow(0);
            }
        } catch (Exception e){
            
        }
    }
}
