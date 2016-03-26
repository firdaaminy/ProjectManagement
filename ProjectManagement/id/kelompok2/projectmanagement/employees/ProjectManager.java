package id.kelompok2.projectmanagement.employees;

import id.kelompok2.projectmanagement.data.App;
import id.kelompok2.projectmanagement.projects.Project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;

public class ProjectManager extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;
    private ArrayList<Project> projects;
	
    private double salary;
    private static App app;

    public ProjectManager(String name, long id, double salary, String password) {
            super(name, id, salary, password);
            projects = new ArrayList<>();
            app = null;
    }

    public static void setApp(App app) {
        ProjectManager.app = app;
    }

    public ArrayList<Project> getProjects() {
            return projects;
    }

    public Project getProject(int id) {
            return projects.get(id);
    }

    public void createProject(int projectId, String projectName, String projectClient) {
            projects.add(new Project(projectId, projectName, projectClient));
            try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Projects.txt", true)))) {
            	out.println(this.getName()+" "+projectId+" "+projectName+" "+projectClient);
            } catch (IOException e) {
				e.printStackTrace();
			}
    }
    
    public void recreateProject(int projectId, String projectName, String projectClient) {
    	projects.add(new Project(projectId, projectName, projectClient));
    }

    public int findProject(Project project){
        int id=0;
        boolean ketemu=false;
        for(int i=0; i<projects.size();i++){
            if (projects.get(i)==project){
                ketemu=true;
                id=i;
            }
        }
        if(ketemu==true){
            return id;
        }
        else{
            return -1;
        }
    }

    public Project findProject(int projectId) {
        for(Project project: projects) {
            if(project != null) {
                if(project.getId() == projectId) {
                    return project;
                }
            }
        }
        return null;
    }

    public void assignProject(Programmer programmer, int projectId) {
        Project project = findProject(projectId);
        project.addProgrammer(programmer);
    }

/*    public void unAssignProject(long programmerId, int projectId) {
            for(Project proj: projects) {
                    if(proj.getId() == projectId) {
                            Programmer programmer = findProgrammer(programmerId);
                            if(programmer != null) {
                                    proj.removeProgrammer(programmer);
                            }
                    }
            }
    }*/

    public void deleteProject(Project project){
        projects.remove(project);
    } 

    @Override
    public double getSalary() {
            return salary;
    }

    @Override
    public void setSalary(double Salary) {
            salary = Salary;
    }

}