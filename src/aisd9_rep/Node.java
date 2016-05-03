package aisd9_rep;

public class Node
{
	Vehicle value;
	Node left;
	Node right;
	Node parent;
	int balance;
	
	public Node(Vehicle x)
	{
		value = x;
		left = right = parent = null;
		balance = 0;
	}
	
	public String toString()
	{
		return value.toString();
	}
}