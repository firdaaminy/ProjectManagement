package id.kelompok2.projectmanagement.employees;

import id.kelompok2.projectmanagement.projects.Project;

public class ProjectManager extends Person {
	
	Project[] projects;
	int currentProject;
	
	public ProjectManager(String name, long id) {
		super(name, id);
		currentProject = 0;
	}
	
	public ProjectManager(String name, long id, double salary) {
		super(name, id, salary);
		currentProject = 0;
	}
	
	public Project[] getProjects() {
		return projects;
	}
	
	public Project getProject(int id) {
		return projects[id];
	}
	
	public void createProject() {
		projects[currentProject] = new Project();
	}
	
}
