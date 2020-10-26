package Test1;

import java.util.LinkedList;

public class HikingHistoryBag {
	
	private LinkedList<HikingHistory> hikingHistory;
	
	
	public HikingHistoryBag() {
		this.hikingHistory = new LinkedList<HikingHistory>();
	}
	
	public void add(Trail trail) {
		this.hikingHistory.add(new HikingHistory(trail));
	}
}
