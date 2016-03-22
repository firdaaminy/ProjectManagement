package id.kelompok2.projectmanagement.data;

import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;
import java.util.ArrayList;

/*public class Company {

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
*/
public class Company {

	private ArrayList<Programmer> programmers;
	private ArrayList<ProjectManager> projectManagers;
	
	private int programmerCount, projManCount;
	
	public Company() {
		programmers = new ArrayList<>();
		projectManagers = new ArrayList<>();
		programmerCount = 0;
		projManCount = 0;
	}
	
	public void addProgrammer(Programmer programmer) {
		programmers.add(programmer);
		programmerCount++;
		System.out.println("DEBUG Company.addProgrammer: "+ programmerCount);
	}
	
	public void addProjectManager(ProjectManager projMan) {
		projectManagers.add(projMan);
		projManCount++;
	}
	
	public ArrayList<ProjectManager> getProjectManagers() {
		return projectManagers;
	}
	
	public ArrayList<Programmer> getProgrammers() {
		return programmers;
	}	
	
	public Programmer findProgrammer(long id) {
		System.out.println("DEBUG Company.java: "+ id);
		System.out.println("DEBUG Company.java: "+programmerCount);
		for(Programmer p : programmers) {
			if(p.getId() == id) {
				System.out.println("DEBUG: Company.java: "+ p.getName());
				return p;
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