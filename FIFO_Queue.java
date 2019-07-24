import cs.princeton.edu.algs4.StdIn
import cs.princeton.edu.algs4.StdOut

//FIrst-in-First-out queue, using NodeList.
//File name do not match class name, necessary modifications required.

public class Queue<Item>{
	private Node first;
	private Node last;
	private int N;

	private class Node{
		Item item;
		Node next;
	}

	public boolean isEmpty(){
		return N == 0;
	}

	public int size(){
		return N;
	}

	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}

	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty())
			last == null;
		N--;
		return item;
	}

	//Test Case
	public static void main(String[] args){
		Queue<String> q = new Queue<String>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!item.equals("-"))
				q.enqueue(item);
			else if(!q.isEmpty())
				StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)")
	}
}
