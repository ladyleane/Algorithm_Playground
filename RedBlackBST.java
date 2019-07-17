public static class RedBlackBST<Key extends Comparable<Key>, Value>{
	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root;

	private class Node{
		Key key;
		Value val;
		Node left, right;
		int N;
		boolean color;
		
		Node(Key key, Value val, int N, boolean color){
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}

	private boolean isRed(Node h){
		if (h == null)	return false;
		return h.color == RED;
	}

	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}

	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}

	private void flipColors(Node h){
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	private int size(){
		return size(root);
	}

	private int size(Node x){
		if (x == null)	return 0;
		else	return x.N;
	}

	public void put(Key key, Value val){
		root = put(root, key, val);
		root.color = BLACK;
	} //Find key and update, otherwise create a node.

	private Node put(Node h, Key key, Value val){
		if (h == null)
			return new Node(key, val, 1, RED);
		int cmp = key.compareTo(h.key);
		if (cmp < 0)	h.left = put(h.left, key, val);
		else if (cmp > 0)	h.right = put(h.right, key, val);
		else	h.val = val;

		if (isRed(h.right) && !isRed(h.left)) 	h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))	h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))	flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	//deleteMin(); Ex-3.3.39
	private Node moveRedLeft(Node h){
		//Suppose h is RED, h.left and h.right are BLACK;
		//Change h.left or one of its sons into RED;

		flipColors(h);
		if (isRed(h.right.left)){
			h.right = rotateRight(h.right);
			h = rotateLeft(h);
		}
		return h;
	}

	public void deleteMin(){
		if (!isRed(root.left) && isRed(root.right))
			root.color = RED;
		root = deleteMin(root);
		if (!isEmpty())	root.color = BLACK;
	}

	private Node deleteMin(Node h){
		if (h.left == null)
			return null;
		if (!isRed(h.left) && !isRed(h.left.left))
			h = moveRedLeft(h);
		h.left = deleteMin(h.left);
		return balance(h);
	}

	private Node balance(Node h){
		if (isRed(h.right))	h = rotateLeft(h);
		if (isRed(h.right) && !isRed(h.left)) 	h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))	h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))	flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	//deleteMax(); Ex-3.3.40
	private Node moveRedRight(Node h){
		//Suppose h is RED, h.right and h.right.left are BLACK;
		//Change h.right or one of h.right's sons into RED;
		flipColors(h);
		if (!isRed(h.left.left))
			h = rotateRight(h);
		return h;
	}

	public void deleteMax(){
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMax(root);
		if (!isEMpty())	root.color = BLACK;
	}

	private Node deleteMax(Node h){
		if (isRed(h.left))
			h = rotateRight(h);
		if (h.right == null)
			return null;
		if (!isRed(h.right) && !isRed(h.right.left))
			h = moveRedRight(h);
		h.right = deleteMax(h.right);
		return balance(h);
	}

	//delete();
	public void delete(Key key){
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = delete(root, key);
		if (!isEmpty())	root.color = BLACK;
	}

	private Node delete(Node h, Key key){
		if (key.compareTo(h.key) < 0){
			if (!isRed(h.left) && !isRed(h.left.left))
				h = moveRedLeft(h);
			h.left = delete(h.left, key);
		}
		else{
			if (isRed(h.left))
				h = rotateRight(h);
			if (key.compareTo(h.key) == 0 && (h.right == null))
				return null;
			if (!isRed(h.right) && !isRed(h.right.left))
				h = moveRedRight(h);
			if (key.compareTo(h.key) == 0){
				h.val = get(h.right, min(h.right).key);
				h.key = min(h.rihgt).key;
				h.right = deleteMin(h.right);
			}
			else h.right = delete(h.right, key);
		}
		return balance(h);
	}
	//floor(), ceiling(), rank(), select();
	//range();

}