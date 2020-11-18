package Model;

/**
 * @author bryanindelicato
 *
 */
public class Trail {

	String name, address, difficulty, type;
	double length, elevationGain;
	
	
	/**
	 * Creates Trail Object
	 * @param name
	 * @param address
	 * @param difficulty
	 * @param type
	 * @param length
	 * @param elevationGain
	 */
	public Trail(String name, String address, String difficulty, String type, double length, double elevationGain) {
		super();
		this.name = name;
		this.address = address;
		this.difficulty = difficulty;
		this.type = type;
		this.length = length;
		this.elevationGain = elevationGain;
	}
	
	/**
	 * Creates Trail Object
	 * @param name
	 * @param address
	 * @param difficult
	 */
	public Trail(String name, String address, String difficult) {
		super();
		this.name = name;
		this.address = address;
		this.difficulty = difficult;
		this.type = "loop";
		this.length = (int)((Math.random() * 5) + 1);
		this.elevationGain = (int)((Math.random() * 1000) + 1);
	}
	
	
	@Override
	public String toString() {
		return "Trail [name=" + name + ", address=" + address + ", difficulty=" + difficulty + ", type=" + type
				+ ", length=" + length + ", elevationGain=" + elevationGain + "]";
	}

	public Trail(String name) {
		super();
		this.name = name;
		this.address = null;
		this.difficulty = null;
		this.type = null;
		this.length = 0;
		this.elevationGain = 0;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}


	public double getElevationGain() {
		return elevationGain;
	}


	public void setElevationGain(double elevationGain) {
		this.elevationGain = elevationGain;
	}


	


}