package aisd9_rep;

public class AVL implements Tree
{

	Node root;
	int counter = 0;
	
	
	//find
	private Node search(int value)
	{
		Node node = root;
		int cmp = 0;
		while(node != null && (cmp = value - node.value.age) != 0)
		{
			node = cmp < 0 ? node.left : node.right;
			counter++;
		}
		return node;
	}
	
	public Object find(int x)
	{
		Node t = search(x);
		return t != null ? t.value : null;
	}

	
	//insert
	public void insertAVL(Node p, Node q)
	{
		if(p == null)
		{
			this.root = q;
		}
		else
		{
			if(q.value.age < p.value.age)
			{
				if(p.left == null)
				{
					p.left = q;
					q.parent = p;
					System.out.println(toString()+"\n----------------------");
					recursiveBalance(p);
					System.out.println(toString()+"\n**********************");
				}
				else
				{
					insertAVL(p.left, q);
				}
			}
			else if(q.value.age > p.value.age)
			{
				if(p.right == null)
				{
					p.right = q;
					q.parent = p;
					System.out.println(toString()+"\n----------------------");
					recursiveBalance(p);
					System.out.println(toString()+"\n**********************");
				}
				else
				{
					insertAVL(p.right, q);
				}
			}
		}
	}
	
	public void insert(Object x)
	{
		Node n = new Node((Vehicle)x);
		insertAVL(this.root,n);
	}
	
	
	
	//delete
	public void removeFoundNode(Node q)
	{
		Node r;
		if(q.left == null || q.right == null)
		{
			if(q.parent == null)
			{
				this.root = null;
				q = null;
				return;
			}
			r = q;
		}
		else
		{
			r = successor(q);
			q.value.age = r.value.age;
		}
		
		Node p;
		if(r.left != null)
		{
			p = r.left;
		}
		else
		{
			p = r.right;
		}
		
		if(p != null)
		{
			p.parent = r.parent;
		}
		
		if(r.parent == null)
		{
			this.root = p;
		}
		else
		{
			if(r == r.parent.left)
			{
				r.parent.left = p;
			}
			else
			{
				r.parent.right = p;
			}
			
			recursiveBalance(r.parent);
		}
		r = null;
	}
	
	public void removeAVL(Node p, int q)
	{
		if(p == null)
		{
			return;
		}
		else
		{
			if(p.value.age > q)
			{
				removeAVL(p.left, q);
			}
			else if(p.value.age < q)
			{
				removeAVL(p.right, q);
			}
			else if(p.value.age == q)
			{
				removeFoundNode(p);
			}
		}
	}
	
	public void delete(int x)
	{
		removeAVL(this.root, x);
	}
	
	
	
	
	
	public void recursiveBalance(Node cur)
	{
		setBalance(cur);
		int balance = cur.balance;
		
		if(balance == -2)
		{
			if(height(cur.left.left) >= height(cur.left.right))
			{
				cur = rotateRight(cur);
			}
			else
			{
				cur = doubleRotateLeftRight(cur);
			}
		}
		else if(balance == 2)
		{
			if(height(cur.right.right) >= height(cur.right.left))
			{
				cur = rotateLeft(cur);
			}
			else
			{
				cur = doubleRotateRightLeft(cur);
			}
		}
		if(cur.parent != null)
		{
			recursiveBalance(cur.parent);
		}
		else
		{
			this.root = cur;
		}
	}
	
	
	//rotations
	public Node rotateLeft(Node n)
	{
		Node v = n.right;
		v.parent = n.parent;
		
		n.right = v.left;
		
		if(n.right != null)
		{
			n.right.parent = n;
		}
		
		v.left = n;
		n.parent = v;
		
		if(v.parent != null)
		{
			if(v.parent.right == n)
			{
				v.parent.right = v;
			}
			else if(v.parent.left == n)
			{
				v.parent.left = v;
			}
		}
		setBalance(n);
		setBalance(v);
		
		return v;
	}
	
	public Node rotateRight(Node n)
	{
		Node v = n.left;
		v.parent = n.parent;
		
		n.left = v.right;
		
		if(n.left != null)
		{
			n.left.parent = n;
		}
		
		v.right = n;
		n.parent = v;
		  
		  
		if(v.parent!=null)
		{
			if(v.parent.right==n)
			{
				v.parent.right = v;
			}
			else if(v.parent.left==n)
			{
				v.parent.left = v;
			}
		}
		  
		setBalance(n);
		setBalance(v);
		  
		return v;
	}
	
	public Node doubleRotateLeftRight(Node u)
	{
		u.left = rotateLeft(u.left);
		return rotateRight(u);
	}
	
	public Node doubleRotateRightLeft(Node u)
	{
		u.right = rotateRight(u.right);
		return rotateLeft(u);
	}
	
	
	
	
	private int height(Node cur)
	{
		if(cur == null)
		{
			return -1;
		}
		if(cur.left == null && cur.right == null)
		{
			return 0;
		}
		else if(cur.left == null)
		{
			return 1+height(cur.right);
		}
		else if(cur.right == null)
		{
			return 1+height(cur.left);
		}
		else
		{
			return 1+maximum(height(cur.left), height(cur.right));
		}
	}
	
	private int maximum(int a, int b)
	{
		if(a >= b)
		{
			return a;
		}
		else
		{
			return b;
		}
	}
	
	private void setBalance(Node cur)
	{
		cur.balance = height(cur.right) - height(cur.left);
	}
	
	public Node successor(Node q)
	{
		if(q.right != null)
		{
			Node r = q.right;
			while(r.right != null)
			{
				r = r.left;
			}
			return r;
		}
		else
		{
			Node p = q.parent;
			while(p != null && q == p.right)
			{
				q = p;
				p = q.parent;
			}
			return p;
		}
	}
	
	
	
	//toString
	private String indent(int s)
	{
		String result = "";
	    for (int i = 0; i < s; i++)
	    	result += "  ";
	    return result;
	  }

	private String print(Node node, int depth)
	{
		if (node == null)
			return "";
		else
			return print(node.right, depth + 1) + indent(depth) + node.toString() + "\n"
		+ print(node.left, depth + 1);
	  }
	
	public String toString()
	{
	    if (root == null)
	    	return "";
	    else
	    	return print(root, 0);
	}
}
