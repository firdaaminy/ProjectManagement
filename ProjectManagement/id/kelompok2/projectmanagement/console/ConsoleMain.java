package id.kelompok2.projectmanagement.console;

import id.kelompok2.projectmanagement.data.App;
import id.kelompok2.projectmanagement.employees.Programmer;
import id.kelompok2.projectmanagement.employees.ProjectManager;

public class ConsoleMain {
	public static App app;
	
    public static void main(String[] args) {
//    	App app = new App();
//        ProjectManager adam = new ProjectManager("Adam", 1301140381, 10000000, "112233");
//        Programmer adam2 = new Programmer("Geraldy", 1830411031, 100000000, "anaktelkom");
//        app.addProgrammer(adam2);
//        app.addProjectManager(adam);
//
//        app.serialize();
//        
//        adam.createProject(1, "Tubes", "Telkom");
//        adam.assignProject(adam2, 1);
//        
//        System.out.println(adam2.getOngoingProjects().get(0).getName());
    	App app = new App();
    	app = app.deSerialize();
        app.projectInit();
    	ConsoleMain.app = app;
    	new Driver().run();
    }
}
