package Test1;

import java.util.Map;
import java.util.TreeMap;

public class TrailMap {

	private static TreeMap<Integer, Trail> trailMap = new TreeMap<Integer, Trail>();
	
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
	
	
	
	public static void searchTreeName(String string) {
		for(Map.Entry<Integer, Trail> entry : trailMap.entrySet()) {
			Trail value = entry.getValue();
			if (value.getName() == string) {
				System.out.println(value.toString());
			}
		}
	}
	
	
	
}
