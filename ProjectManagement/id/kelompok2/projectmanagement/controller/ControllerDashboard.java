/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.data.Application;
import id.kelompok2.projectmanagement.view.Dashboard;
import id.kelompok2.projectmanagement.view.View;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class ControllerDashboard implements ActionListener {

    private View view;
    private Component visibleContent;
    private Dashboard dashboard;
    private Application app;
    
    // Controllers
    private ControllerAddProgrammer cAddProg;
    private ControllerNewProject cNewProj;
    private ControllerYourProject cYourProj;
    private ControllerYourTeam cYourTeam;
    
    public ControllerDashboard(Application app) {
        dashboard = new Dashboard();
        dashboard.setVisible(true);
        dashboard.addListener(this);
        dashboard.setGreetingLabel(Application.getFullName());
        view = dashboard;
        this.app = app;
        cAddProg = new ControllerAddProgrammer(this);
        cNewProj = new ControllerNewProject(this);
        cYourProj = new ControllerYourProject(this);
        cYourTeam = new ControllerYourTeam(this);
    }
    
    public Application getApplication() {
        return app;
    }
    
    public Dashboard getDashboard() {
        return dashboard;
    }
    
    public Component getVisibleComponent() {
        Dashboard dash = (Dashboard) view;
        for(Component comp: dash.getContentPanel().getComponents()) {
            if(comp.isVisible()) {
                visibleContent = comp;
            }
        }
        return visibleContent;
    }
    
    public Component[] getComponents() {
        return dashboard.getContentPanel().getComponents();
    }
    
    public void showHome() {
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "HomePanel");
    }
    
    public void showListTeam() {
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "ListTeamPanel");
        cYourTeam.populateTable();
    }
    
    public void showAddProgrammer() {
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "AddProgrammerPanel");
    }
    
    public void showListProject() {
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "ListProjectPanel");
        cYourProj.populateTable();
    }
    
    public void showNewProject() {
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "NewProjectPanel");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(dashboard.getBtnHome())) {
            showHome();
        }
        else if(source.equals(dashboard.getBtnYourTeam())) {
            showListTeam();
        }
        else if(source.equals(dashboard.getBtnMembers())) {
            showAddProgrammer();
        }
        else if(source.equals(dashboard.getBtnProjects())) {
            showListProject();
        }
        else if(source.equals(dashboard.getBtnNewProject())) {
            showNewProject();
        }
    }
}
