package job;

public abstract class JobBase {
	
	protected String jobTitle;
	protected int salary;
	protected int luckyNumber1;
	protected int luckyNumber2;
	
	public int getSalary() {
		return this.salary;
	}
	
	public String getJobTitle() {
		return this.jobTitle;
	}
	
	public boolean isLuckNumber(int roll) {
		if(this.luckyNumber1 == roll || this.luckyNumber2 == roll) {
			return true;
		}
		return false;
	}
	
	public int getLuckyNumber1() {
		return this.luckyNumber1;
	}
	
	public int getLuckNumber2() {
		return this.luckyNumber2;
	}

	@Override
	public String toString() {
		return "JobBase [jobTitle=" + jobTitle + ", salary=" + salary
				+ ", luckyNumber1=" + luckyNumber1 + ", luckyNumber2="
				+ luckyNumber2 + "]";
	}
}
