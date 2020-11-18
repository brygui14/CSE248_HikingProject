package Model;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author bryanindelicato
 *
 */
public class TrailMap {

	private static TreeMap<Integer, Trail> trailMap = new TreeMap<Integer, Trail>();
	
	

	/**
	 * Adds trail to TreeMap 

	 * @param trail
	 * @return Boolean
	 */
	public static boolean addTree(Trail trail) {
		trailMap.put(trail.hashCode(), trail);
		return true;
	}
	
	
	
	/**
	 * Searches the entire TreeMap containing anything within a string
	 * @param string
	 * @return Boolean
	 */
	public static boolean searchTree(String string) {
		for(Map.Entry<Integer, Trail> entry : trailMap.entrySet()) {
			Trail value = entry.getValue();
			if (value.getName().contains(string) || value.getAddress().contains(string) || value.getDifficulty().contains(string)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * Searches the TreeMap by name only
	 * @param string
	 * @return Boolean
	 */
	public static boolean searchTreeName(String string) {
		for(Map.Entry<Integer, Trail> entry : trailMap.entrySet()) {
			Trail value = entry.getValue();
			if (value.getName() == string) {
				return true;
			}
		}
		return false;
	}
	
	public static TreeMap<Integer, Trail> getTrailMap() {
		return trailMap;
	}
	
	
	
	/**
	 * Deletes Trail from TreeMap
	 * @param trail
	 * @return Boolean
	 */
	public static boolean delete(Trail trail) {
		trailMap.remove(trail.hashCode());
		return true;
	}
	
	
	
}
