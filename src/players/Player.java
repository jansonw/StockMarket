package players;

import job.JobBase;

public class Player {
	private String name;
	private int boardLocation = -1;
	private JobBase job;
	private int cash = 0;
	
	public Player(String name, JobBase job) {
		this.name = name;
		this.job = job;
		cash = 0;
	}
	
	public void incrementCash(int amount) {
		cash += amount;
	}
	
	public void decrementCash(int amount) {
		cash -= amount;
	}

	public int getCash() {
		return cash;
	}
	
	public void resetCashToZero() {
		cash = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setJob(JobBase job) {
		this.job = job;
	}
	
	public JobBase getJob() {
		return this.job;
	}
	
	public void setBoardLocation(int boardLocation) {
		this.boardLocation = boardLocation;
	}
	
	public int getBoardLocation() {
		return this.boardLocation;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", boardLocation=" + boardLocation
				+ ", job=" + job + ", cash=" + cash + "]";
	}
	
	
	
}
