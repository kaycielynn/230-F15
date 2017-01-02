package submission;

import adt.Queue;

public class LinkedQueue<T> implements Queue<T> {
	private Node head, tail;
	
	@Override
	public void enqueue(T newEntry) {
		if (head == null) {
			head = tail = new Node(newEntry);
		}
		else {
			tail = tail.next = new Node(newEntry); 
		}
	}

	@Override
	public T dequeue() {
		if (!isEmpty()){
			T temp = head.data;
			head = head.next;
			return temp;
		}
		return null;
	}

	@Override
	public T peek() {
		return head.data;
	}

	@Override
	public boolean isEmpty() {
		return head == tail && head == null;
	}

	@Override
	public void clear() {
		head = tail = null;
	}
	
	public String toString() {
		String s = head.data.toString();
		for (Node i = head.next; i != null; i = i.next)
			s += " -> " + i.data;
		s+= "\n";
		return s;
	}
	
	private class Node 
	{
	  private T    data; // Entry in bag
	  private Node next; // Link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
	} // end Node

}
