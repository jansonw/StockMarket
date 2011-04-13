package transferobject;

import job.JobBase;

public class NewGameTransferObject {

	private JobBase selectedJob;
	private String userInput;
	
	public JobBase getSelectedJob() {
		return selectedJob;
	}
	public void setSelectedJob(JobBase selectedJob) {
		this.selectedJob = selectedJob;
	}
	public String getUserInput() {
		return userInput;
	}
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
}
