package Test1;

import java.awt.image.BufferedImage;

public class HikingHistory {
	
	String name, date, duration, pace;
	BufferedImage pictures;
	double distance;
	
	
	public HikingHistory(String name, String date, String duration, String pace, BufferedImage pictures, double distance) {
		super();
		this.name = name;
		this.date = date;
		this.duration = duration;
		this.pace = pace;
		this.pictures = pictures;
		this.distance = distance;
	}
	
	public HikingHistory(Trail trail) {
		super();
		this.name = trail.getName();
		this.date = null;
		this.duration = null;
		this.pace = null;
		this.pictures = null;
		this.distance = trail.getLength();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getPace() {
		return pace;
	}


	public void setPace(String pace) {
		this.pace = pace;
	}


	public BufferedImage getPictures() {
		return pictures;
	}


	public void setPictures(BufferedImage pictures) {
		this.pictures = pictures;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	@Override
	public String toString() {
		return "HikingHistoryBag [name=" + name + ", date=" + date + ", duration=" + duration + ", pace=" + pace
				+ ", pictures=" + pictures + ", distance=" + distance + "]";
	}

	
	
}
