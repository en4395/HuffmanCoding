package midterm_practice;

import java.util.Arrays;

public class insertionSort {

	int [] array;
	int [] origArray;
	public insertionSort(int [] array) {
		this.array=array.clone();
		this.origArray=array.clone();
	}
	
	public void sort()
	{
		long start, stop;
		int lowindex;
		start=System.nanoTime();
		for(int sorted=1; sorted<array.length; sorted++)
		{
			lowindex=sorted;
			for(int j=sorted; j>=0; j--)
			{
				if(array[j]>array[sorted])
				{
					lowindex=j;
				}
			}
			if(lowindex!=sorted)
			{
				shift_place(lowindex, sorted);
			}
		}
		
		stop=System.nanoTime();
		System.out.println("INSERTION SORT TOOK: "+(stop-start));
	}
	
	public void shift_place(int target, int element)
	{
		int temp=array[element];
		for(int i=element-1; i>=target; i--)
		{
			array[i+1]=array[i];
		} //Shift every element right
		array[target]=temp;
	}
	
	public void checkSort()
	{
		Arrays.sort(origArray);
		if(Arrays.equals(origArray, array))
			System.out.println("\nInsertionSort worked!");
		else
			System.out.println("\nInsertionSort bombed!");
	}

}
