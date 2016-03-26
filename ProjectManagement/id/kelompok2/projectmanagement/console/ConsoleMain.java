package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.data.App;
import id.kelompok2.projectmanagement.data.Company;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;

public class ConsoleMain {
/*    public static void main(String[] args) {
	Company company = new Company();
	System.out.println("Testing...");
	company.addProgrammer(new Programmer("Firda", 1333333, 10000000));
	company.addProjectManager(new ProjectManager("Aminy", 1301140381, 1000000));
	company.addProgrammer(new Programmer("Maruf", 1301031, 10285281));
	
	company.findProjectManager(1301140381);
	
	ProjectManager projMan = company.findProjectManager(1301140381);
	Programmer programmer = company.findProgrammer(1301031);
	System.out.println("DEBUG MAIN: "+ programmer.getName());
	projMan.createProject(1, "Tubes", "Telkom");
	projMan.createProject(2, "Tubes 2", "Telkom");
	System.out.println("DEBUG MAIN: "+ projMan.getProject(0).getName());
	projMan.assignProject(company, 1301031, 1);
        projMan.assignProject(company, 1301031, 2);
//	System.out.println(company.findProgrammer(1301031).getOngoingProjects(company)[1].getName());//
    }*/
    public static void main(String[] args) {
        App app = new App();
        ProjectManager adam = new ProjectManager("Adam", 1301140381, 10000000);
        Programmer adam2 = new Programmer("Geraldy", 1830411031, 100000000);
        app.addProgrammer(adam2);
        app.addProjectManager(adam);
        
        adam.createProject(1, "Tubes", "Telkom");
        adam.assignProject(adam2, 1);
        
        System.out.println(adam2.getOngoingProjects().get(0).getName());
    }
}
