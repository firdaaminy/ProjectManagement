/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.data;

import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam
 */
public class App {
    List<ProjectManager> projMans;
    List<Programmer> programmers;
    
    public App() {
        this.projMans = new ArrayList<>();
        this.programmers = new ArrayList<>();
        System.out.println("Running application...");
        Programmer.setApp(this);
        ProjectManager.setApp(this);
    }
    
    public void addProgrammer(Programmer programmer) {
        programmers.add(programmer);
    }
    
    public void addProjectManager(ProjectManager projectManager) {
        projMans.add(projectManager);
    }
    
    public void removeProgrammer(Programmer programmer) {
        programmers.remove(programmer);
    }
    
    public void removeProjectManager(ProjectManager projectManager) {
        programmers.remove(projectManager);
    }
    
    public List<ProjectManager> getProjectManagers() {
        return projMans;
    }
}
