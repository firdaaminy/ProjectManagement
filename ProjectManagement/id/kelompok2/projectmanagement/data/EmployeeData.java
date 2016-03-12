package id.kelompok2.projectmanagement.data;

import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;

public class EmployeeData {

	private Programmer[] programmers;
	private ProjectManager[] projectManagers;
	
	private int programmerCount, projManCount;
	
	public EmployeeData() {
		programmers = new Programmer[100];
		projectManagers = new ProjectManager[100];
		programmerCount = 0;
		projManCount = 0;
	}
	
	public void addProgrammer(Programmer programmer) {
		programmers[programmerCount] = programmer;
		programmerCount++;
	}
	
	public void addProjectManager(ProjectManager projMan) {
		projectManagers[projManCount] = projMan;
		projManCount++;
	}
	
	public Programmer findProgrammer(long id) {
		for(Programmer pro: programmers) {
			if(pro.getId() == id) return pro;
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