package Test;

import org.junit.Test;

import Model.User;
import Model.UserBag;

import static org.junit.Assert.assertEquals;

public class TestUserBagJunit {

	@Test
	public void addUser() {
		UserBag ub = new UserBag();
		User user = new User("Bryan", "Bryan");
		assertEquals(true, ub.addUser(user));
	}
	
	@Test
	public void checkUser() {
		UserBag ub = new UserBag();
		User user = new User("Bryan", "Bryan");
		ub.addUser(user);
		
		assertEquals(true, ub.checkUserLogin("Bryan", "Bryan"));
	}
	
	@Test
	public void removeUser() {
		UserBag ub = new UserBag();
		User user = new User("Bryan", "Bryan");
		ub.addUser(user);
		assertEquals(true, ub.remove(user));
	}
	
}
