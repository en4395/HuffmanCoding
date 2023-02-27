package privateLibrary;

import java.util.Scanner;

public class Book {

	private String ISBN;
	private String title;
	private String author;
	private User borrowedBy;
	private boolean available;
	private DueDate due;
	
	public Book(String title, String author, String ISBN) 
	{
		this.title=title;
		this.author=author;
		this.ISBN=ISBN;
		available=true;
		due=null;
		borrowedBy=null;
	}
	
	public void print()
	{
		for(int i=0; i<40; i++)
		{
			System.out.print("*");
		}
		System.out.println("\nTITLE:\t\t\t"+title);
		System.out.println("AUTHOR:\t\t\t"+author);
		System.out.println("ISBN:\t\t\t"+ISBN);
		System.out.println("AVAILABLE:\t\t"+(available?"YES":"NO"));
		if(!available)
		{
			System.out.println("CHECKED OUT BY:\n"+borrowedBy);
		}
		for(int i=0; i<40; i++)
		{
			System.out.print("*");
		}
		System.out.println();
	}
	
	public String toString()
	{
		String str = "*";
		for(int i=0; i<39; i++)
		{
			str+="*";
		}
		str+="\nTITLE:\t\t\t"+this.title+"\nAUTHOR:\t\t\t"+this.author+"\nISBN:\t\t\t"+this.ISBN+"\nAVAILABLE:\t\t";
		if(available)
			str+="YES\n";
		else
			str+="NO\n";
		for(int i=0; i<40; i++)
		{
			str+="*";
		}
		
		return str;
	}
	
	public boolean borrow(User user)
	{
		if(available)
		{
			due=new DueDate();
			available=false;
			borrowedBy=user;
			
			System.out.println("\n\""+title+"\" WAS CHECKED OUT BY:\n"+borrowedBy);
			System.out.println("AND IS DUE BY:\t\t"+due.getDue());
			return true;
		}
		System.out.println("\n\""+title+"\" IS CURRENTLY UNAVAILABLE");
		return false;
	}
	
	public void in(Scanner sc)
	{
		
	}

}
