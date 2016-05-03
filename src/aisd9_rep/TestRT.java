package aisd9_rep;

public class TestRT
{
	public static void main(String[] args)
	{
		RadixTree rt = new RadixTree();
		
		rt.insert("romane");
		rt.insert("romanus");
		rt.insert("romulus");
		rt.insert("rubens");
		rt.insert("ruber");
		rt.insert("rubicon");
		rt.insert("rubicundus");
		
		System.out.println(rt.toString());
		
		System.out.println("find rubens: "+rt.find("rubens"));
		System.out.println("find r: "+rt.find("r"));
		System.out.println("find rub: "+rt.find("rub"));
		System.out.println("find ruber: "+rt.find("ruber"));
		
		System.out.println("\ndelete ruber and rub(not in tree)\n");
		rt.delete("ruber");
		rt.delete("rub");
		
		System.out.println("find ruber: "+rt.find("ruber"));
		
		System.out.println(rt.toString());
		
		rt.insert("r");
		
		rt.counter = 0;
		rt.find("r");

		System.out.println("Number of comparisons for key with a lenght of 1: "+rt.counter);
		
		
		rt.insert("ra");
		
		rt.counter = 0;
		rt.find("ra");

		System.out.println("Number of comparisons for key with a lenght of 2: "+rt.counter);

		
		rt.insert("rad");
		
		rt.counter = 0;
		rt.find("rad");

		System.out.println("Number of comparisons for key with a lenght of 3: "+rt.counter);

		
		rt.insert("radz");
		
		rt.counter = 0;
		rt.find("radz");

		System.out.println("Number of comparisons for key with a lenght of 4: "+rt.counter);

		
		rt.insert("radzi");
		
		rt.counter = 0;
		rt.find("radzi");

		System.out.println("Number of comparisons for key with a lenght of 5: "+rt.counter);

		
		rt.insert("radzio");
		
		rt.counter = 0;
		rt.find("radzio");

		System.out.println("Number of comparisons for key with a lenght of 6: "+rt.counter);

		
		rt.insert("radzion");
		
		rt.counter = 0;
		rt.find("radzion");

		System.out.println("Number of comparisons for key with a lenght of 7: "+rt.counter);

		
		rt.insert("radzionk");
		
		rt.counter = 0;
		rt.find("radzionk");

		System.out.println("Number of comparisons for key with a lenght of 8: "+rt.counter);

		
		rt.insert("radzionko");
		
		rt.counter = 0;
		rt.find("radzionko");

		System.out.println("Number of comparisons for key with a lenght of 9: "+rt.counter);

		
		rt.insert("radzionkow");
		
		rt.counter = 0;
		rt.find("radzionkow");

		System.out.println("Number of comparisons for key with a lenght of 10: "+rt.counter);

		
		rt.insert("radzionkowradzionkowradzionkowradzionkowradzionkowradzionkowradzionkowradzionkowradzionkowradzionkow");
		
		rt.counter = 0;
		rt.find("radzionkowradzionkowradzionkowradzionkowradzionkowradzionkowradzionkowradzionkowradzionkowradzionkow");

		System.out.println("Number of comparisons for key with a lenght of 100: "+rt.counter);
	}
}
