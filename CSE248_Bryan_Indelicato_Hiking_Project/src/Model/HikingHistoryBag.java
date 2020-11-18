package Model;

import java.util.LinkedList;

/**
 * @author bryanindelicato
 *
 */
public class HikingHistoryBag {
	
	private LinkedList<HikingHistory> hikingHistory;
	
	
	/**
	 * Hiking History Bag constructor initializes a Linked List to keep track of User's Hikes
	 */
	public HikingHistoryBag() {
		this.hikingHistory = new LinkedList<HikingHistory>();
	}
	
	/**
	 * Adds Hiking History object to Linked List
	 * @param Hiking History Object
	 */
	public boolean add(HikingHistory hh) {
		this.hikingHistory.add(hh);
		return true;
	}
	/**
	 * Adds Hiking History object to Linked List by creating new Hiking History object
	 * @param Trail Object
	 */
	public void add(Trail trail) {
		this.hikingHistory.add(new HikingHistory(trail));
	}
	
	
	public LinkedList<HikingHistory> values(){
		return this.hikingHistory;
	}
	
}
