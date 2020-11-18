package Test;


import org.junit.Test;

import Model.HikingHistory;
import Model.HikingHistoryBag;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;

public class TestHikingHistoryJunit {
	
	@Test
	public void addHikingHistory() {
		HikingHistoryBag hb = new HikingHistoryBag();
		assertEquals(true, hb.add(new HikingHistory("name", "date", "duration", "pace", null, 10)));
	}
	
}
