package id.kelompok2.projectmanagement.employees;

import id.kelompok2.projectmanagement.data.EmployeeData;
import id.kelompok2.projectmanagement.projects.Project;

public class ProjectManager extends Person {
	private Project[] projects;
	
	private int currentProject;
	
	private double salary;

	public ProjectManager(String name, long id, double salary) {
		super(name, id, salary);
		projects = new Project[100];
		currentProject = 0;
		new EmployeeData().addProjectManager(this);
	}

	public Project[] getProjects() {
		return projects;
	}

	public Project getProject(int id) {
		return projects[id];
	}

	public void createProject(int projectId, String projectName, String projectClient) {
		projects[currentProject] = new Project(projectId, projectName, projectClient);
		currentProject++;
	}
	
	public void assignProject(long programmerId, int projectId) {
		for(Project proj: projects) {
			if(proj.getId() == projectId) {
				Programmer programmer = new EmployeeData().findProgrammer(programmerId);
				if(programmer != null) {
					proj.addProgrammer(programmer);
				}
				else System.out.println("ID programmer yang anda masukkan salah!");
				return;
			}
		}
		System.out.println("ID project yang anda masukkan salah!");
	}
	
	public void unAssignProject(long programmerId, int projectId) {
		for(Project proj: projects) {
			if(proj.getId() == projectId) {
				Programmer programmer = new EmployeeData().findProgrammer(programmerId);
				if(programmer != null) {
					proj.removeProgrammer(programmer);
				}
			}
		}
	}
	
	public void deleteProject(int projectId) {
		for(int i = 0; i < currentProject; i++) {
			if(projects[i].getId() == projectId) {
				projects[i] = null;
				for(int j = i; j < currentProject; j++) {
					projects[j] = projects[j+1];
				}
				projects[currentProject] = null;
				currentProject--;
			}
		}
    }

	public double getSalary() {
		return salary;
	}

	public void setSalary(double Salary) {
		salary = Salary;
	}
}