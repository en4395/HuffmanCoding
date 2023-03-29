package coen352.assignment2;

public class HuffmanLeaf implements HuffmanNode {
	private char value;
	private int weight;
	
	public HuffmanLeaf(char value, int weight) {
		this.value=value;
		this.weight=weight;
	}

	public int weight() {
		return weight;
	}

	public char value() {
		return value;
	}

	public Boolean leaf() {
		return true;
	}

}
