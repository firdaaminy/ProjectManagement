package id.kelompok2.projectmanagement.data;

import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;

public class Company {

	private Programmer[] programmers;
	private ProjectManager[] projectManagers;
	
	private int programmerCount, projManCount;
	
	public Company() {
		programmers = new Programmer[100];
		projectManagers = new ProjectManager[100];
		programmerCount = 0;
		projManCount = 0;
	}
	
	public void addProgrammer(Programmer programmer) {
		programmers[programmerCount] = programmer;
		programmerCount++;
		System.out.println("DEBUG Company.addProgrammer: "+ programmerCount);
	}
	
	public void addProjectManager(ProjectManager projMan) {
		projectManagers[projManCount] = projMan;
		projManCount++;
	}
	
	public ProjectManager[] getProjectManagers() {
		return projectManagers;
	}
	
	public Programmer[] getProgrammers() {
		return programmers;
	}	
	
	public Programmer findProgrammer(long id) {
		System.out.println("DEBUG Company.java: "+ id);
		System.out.println("DEBUG Company.java: "+programmerCount);
		for(int i = 0; i < programmerCount; i++) {
			if(programmers[i].getId() == id) {
				System.out.println("DEBUG: Company.java: "+ programmers[i].getName());
				return programmers[i];
			}
		}
		return null;
	}

	public ProjectManager findProjectManager(long id) {
		for(ProjectManager pMan: projectManagers) {
			if(pMan.getId() == id) return pMan;
		}
		return null;
	}
}