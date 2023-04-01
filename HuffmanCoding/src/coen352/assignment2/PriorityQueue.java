package coen352.assignment2;

/**
 * For this tree, where order of insertion is significant, a stable priority queue
 * is needed. In this instance, a java PriorityQueue was inappropriate, seeing as 
 * it is implemented as a min-heap, which is not a stable structure.
 * 
 * So I implemented my own priority queue -esque structure. It is array-based, and uses
 * radix sort for a fast initial ordering. Whenever a newly added element calls for
 * sorting, insertion sort's best case performance in an "almost sorted" array is exploited. 
 *
 * Similar to a stack, elements are removed by changing a boundary of the queue. In this case, 
 * when the minimum value is removed from the queue, the index of the queue's first element is
 * incremented.
 */
public class PriorityQueue {

	private int start;
	private int length;
	private HuffmanTree [] queue;
	
	public PriorityQueue(HuffmanTree[] queue, int length) {
		this.queue=queue.clone();
		this.length=length;
		this.start=0;
		this.sort();
	}

	public void zeroBuckets(int [] buckets)
	{
		for(int i=0; i<buckets.length; i++)
		{
			buckets[i]=0;
		}
	}
	
	public void sort(){
		HuffmanTree [] buffer=new HuffmanTree [queue.length];
		int [] buckets=new int [257]; //Max value of a byte is 11111111, or 255 in decimal
		
		for(int digit=0; digit<4; digit++) //An iteration for each byte of the integers
		{
			//Start at bucket 1 (hence the (int)(1+...))
			//The index in buckets is 
			for(int i=0; i<queue.length; i++)
			{
				buckets[(int)(1+(queue[i].rootWeight()>>(digit*8))&255)]++; 
				//(array[i]>>(digit*8))&255) performs an 8 bit shift to assess one byte at a time, then 
				//a bit-wise AND operation with 11111111 to preserve the last 8 bits
				//this is added with 1 and typecast to integer
			}
			
			for(int i=1; i<257; i++)
			{
				buckets[i]=buckets[i]+buckets[i-1];
			} //Sum the buckets to get starting indices in sorted array
			
			for(int i=0; i<queue.length; i++)
			{
				buffer[buckets[(int)(queue[i].rootWeight()>>(digit*8)&255)]]=queue[i];
				buckets[(int)(queue[i].rootWeight()>>(digit*8)&255)]++;
			}
			
			HuffmanTree[] temp=buffer;
			buffer=queue;
			queue=temp;
			zeroBuckets(buckets);	//Restore all buckets to zero 
		}
	}
	
	public void print(){
		for(int i=start; i<length; i++) {
			System.out.print(queue[i]+" ");
		}
	}
	
	public int length() {	
		return length;
	}
	
	public int start() {
		return start;
	}
	
	public HuffmanTree remove() {
		if(start==length-1) {
			return queue[start];
		}
		return queue[start++];
	}
	
	public void add(HuffmanTree tree) {		
		if(start==0) {
			System.out.println("Queue is full, cannot add an element.");
			return;
		}
		int current=start-1;
		while(current<length-1) {
			if(queue[current+1].rootWeight()>tree.rootWeight())
				break;
			current++;
		}
		start--;
		for(int i=start; i<current; i++) {
			queue[i]=queue[i+1];
		} //Shift whole queue left
		queue[current]=tree;
	}
}
