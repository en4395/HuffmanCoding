package privateLibrary;

import java.time.LocalDate;

public class User {

	static int uniqueIDGenerator=1000;
	private String name;
	private Book[] borrowed;
	private int checkedBooks;
	private int uniqueID;
	private LocalDate membershipDate;
	
	public User(String name) 
	{
		this.checkedBooks=0;
		this.name=name;
		this.uniqueID=uniqueIDGenerator++;
		borrowed=new Book [10];
		for(int i=0; i<borrowed.length; i++)
		{
			borrowed[i]=null;
		}
		membershipDate=java.time.LocalDate.now();
	}
	
	public String toString() //Override toString()
	{
		return "NAME:\t\t\t"+this.name+"\n"+"UNIQUE ID:\t\t"+this.uniqueID+"\n"+"MEMBER SINCE:\t\t"+this.membershipDate;
	}

	public boolean borrow(Book book)
	{
		if(checkedBooks>=borrowed.length)
			return false;
		
		if(book.borrow(this))
		{
			borrowed[checkedBooks]=book;
			checkedBooks++;
			return true;
		}
		return false;
	}
}
