package application;

public class Status {
	
	boolean task = false;
	boolean worker = false;
	
	//Helper method that sets the task as bought
	public void setTask () {
		task = true;
	}
	
	//Helper method that sets the worker of the specific task as bought
	public void setWorker() {
		worker = true;
	}
	
	//Helper method that returns the status of whether the task is or isn't bought
	public boolean taskCheck() {
		return task;
	}
	
	//Helper method that returns the status of whether the worker is or isn't bought
	public boolean workerCheck() {
		return worker;
	}
}
