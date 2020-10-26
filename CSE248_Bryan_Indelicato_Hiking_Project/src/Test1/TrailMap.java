package Test1;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TrailMap {

	private static TreeMap<Integer, Trail> trailMap = new TreeMap<Integer, Trail>();
	private static LinkedList<Trail> trailMapLink = new LinkedList<Trail>();
	
	public static void addTree(Trail trail) {
		trailMap.put(trail.hashCode(), trail);
	}
	
	public static void test() {
		System.out.println(trailMap.comparator());
	}
	
	
	public static void searchTree(String string) {
		for(Map.Entry<Integer, Trail> entry : trailMap.entrySet()) {
			Trail value = entry.getValue();
			if (value.getName().contains(string) || value.getAddress().contains(string) || value.getDifficulty().contains(string)) {
				System.out.println(value.toString());
			}
		}
	}
	
	public static void searchLinkedListName(String string) {
		for(int i = 0; i < trailMapLink.size(); i++) {
			if(trailMapLink.get(i).getName() == string) {
				System.out.println(trailMapLink.get(i).toString());
			}
		}
	}
	
	public static void searchTreeName(String string) {
		for(Map.Entry<Integer, Trail> entry : trailMap.entrySet()) {
			Trail value = entry.getValue();
			if (value.getName() == string) {
				System.out.println(value.toString());
			}
		}
	}
	
	public static void addLink(Trail trail) {
		trailMapLink.add(trail);
	}
	
	
	
	
	
	
}
