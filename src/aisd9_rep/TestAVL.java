package aisd9_rep;

import java.util.Random;

public class TestAVL
{
	public static void main(String[] args)
	{
		AVL tree = new AVL();
		
		int size = 10;
		Random rand = new Random();
		
		//build tree
		for(int i = 0; i < size; i++)
		{
			int temp = rand.nextInt(size);
			if(tree.find(temp) == null)
				tree.insert(new Vehicle(temp, "audi"));
			else
				i--;
		}
		
		System.out.println(tree.toString());
		
		tree.delete(10);
		System.out.println("find 5: "+tree.find(5));
		tree.delete(5);
		System.out.println("find 1: "+tree.find(1));
		System.out.println("find 5(after deleting it): "+tree.find(5));
		
		System.out.println("\n\nafter deleting 10(not in tree) and 5:\n"+tree.toString());
	}
}
