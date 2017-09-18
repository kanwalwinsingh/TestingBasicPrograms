package geekForGeeksBinaryTrees;

public class BinaryTree {
	
	//class containing left and right child of current node and key value.
	static class Node{
		int key;
		Node left, right;
		public Node(int key) {
			this.key = key;
			left = right = null;
		}
		
		
	}
	
	//root of binary tree
	Node root;
	
	
	//Constructor
	public BinaryTree(int key) {
		super();
		this.root = new Node(key);
	}
	
	

	public BinaryTree() {
		root = null;
	}





	public static void main(String[] args) {
		BinaryTree tree  = new BinaryTree();
		
		//create root
		tree.root = new Node(1);
		
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		tree.root.left.left = new Node(4);

	}

}
