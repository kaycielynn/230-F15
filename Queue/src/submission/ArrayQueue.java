package submission;

import adt.Queue;

public class ArrayQueue<T> implements Queue<T> {
	private T[] data;
	private int head, tail;

	
	@Override
	public void enqueue(T newEntry) {
		tail = (tail+1) % data.length;
		data[tail] = newEntry;
	}

	@Override
	public T dequeue() {
		if(isEmpty()){
			return null;
		}
		else { 
			T temp = data[head];
			data[head] = null;
			head = (head + 1) % data.length;
			return temp;
		}
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		return data[head];
	}

	@Override
	public boolean isEmpty() {
		//if the head is empty, the whole thing is empty
		return data[head]==null;
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			dequeue();
		} 
		
	}
	
	public String toString() {
		String s = "";
		if (!isEmpty())
			s = data[head].toString();
		for (int i =  (head+1) % data.length; 
				 i <= (tail + data.length) % data.length; 
				 i =  (i + 1) % data.length)
			s += " -> " + data[i];
		s+= "\n";
		return s;
	}
public static void main(String[]args){
	System.out.println("Hello");
}
}
