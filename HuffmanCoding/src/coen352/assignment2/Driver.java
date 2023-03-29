package coen352.assignment2;

import java.util.LinkedHashMap;

import java.util.Map;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver {

	
	public static void main(String[] args) throws IOException {
		
		if(args.length>0)
		{
			String fileName=args[0];
			try {
				FileInputStream fin=new FileInputStream(fileName);
				
				Map<Character, Integer> myMap=new LinkedHashMap<Character, Integer>();
				//A LinkedHashMap is used here because the characters' order of appearance
				//in the text file is significant. The keys in the map should therefore be indexed
				//in insertion-order
						
				//The ascii values of the characters are read one by one
				//If the values are in the range of uppercase letters, then
				//they are converted to their lowercase equivalents.
				//The characters are stored in a hashmap that maps characters
				//to their their frequencies.
				int in=0;
				while((in=fin.read())!=-1)
				{
					int ascii=in;
					char current;
					
					/*
					 * switch(ascii) { case 13: System.out.print("CR\n"); break; case 10:
					 * System.out.print("NL\n"); break; default: break; }
					 */
					
					if(ascii<91&&ascii>64) //Convert uppercase to lowercase
					{
						current=(char)(ascii+32);
					}
					else
					{
						current=(char)(ascii);
					}
					
					if(myMap.get(current)==null)
					{
						myMap.put(current, 1);
						//The CR character did not appear in the text file. A condition was
						//needed to add this character following the NL character, such that the
						//Huffman Tree was implemented as presented on the assignment.
						if(ascii==10)
							myMap.put((char)13, 1);
					}
					else
					{
						myMap.put(current, myMap.get(current)+1);
						if(ascii==10) 
							myMap.put((char)13, myMap.get((char)13)+1);
					}
				}
				
				HuffmanTree[] haikuForest=new HuffmanTree[myMap.size()];
				int element=0;
				for(Map.Entry<Character, Integer>entry:myMap.entrySet()){
					haikuForest[element++]=new HuffmanTree(entry.getKey(), entry.getValue());
				}
				PriorityQueue queue=new PriorityQueue(haikuForest, haikuForest.length);
				queue.print();
				
				
				  for(int i=0; i<(queue.length()); i++) { 
					  queue.add(new HuffmanTree(queue.remove().root(), queue.remove().root()));
				  }
				 HuffmanTree complete=queue.remove();
				  

				  System.out.print(complete.rootWeight());
				  System.out.print(complete.decode("10101000100010011110010011101001"));

				}
				catch (FileNotFoundException e) {

			}
			
	
	
			
		}
		
		}
		

}
