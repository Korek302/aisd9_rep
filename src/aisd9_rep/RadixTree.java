package aisd9_rep;

public class RadixTree
{
	private RadixNode root;
	int counter;
	
	public RadixTree()
	{
		root = new RadixNode("");
		counter = 0;
	}
	
	public void insert(String word)
	{
		insertRec(word, root);
	}
	
	private void insertRec(String wordPart, RadixNode curNode)
	{
		int matches = MatchingConsecutiveCharacters(wordPart, curNode);
		
		if((matches == 0) || (curNode == root) || ((matches > 0) 
				&& (matches < wordPart.length()) && (matches >= curNode.label.length())))
		{
			boolean inserted = false;
			String newWordPart = wordPart.substring(matches, wordPart.length() - matches);
			for(RadixNode child: curNode.subNodes)
			{
				if(child.label.startsWith(newWordPart, 0))
				{
					inserted = true;
					insertRec(newWordPart, child);
				}
			}
			if(inserted == false)
			{
				curNode.subNodes.add(new RadixNode(newWordPart));
			}
		}
		else if(matches < wordPart.length())
		{
			String commonRoot = wordPart.substring(0, matches);
			String branchPreviousLabel = curNode.label.substring(matches, curNode.label.length() - matches);
			String branchNewLabel = wordPart.substring(matches, wordPart.length() - matches);
			
			curNode.label = commonRoot;
			
			RadixNode newNodePreviousLabel = new RadixNode(branchPreviousLabel);
			newNodePreviousLabel.subNodes.addAll(curNode.subNodes);
			
			curNode.subNodes.clear();
			curNode.subNodes.add(newNodePreviousLabel);
			
			RadixNode newNodeNewLable = new RadixNode(branchNewLabel);
			curNode.subNodes.add(newNodeNewLable);
		}
		else if(matches == curNode.label.length())
		{
			
		}
		else if(matches > curNode.label.length())
		{
			String newNodeLabel = curNode.label.substring(curNode.label.length(), wordPart.length());
			RadixNode newNode = new RadixNode(newNodeLabel);
			curNode.subNodes.add(newNode);
		}
	}
	
	private int MatchingConsecutiveCharacters(String word, RadixNode curNode)
	{
		int matches = 0;
		int minLength = 0;
		
		if(curNode.label.length() >= word.length())
			minLength = word.length();
		else if(curNode.label.length() < word.length())
			minLength = curNode.label.length();
		
		if(minLength > 0)
			for(int i = 0; i < minLength; i++)
			{
				if(word.charAt(i) == curNode.label.charAt(i))
					matches++;
				else
					break;
			}
		return matches;
	}
	
	
	public boolean find(String word)
	{
		return findRec(word, root);
	}
	
	private boolean findRec(String wordPart, RadixNode curNode)
	{
		counter++;
		
		int matches = MatchingConsecutiveCharacters(wordPart, curNode);
		
		if((matches == 0) || (curNode == root) || ((matches > 0) && matches < wordPart.length() 
				&& (matches >= curNode.label.length())))
		{
			String newLabel = wordPart.substring(matches, wordPart.length() - matches);
			for(RadixNode child: curNode.subNodes)
			{
				if(child.label.startsWith(newLabel, 0))
				{
					return findRec(newLabel, child);
				}
			}
			return false;
		}
		else if(matches == curNode.label.length())
		{
			return true;
		}
		else
			return false;
	}
	
	
	
	public void delete(String label)
	{
		deleteRec(label, root);
	}
	
	public void deleteRec(String wordPart, RadixNode curNode)
	{
		int matches = MatchingConsecutiveCharacters(wordPart, curNode);
		
		if((matches == 0) || (curNode == root) || ((matches > 0) && matches < wordPart.length()) 
				&& (matches >= curNode.label.length()))
		{
			String newLabel = wordPart.substring(matches, wordPart.length() - matches);
			for(RadixNode child: curNode.subNodes)
				if(child.label.startsWith(newLabel, 0))
				{
					if(newLabel == child.label)
					{
						if(child.subNodes.size() == 0)
						{
							curNode.subNodes.remove(child);
							return;
						}
					}
					deleteRec(newLabel, child);
				}
		}
	}
	
	public String toString()
	{
		return root.toString();
	}
}
