package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.data.Company;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;

public class ConsoleMain {
	public static void main(String[] args) {
		Company company = new Company();
		System.out.println("Testing...");
		company.addProgrammer(new Programmer("Adam", 1333333, 10000000));
		company.addProjectManager(new ProjectManager("Mada", 1301140381, 1000000));
		company.addProgrammer(new Programmer("Adam3", 1301031, 10285281));
		
		company.findProjectManager(1301140381);
		
		ProjectManager projMan = company.findProjectManager(1301140381);
		Programmer programmer = company.findProgrammer(1301031);
		System.out.println("DEBUG MAIN: "+ programmer.getName());
		projMan.createProject(1, "Tubes", "Telkom");
		System.out.println("DEBUG MAIN: "+ projMan.getProject(0).getName());
		projMan.assignProject(company, 1301031, 1);
		System.out.println(company.findProgrammer(1301031).getOngoingProjects(company)[0].getName());
	}
}
