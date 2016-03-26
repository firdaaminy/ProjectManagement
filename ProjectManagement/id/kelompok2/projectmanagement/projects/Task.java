package id.kelompok2.projectmanagement.projects;

public class Task {
	private String taskName;
	private int taskId;
	private boolean done=false;
        private double kesulitan;

	public Task(String taskName, int taskId) {
		this.taskName = taskName;
		this.taskId = taskId;
	}

	public String getName() {
		return taskName;
	}

	public int getId() {
		return taskId;
	}

	public void setName(String taskName) {
		this.taskName = taskName;
	}

	public void setId(int taskId) {
		this.taskId = taskId;
	}

	public boolean getStatuS() {
		return done;
	}

	public void setStatus(boolean done) {
		this.done = done;
	}
        
    public double getKesulitan(){
        return kesulitan;
    }
    
    public void setKesulitan(double kesulitan){
        this.kesulitan=kesulitan;
    }
}
