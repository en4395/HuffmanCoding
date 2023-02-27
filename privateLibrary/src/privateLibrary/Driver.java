package privateLibrary;

import java.time.LocalDate;
import java.util.Scanner;


public class Driver {

	public static void main(String[] args) {
		DueDate date=new DueDate();
		Scanner sc=new Scanner(System.in);
		
		System.out.println(date.getDue());
		Book book1=new Book("On Beauty", "Smith, Zadie", "0-141-01945-X");
		book1.print();
		
		
		User user1=new User("Ella Noyes");
		User user2=new User("Tom Noyes");
		User user3=new User("Ellie Couture");
		
		user1.borrow(book1);
		// TODO Auto-generated method stub

		LinkedList<User> myList=new LinkedList();
		myList.addNode(user1);
		myList.addNode(user2);
		myList.addNode(user3);
		myList.print();
		
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
