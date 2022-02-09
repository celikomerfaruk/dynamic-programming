
public class Task {
	private int startTime;
	private int endTime;
	private int profit;
	public Task(int s, int e ,int p) {
		startTime = s;
		endTime = e;
		profit = p;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
}
