package privateLibrary;

import java.time.LocalDate;

public class DueDate {

	private LocalDate date;
	
	public DueDate() 
	{
		date=java.time.LocalDate.now().plusDays(30);
	}
	
	public LocalDate getDue()
	{
		return date;
	}
	
}
