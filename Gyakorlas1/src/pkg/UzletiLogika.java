package pkg;

import java.util.ArrayList;
import java.util.List;

public class UzletiLogika {
	
	List<User> lista = new ArrayList<>();

	public UzletiLogika() {
		
		User user1 = new User("mari", "mariesmari", "123");
		User user2 = new User("pisti", "pista@gmail.com", "456");
		
		
		lista.add(user1);
		lista.add(user2);
		
		
		
	}
	
	
	public void getAllUser() {
		
		for (User user : lista) {
			
			System.out.println(user.getHello());
			
			System.out.println(user.getNev());
			
		}
		
	}
	
	
	

}
