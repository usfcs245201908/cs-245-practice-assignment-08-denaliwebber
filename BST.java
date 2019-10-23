public class BST<T extends Comparable<T>>
{
	protected Node root=null;


	public boolean find(Comparable item)
	{
		return find(item, root);
	}

	private boolean find(Comparable item, Node node)
	{
		if(node==null)
			return false;

		if (item.compareTo(node.data)==0)
			return true;

		else if(item.compareTo(node.data)<0)
			return find(item, node.left);

		else
			return find(item, node.right);
	}

	public void insert(Comparable item)
	{
		root = insert(item, root);
	}

	private Node insert(Comparable item, Node node)
	{
		if (node == null)
			node = new Node(item);
		else if (item.compareTo(node.data)<0)
		{
			node.left = insert(item, node.left);
		}
		else
		{
			node.right=insert(item, node.right);
		}
		return node;
	}

	public void print()
	{
		print(root);
	}

	private void print(Node root)
	{
		if (root != null)
		{
			print(root.left);
			System.out.println(root.data);
			print(root.right);
		}
	}

	public void delete(Comparable item)
	{
		root=delete(item, root);
	}

	public Node delete(Comparable item, Node node)
	{
		if (node == null)
		{
			return null;
		}
		if (node.data.compareTo(item)==0)
		{
			if (node.left == null)
				return node.right;
			else if (node.right == null)
				return node.left;
			else
			{
				if (node.right.left ==null)
				{
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				}

				else
				{
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		}

		else if (item.compareTo(node.data)<0)
		{
			node.left = delete(item, node.left);
			return node;
		}

		else
		{
			node.right=delete(item, node.right);
			return node;
		}

	}

	private Comparable removeSmallest(Node node)
	{
		if (node.left.left == null)
		{
			Comparable smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		else
			return removeSmallest(node.left);
	}

	private class Node<Comparable>
	{
		protected T data;
		protected Node left;
		protected Node right;

		public Node(T item)
		{	
			data = item;
			left = null;
			right = null;
		}
	}

}