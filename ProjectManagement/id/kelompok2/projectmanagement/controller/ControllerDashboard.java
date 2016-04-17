/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.controller;

import id.kelompok2.projectmanagement.data.Application;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;
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
    private ControllerAddProjectManager cAddProj;
    private ControllerNewProject cNewProj;
    private ControllerYourProject cYourProj;
    private ControllerYourTeam cYourTeam;
    private ControllerEditProfile cEditProf;
    private ControllerHome cHome;
    private ControllerAssignProject cAssignProj;
    private ControllerCheckProgress cCheckProgress;
    private ControllerSettings cSettings;
    private ControllerAssignedTask cAssignedTask;
    
    public ControllerDashboard(Application app) {
        this.app = app;
        dashboard = new Dashboard();
        dashboard.setVisible(true);
        dashboard.addListener(this);
        setGreetingLabel(Application.getFullName());
        view = dashboard;
        cAddProj = new ControllerAddProjectManager(this);
        cNewProj = new ControllerNewProject(this);
        cYourProj = new ControllerYourProject(this);
        cYourTeam = new ControllerYourTeam(this);
        cEditProf = new ControllerEditProfile(this);
        cHome = new ControllerHome(this);
        cAssignProj = new ControllerAssignProject(this);
        cCheckProgress = new ControllerCheckProgress(this);
        cSettings = new ControllerSettings(this);
        cAssignedTask = new ControllerAssignedTask(this);
        if(Application.getUser() instanceof Programmer) {
            dashboard.getjLabel2().setVisible(false);
            dashboard.getBtnMembers().setVisible(false);
            dashboard.getLabel3().setVisible(false);
            dashboard.getBtnNewProject().setVisible(false);
            dashboard.getBtnSettings().setVisible(false);
        }
        showHome();
    }
    
    public void setGreetingLabel(String name) {
        dashboard.getGreetingLabel().setText("Hello, "+ name);
        dashboard.getPositionLabel().setText((Application.getUser() instanceof ProjectManager?
                "Project Manager": "Programmer"));
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
        cHome.updateData();
    }
    
    public void showListTeam() {
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "ListTeamPanel");
        cYourTeam.populateTable();
    }
    
    public void showAddProjectManager() {
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "AddProjectManagerPanel");
    }
    
    public void showListProject() {
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "ListProjectPanel");
        cYourProj.populateTable();
    }
    
    public void showNewProject() {
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "NewProjectPanel");
    }
    
    public void showEditProfile() {
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "EditProfilePanel");
    }
    
    public void showAssignProject(int projId, String projName) {
        cAssignProj.setText(projId, projName);
        cAssignProj.clearFields();
        cAssignProj.setText(projId, projName);
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "AssignProjectPanel");
    }
    
    public void showAssignedTask(int projId, String projName) {
        cAssignedTask.setLabel(projId, projName);
        cAssignedTask.populateTable();
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "AssignedTaskPanel");
    }

    public void showCheckProgress() {
        cCheckProgress.clearFields();
        cCheckProgress.populateSelector();
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "ProgressCheckPanel");
    }
    
    public void showSettings() {
        cSettings.clearFields();
        dashboard.getCardLayout().show(dashboard.getContentPanel(), "SettingsPanel");
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
            showAddProjectManager();
        }
        else if(source.equals(dashboard.getBtnProjects())) {
            showListProject();
        }
        else if(source.equals(dashboard.getBtnNewProject())) {
            showNewProject();
        }
        else if(source.equals(dashboard.getBtnEditProfile())) {
            showEditProfile();
        }
        else if(source.equals(dashboard.getBtnGraph())) {
            showCheckProgress();
        }
        else if(source.equals(dashboard.getBtnSettings())) {
            showSettings();
        }
    }
}
