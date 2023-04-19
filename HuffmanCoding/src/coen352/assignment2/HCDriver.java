package coen352.assignment2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HCDriver {
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
						
						
						 //if(ascii==10) myMap.put((char)13, 1);
						 // When running the program on Mac, the NL and CR characters
						 // are interpreted as a single character. So this statement should
						 // also be executed
						 
					}
					else
					{
						myMap.put(current, myMap.get(current)+1);
						//if(ascii==10) 
						//	myMap.put((char)13, myMap.get((char)13)+1);
					}
				}
				
				HuffmanTree[] haikuForest=new HuffmanTree[myMap.size()];
				int element=0;
				for(Map.Entry<Character, Integer>entry:myMap.entrySet()){
					haikuForest[element++]=new HuffmanTree(entry.getKey(), entry.getValue());
				}
				
				PriorityQueue queue=new PriorityQueue(haikuForest, haikuForest.length);
			  
				for(int i=0; i<(queue.length()); i++) { 
					queue.add(new HuffmanTree(queue.remove().root(), queue.remove().root())); 
				  } 
				HuffmanTree complete=queue.remove();
				  	
				Scanner scin=new Scanner(System.in);
				  if(args[1].compareTo("decode")==0) { 
					  String toDecode=scin.nextLine(); 
					  System.out.print(complete.decode(toDecode));
				  }
				  else if(args[1].compareTo("encode")==0) {
					  Map<Character, String>huffmanCode=new HashMap<Character, String>();
					  encodingMap(complete.root(), huffmanCode, "");
					  String toEncode=scin.nextLine(); 
					  System.out.println(encode(toEncode,huffmanCode));
				  }
				 scin.close();
				 
				fin.close();
				}
				catch (FileNotFoundException e) {
					System.out.println("Could not open file");
			}
		}
	}
	//I derived the logic for this method from Ismael's Huffman Coding Tree example
	public static void encodingMap(HuffmanNode node, Map<Character, String> huffmanCode, String str) {
		howMany++;
		if(node==null) 
			return;
		
		if(node.leaf()) {
			huffmanCode.put(((HuffmanLeaf)node).value(), str);
		}
		else {
			encodingMap(((HuffmanInternalNode)node).leftChild(), huffmanCode, str+'0');
			encodingMap(((HuffmanInternalNode)node).rightChild(), huffmanCode, str+'1');
		}
	}
	
	public static String encode(String str, Map<Character, String> huffmanCode) {
		String encoded="";
		char ch;
		
		for(int i=0; i<str.length(); i++) {
			ch=str.charAt(i);
			if(ch<91&&ch>64) //Convert uppercase to lowercase
			{
				ch=(char)(ch+32);
			}
			encoded+=huffmanCode.get(ch);
		}
		return encoded;
	}
}

