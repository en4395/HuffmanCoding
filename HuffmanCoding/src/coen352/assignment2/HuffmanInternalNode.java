package coen352.assignment2;

public class HuffmanInternalNode implements HuffmanNode {
	private HuffmanNode leftChild;
	private HuffmanNode rightChild;
	private int weight;
	
	public HuffmanInternalNode(HuffmanNode n1, HuffmanNode n2) {
		this.weight=n1.weight()+n2.weight();
		if(n1.weight()<=n2.weight())
		{
			leftChild=n1;
			rightChild=n2;
		}
		else
		{
			leftChild=n2;
			rightChild=n1;
		}
	}
	
	public HuffmanNode leftChild() {
		return leftChild;
	}
	
	public HuffmanNode rightChild() {
		return rightChild;
	}

	public int weight() {
		return weight;
	}

	public Boolean leaf() {
		return false;
	}

}
