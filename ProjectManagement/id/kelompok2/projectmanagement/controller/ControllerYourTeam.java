/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.database.Database;
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
public class ControllerYourTeam implements ActionListener {

    YourTeam YT;
    Database db;
    
    public ControllerYourTeam() {
        try {
            YT= new YourTeam();
            db = new Database();
            
            YT.setVisible(true);
            YT.addListener(this);
        } catch (Exception ex) {
            Logger.getLogger(ControllerYourTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object oo =  e.getSource();
        if(oo.equals(YT.getBtnSearchYT())){
            clearRow();
            try {
                ResultSet rs= db.getData("select * from user where id= '"+YT.getJxSearchId().getText()+"' or fullName='"+YT.getJxSearchId().getText()+"'");
//                System.out.println("select * from user where id= "+YT.getJxSearchId().getText()+"or fullName='"+YT.getJxSearchId().getText()+"'");
                List<Object> data = new ArrayList<Object>();
                DefaultTableModel modelTable = (DefaultTableModel) this.YT.getTableMember().getModel();
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
        try {
            DefaultTableModel modelTable = (DefaultTableModel) this.YT.getTableMember().getModel();
            for(int i = 0;i<modelTable.getRowCount();i++){
                modelTable.removeRow(0);
            }
        } catch (Exception e) {
        }
    }
}
