/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iwan Ma'ruf
 */
public class ProjectManager extends Person {

    Project[] projects;
    int currentProject;
    
    public ProjectManager(String name, long id, double salary) {
        super(name, id, salary);
        currentProject=0;
    }
    
    public ProjectManager (String name, long id){
        super(name,id);
        currentProject=0;
    }
    
    public Project[] getProjects(){
        return projects;
    }
    
    public Project getProject(int id){
        return projects[id];
    }
    
    public void createProject(){
        projects[currentProject]=new Project();
    }
    
}
