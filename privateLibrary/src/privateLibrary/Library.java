package privateLibrary;

public class Library 
{
	private LinkedList<Book> bookList;
	private LinkedList<User> patrons;
	
	public Library() 
	{
		bookList=new LinkedList();
		patrons=new LinkedList();
	}
	
	public void newBook(Book book)
	{
		bookList.addNode(book);
		System.out.println("\nNew book added to the library!");
	}
	
	public void newPatron(User patron)
	{
		patrons.addNode(patron);
		System.out.println("\nNew patron joined to the library!");
	}
	
	public void allBooks()
	{
		System.out.println("\nPrinting library catalogue: ");
		bookList.print();
	}
	
	public void allPatrons()
	{
		System.out.println("\nPrinting library patrons: ");
		patrons.print();
	}
}
