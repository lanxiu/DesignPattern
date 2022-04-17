package com.linklist;

public class SequentialSearchST<Key , Value> {
	private class Node {
		Key key;
		Value value;
		Node next;
		public Node(Key key,Value value,Node next) {
			this.key = key;
			this.value=value;
			this.next = next;
		}
	}
	private Node first;
	
	public Value get(Key key) {
		
		for(Node x = first; x!= null; x=x.next) {
			if(x.key .equals(key)) {
				return x.value;
			}
		}
		return null;
		
	}
	

	public void put(Key key,Value value) {

		for(Node x = first; x!= null; x=x.next) {
			if(x.key .equals(key)) {
				x.value = value; return  ;
			}
		}
		 first = new Node(key, value, first);
	}
	
}
