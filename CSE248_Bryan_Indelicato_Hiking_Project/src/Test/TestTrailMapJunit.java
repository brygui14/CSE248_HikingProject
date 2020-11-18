package Test;

import org.junit.Test;

import Model.Trail;
import Model.TrailMap;

import static org.junit.Assert.assertEquals;

public class TestTrailMapJunit {
	
	 @Test
	    public void addTrail() {
	        TrailMap trailStore = new TrailMap();
	        Trail trail = new Trail("Green Trail", "25 Spooksville Run", "");
	        assertEquals(true, trailStore.addTree(trail));
	    }
	 
	 @Test
	    public void deleteTrail() {
	        TrailMap trailStore = new TrailMap();
	        Trail trail = new Trail("Green Trail", "25 Spooksville Run", "");
	        trailStore.addTree(trail);
	        assertEquals(true, trailStore.delete(trail));
	    }
	 
	 
	 
   
   }
