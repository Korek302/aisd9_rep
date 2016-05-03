package aisd9_rep;

import java.util.ArrayList;

public class RadixNode
{
	public String label;
	public ArrayList<RadixNode> subNodes;
	
	public RadixNode()
	{
		label = "";
		subNodes = new ArrayList<RadixNode>();
	}
	
	public RadixNode(String l)
	{
		label = l;
		subNodes = new ArrayList<RadixNode>();
	}
	
	public String toString()
	{
		String out = "";
		for(RadixNode s: subNodes)
		{
			out += s.label+" ";
		}
		return out;
	}
}
