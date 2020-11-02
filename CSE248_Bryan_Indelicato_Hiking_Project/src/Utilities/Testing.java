package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Test1.Trail;
import Test1.TrailMap;
import Test1.User;
import Test1.UserBag;

public class Testing {

	final static int SAMPLE_SIZE = 50000;
	final static int TRAIL_SIZE = 50000;

	public static void main(String[] arg) throws IOException {
		int index = (int) (Math.random() * TRAIL_SIZE);
		List<User> userDataList = createUserList();
		List<Trail> trailDataList = createTrailList();
		userBagHashTableTestTime(userDataList);
		searchHashTableTest(userDataList.get(index).getUsername());
		trailMapTreeMapTestTime(trailDataList);
		trailMapTreeMapSearchTestTime(trailDataList.get(index).getName());

	}

	public static void trailMapTreeMapSearchTestTime(String name) {
		long start = System.currentTimeMillis();
		TrailMap.searchTreeName(name);
		long end = System.currentTimeMillis();

		long duration = end - start;
		System.out
				.println("It took: " + duration + " milliseconds to search for the trail: " + name + " in the TreeMap");
	}


	public static void trailMapTreeMapTestTime(List<Trail> trails) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < TRAIL_SIZE; i++) {
			if (trails.get(i) != null) {
				TrailMap.addTree(trails.get(i));
			}
		}
		long end = System.currentTimeMillis();

		long duration = end - start;
		System.out.println("It took: " + duration
				+ " milliseconds to create the TreeMap(Trail Map) with a sample size of: " + TRAIL_SIZE);
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

	public static void userBagHashTableTestTime(List<User> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < SAMPLE_SIZE; i++) {
			if (list.get(i) != null)
				UserBag.addHash(list.get(i));
		}
		long end = System.currentTimeMillis();

		long duration = end - start;

		System.out.println("It took: " + duration
				+ " milliseconds to create the HashTable(User Profiles) with a sample size of: " + SAMPLE_SIZE);
	}

	

	public static void searchHashTableTest(String userName) {
		long start = System.nanoTime();
		UserBag.searchHash(userName);
		long end = System.nanoTime();
		long duration = end - start;

		System.out.println("It took: " + duration + " nanoseconds to search for the user profile: " + userName
				+ " in the HashTable");
	}

	

}