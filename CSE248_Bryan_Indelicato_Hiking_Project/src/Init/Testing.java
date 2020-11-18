package Init;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.sun.tools.javac.Main;

import Model.HikingHistory;
import Model.Trail;
import Model.TrailMap;
import Model.User;
import Model.UserBag;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Testing extends Application{
	
	
	public static long durationUserSearch, durationUserCreate, durationTrailCreate, durationTrailSearch; 
	private static String username, trailName;
	
	//These determine how big the Junit test will be 
	final static int SAMPLE_SIZE = 50000;
	final static int TRAIL_SIZE = 50000;


	public static void main(String[] arg) throws IOException {
		initilize();
		Application.launch(arg);

	}
	
	
	/**
	 * Initializes all data to be stored 
	 * @throws IOException
	 */
	public static void initilize() throws IOException {
		List<User> userDataList = createUserList();
		List<Trail> trailDataList = createTrailList();
		int index = (int) (Math.random() * TRAIL_SIZE);
		username = userDataList.get(index).getUsername();
		trailName = trailDataList.get(index).getName();
		durationUserCreate = userBagCreateTestTime(userDataList);
		durationUserSearch = searchUserDataTest(userDataList.get(index).getUsername());
		durationTrailCreate =  trailMapTreeMapTestTime(trailDataList);
		durationTrailSearch = trailMapTreeMapSearchTestTime(trailDataList.get(index).getName());
		
		User user = new User("admin", "admin");
		HikingHistory hist = new HikingHistory(trailDataList.get(index));
		user.addHike(hist);
		user.setAdminStatus(true);
		
		UserBag.addUser(user);

	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		Pane signIn = (Pane) FXMLLoader.load(getClass().getResource("/View/LoginView.fxml"));
		primaryStage.setScene(new Scene(signIn));
		primaryStage.show();
		
		
	}

	public static long trailMapTreeMapSearchTestTime(String name) {
		long start = System.currentTimeMillis();
		TrailMap.searchTreeName(name);
		long end = System.currentTimeMillis();

		long duration = end - start;
		
		return duration;
	}


	public static long trailMapTreeMapTestTime(List<Trail> trails) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < TRAIL_SIZE; i++) {
			if (trails.get(i) != null) {
				TrailMap.addTree(trails.get(i));
			}
		}
		long end = System.currentTimeMillis();

		long duration = end - start;
		
		return duration;
	}

	public static List<Trail> createTrailList() throws IOException {
		Trail[] trailArray = new Trail[TRAIL_SIZE];

		try (BufferedReader br = new BufferedReader(new FileReader("FakeNameGenerator.com_ad151934.csv"))) {
			int count = 0;
			String line;
			while (count != TRAIL_SIZE) {
				if ((line = br.readLine()) != null) {
					String[] values = line.split(",");
					Trail temp = new Trail(values[0], values[1], values[2]);
					trailArray[count] = temp;
					count++;

				}

			}
		}

		List<Trail> list = Arrays.asList(trailArray);
		Collections.shuffle(list);

		return list;
	}

	public static List<User> createUserList() throws IOException {
		User[] userArray = new User[SAMPLE_SIZE];
		try (BufferedReader br = new BufferedReader(new FileReader("FakeNameGenerator.com_6a9b7446.csv"))) {
			int count = 0;
			String line;
			while (count != SAMPLE_SIZE) {
				if ((line = br.readLine()) != null) {
					String[] values = line.split(",");
					User temp = new User(values[0], values[1]);
					userArray[count] = temp;
					count++;
				}
			}
		}
		List<User> list = Arrays.asList(userArray);
		Collections.shuffle(list);
		return list;

	}

	public static long userBagCreateTestTime(List<User> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < SAMPLE_SIZE; i++) {
			if (list.get(i) != null)
				UserBag.addUser(list.get(i));
		}
		long end = System.currentTimeMillis();

		long duration = end - start;

		return duration;
	}

	

	public static long searchUserDataTest(String userName) {
		long start = System.currentTimeMillis();
		UserBag.searchUser(userName);
		long end = System.currentTimeMillis();
		long duration = end - start;

		return duration;
	}
	
	public static void JunitTestResults() {
		System.out.println("It took: " + durationUserCreate
				+ " milliseconds to create the TreeMap(User Profiles) with a sample size of: " + SAMPLE_SIZE);
		
		System.out.println("It took: " + durationUserSearch + " milliseconds to search for the user profile: " + username
				+ " in the TreeMap");
		
		System.out.println("It took: " + durationTrailCreate
				+ " milliseconds to create the TreeMap(Trail Map) with a sample size of: " + TRAIL_SIZE);
		
		System.out
		.println("It took: " + durationTrailSearch + " milliseconds to search for the trail: " + trailName + " in the TreeMap");
	}
	
}

	

