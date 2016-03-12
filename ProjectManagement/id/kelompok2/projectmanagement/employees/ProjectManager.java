package id.kelompok2.projectmanagement.employees;

import id.kelompok2.projectmanagement.projects.Project;

public class ProjectManager extends Person
{
    private Project[] projects;
    private int numOfProjects;
    private double salary;

public ProjectManager(String name, long id, double salary){
    super(name, id, salary);
}

public Project[] getProjects(){
        return projects;
    }

public Project getProject(int id){
    return projects[id];
}

public void createProject(){
    
}
public assignProject(long id){
    
}
public unassignProject(long id){
}

public assignTask(Programmer programmer, Project project, Task task){
}

public deleteProject(int pid){
}

public double getSalary(){
    return salary;
}

public void setSalary(double Salary){
    
}
}
