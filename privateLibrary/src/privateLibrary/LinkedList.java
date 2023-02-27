package privateLibrary;

public class LinkedList <T>
{
	private Node<T> head;
	private Node<T> tail;
	
	public LinkedList() 
	{
		head=tail=new Node<T> (null);
	}
	
	public void addNode(T element)
	{
		Node<T> node=new Node(element);
		tail.setNext(node);
		tail=tail.next();
		if(head.next()==null)
		{
			head.setNext(node);
		}
	}
	
	public void print()
	{
		Node<T> current=head.next();
		while(current!=null)
		{
			System.out.print(current.element()+"\n\n");
			current=current.next();
		}
	}

}
