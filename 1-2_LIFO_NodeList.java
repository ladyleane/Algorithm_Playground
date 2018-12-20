import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//Last-in-First-out stack, using NodeList.
//File name do not match class name, necessary modifications required.

public class Stack<Item>{
	private Node first;
	private int N;

	private class Node{
		Item item;
		Node next;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public int size(){
		return N;
	}

	public void push(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return Item;
	}

	//Test Case
	public static void main(String[] args){
		Stack<String> s = new Stack<String> ();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!Item.equals("-"))
				s.push(Item);
			else if(!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + "left in Stack)");
	}
}