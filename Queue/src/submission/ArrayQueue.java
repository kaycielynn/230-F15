package submission;

import adt.Queue;

public class ArrayQueue<T> implements Queue<T> {
	@SuppressWarnings("unchecked")
	private T[] data = (T[]) new Object[10];
	private int head, tail;

	
	@Override
	public void enqueue(T newEntry) {
		if(head == tail+1 || (head == 0 && tail == data.length-1)){
			expand();
		}
		if (data[head] == null){
			data[head] = data[tail] = newEntry;
		}
		else {
			tail = (tail + 1) % data.length;
			data[tail] = newEntry;
		}
	}

	@SuppressWarnings("unchecked")
	public void expand(){
		T newArrayQueue[] = (T[]) new Object[(data.length * 2 + 1)];
		for(int i = 0; i < data.length; i++){
			newArrayQueue[i] = data[i];
		}
		data = newArrayQueue;
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
		return head == tail && data[head] == null; 
	}

	@Override
	public void clear() {
		for(int i = 0; i < data.length; i++) {
			data[i] = null;
		}
		head = tail = 0;
	}
	
	public String toString() {
		String s = "- >";
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
