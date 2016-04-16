/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.view.Login;
import id.kelompok2.projectmanagement.view.Dashboard;
import id.kelompok2.projectmanagement.view.AddProgrammer;
import id.kelompok2.projectmanagement.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Abbi PC
 */
public class ControllerAddProgrammer implements ActionListener {
    private View view;
    private AddProgrammer login;
     
    public ControllerAddProgrammer(){
        login = new AddProgrammer();
        login.setVisible(true);
        login.addListener(this);
        view = login;
    }

    public void goToDashboard(){
        Dashboard dash = new Dashboard();
        dash.setVisible(true);
        dash.addListener(this);
        view = dash;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object a = e.getSource();
        if (e.equals(login.getJbCancel())){
        
        }
        else if (e.equals((login.getJbCreate()))){
            
        }
    }
}
