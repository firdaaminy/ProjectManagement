package id.kelompok2.projectmanagement.employees;

import id.kelompok2.projectmanagement.data.Company;
import id.kelompok2.projectmanagement.projects.Project;
import java.util.ArrayList;
import java.util.ListIterator;

/*public class ProjectManager extends Person {
	private Project[] projects;
	private int currentProject;
	
	private double salary;

	public ProjectManager(String name, long id, double salary) {
		super(name, id, salary);
		projects = new Project[100];
		currentProject = 0;
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
	
	public void assignProject(Company company, long programmerId, int projectId) {
		for(Project proj: projects) {
			if(proj != null) {
				if(proj.getId() == projectId) {
					System.out.println("DEBUG ProjectManager.assignProject: "+ programmerId);
					Programmer programmer = company.findProgrammer(programmerId);
					System.out.println("DEBUG ProjectManager.assignProject: "+ programmer.getName());
					if(programmer != null) {
						System.out.println(programmer.getName());
						proj.addProgrammer(programmer);
					}
					return;
				}
			}
		}
		System.out.println("ID project yang anda masukkan salah!");
	}
	
	public void unAssignProject(long programmerId, int projectId) {
		for(Project proj: projects) {
			if(proj.getId() == projectId) {
				Programmer programmer = findProgrammer(programmerId);
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
*/
public class ProjectManager extends Person {
	private ArrayList<Project> projects;
	private int currentProject;
	
	private double salary;

	public ProjectManager(String name, long id, double salary) {
		super(name, id, salary);
		projects = new ArrayList<>();
		currentProject = 0;
	}

	public ArrayList getProjects() {
		return projects;
	}

	public Project getProject(int id) {
		return projects.get(id);
	}

	public void createProject(int projectId, String projectName, String projectClient) {
		projects.add(new Project(projectId, projectName, projectClient));
		currentProject++;
	}
	
	public void assignProject(Company company, long programmerId, int projectId) {
		boolean found=false;
		Programmer programmer = company.findProgrammer(programmerId);
		System.out.println("DEBUG ProjectManager.assignProject: "+ programmer.getName());
		if(programmer != null) {
			System.out.println(programmer.getName());
			for(Project proj: projects) {
				if(proj.getId() == projectId) {
					found=true;
					System.out.println("DEBUG ProjectManager.assignProject: "+ programmerId);
					proj.addProgrammer(programmer);
				}
			}
		}
		if (!found)
		System.out.println("ID project yang anda masukkan salah!");
	}
	
	public void unAssignProject(long programmerId, int projectId) {
		for(Project proj: projects) {
			if(proj.getId() == projectId) {
				Programmer programmer = findProgrammer(programmerId);
				if(programmer != null) {
					proj.removeProgrammer(programmer);
				}
			}
		}
	}
	
	public void deleteProject(Project project) {
		ListIterator listIterator = projects.listIterator();
		while(listIterator <> project){
			listIterator.next();
		}
		listIterator.remove();
		currentProject--;
    } 

	public double getSalary() {
		return salary;
	}

	public void setSalary(double Salary) {
		salary = Salary;
	}
}