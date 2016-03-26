package id.kelompok2.projectmanagement.projects;

import java.io.Serializable;

public class Task implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1L;
	private String taskName;
	private int taskId;
	private boolean done=false;
    private double kesulitan;

	public Task(String taskName, int taskId, double kesulitan) {
		this.taskName = taskName;
		this.taskId = taskId;
		this.kesulitan = kesulitan;
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

	public boolean getStatus() {
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
