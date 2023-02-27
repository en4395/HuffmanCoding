package privateLibrary;

public class Node <T> 
{

	private T element;
	private Node<T> next;
	
	public Node(T element) 
	{
		this.element=element;
		next=null;
	}
	
	public T element()
	{
		return element;
	}
	
	public void setElement(T element)
	{
		this.element=element; 
	}
	
	public Node<T> next()
	{
		return next;
	}
	
	public void setNext(Node<T> next)
	{
		this.next=next;
	}
}
