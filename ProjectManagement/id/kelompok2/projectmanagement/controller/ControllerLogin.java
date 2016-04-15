/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.view.Dashboard;
import id.kelompok2.projectmanagement.view.View;
import id.kelompok2.projectmanagement.gui.CobaCobaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Iwan Ma'ruf
 */
public class ControllerLogin implements ActionListener {
    private View view;
    
    public ControllerLogin(){
        CobaCobaLogin login = new CobaCobaLogin();
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
        if (view instanceof CobaCobaLogin){
            CobaCobaLogin login = (CobaCobaLogin) view;
            if (a.equals(login.getBtnLogin())){
                login.dispose();
                goToDashboard();
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
