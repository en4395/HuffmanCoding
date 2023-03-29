package privateLibrary;

import java.time.LocalDate;
import java.util.Scanner;


public class Driver {

	public static void main(String[] args) {
		
		Book book1=new Book("On Beauty", "Smith, Zadie", "0-141-01945-X");
		
		User user1=new User("Zed Amoura");
		User user2=new User("Vincent Alaya");
		User user3=new User("Traci Carlyle");
		
		user1.borrow(book1);
		// TODO Auto-generated method stub
	
		System.out.print("\n"+book1);
		
		Library concordia=new Library();
		concordia.newPatron(user1);
		concordia.newPatron(user2);
		concordia.newPatron(user3);
		concordia.newBook(book1);
		
		concordia.allPatrons();
		concordia.allBooks();
		
	}

}
