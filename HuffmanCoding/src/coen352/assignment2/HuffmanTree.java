package coen352.assignment2;

public class HuffmanTree implements Comparable<HuffmanTree> {
	private HuffmanNode root;
	
	public HuffmanTree(char value, int weight) {
		root=new HuffmanLeaf(value, weight);
	}
	
	public HuffmanTree(HuffmanNode rightTree, HuffmanNode leftTree)
	{
		root=new HuffmanInternalNode(leftTree, rightTree);
	}
	
	public int rootWeight(){
		return root.weight();
	}
	
	public HuffmanNode root() {
		return root;
	}
	
	public String printRight(){
		String str="";
		HuffmanNode current=root;
		while(!current.leaf()){
			str+=current.weight()+" ";
			current=(((HuffmanInternalNode)current).rightChild());
		}
		
		str+=((HuffmanLeaf)current).weight()+" "+((HuffmanLeaf)current).value();
		return str;
	}
	
	public String printLeft(){
		String str="";
		HuffmanNode current=root;
		while(!current.leaf()){
			str+=current.weight()+" ";
			current=(((HuffmanInternalNode)current).leftChild());
		}
		
		str+=((HuffmanLeaf)current).weight()+" "+((HuffmanLeaf)current).value();
		return str;
	}
	
	public String toString() {
		if(root.leaf())
		{
			return(((HuffmanLeaf)root).value()+"="+((HuffmanLeaf)root).weight());
		}
		return (Integer.toString(root.weight()));
		
	}
	
	public int compareTo(HuffmanTree other) {
		return this.rootWeight()-other.rootWeight();
	}
	
	public String decode(String binary) {
		String str="";
		char ch;
		HuffmanNode current=this.root;
		for(int i=0; i<binary.length(); i++)
		{
				ch=binary.charAt(i);
				if(current.leaf())
				{
					str+=((HuffmanLeaf)current).value();
					current=this.root;
				}
				
				if(ch=='0') {
					current=((HuffmanInternalNode)current).leftChild();
				}
				else if(ch=='1') {
					current=((HuffmanInternalNode)current).rightChild();
				}
				else {
					return "Invalid code, code must be a binary string!";
				}
		}
		if(current.leaf())
		{
			str+=((HuffmanLeaf)current).value();
		}
		
		return str;
	}
}
