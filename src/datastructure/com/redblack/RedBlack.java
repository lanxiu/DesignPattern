package com.redblack;

 

public class RedBlack<Key extends Comparable<Key>,Value> {
	
	
	//TODO:插入为什么是红链接  从2-3树开始研究
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node {
		Key key;
		Value val;
		
		Node left,right;
		int n;
		boolean color;
		
		
		Node(Key key,Value val,int n,boolean color) {
			this.key = key;
			this.val  = val;
			this.n = n;
			this.color = color;
		}
		
		
	}
	public int size(Node x) {

		if (x == null)
			return 0;
		return x.n;

	}
	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}
	
	Node rotateLeft(Node h) {
		
		Node x = h.right;
		h.right = x.left;
		x.left =  h;
		x.color = h.color;
		h.color  = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.left);
		return x;
		
		
	}
	
	Node rotateRight(Node h) {
		
		Node x = h.left;
		h.left = x.right;
		x.right =  h;
		x.color = h.color;
		h.color  = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.left);
		return x;
		
		
	}
	
	
	void flipColors(Node h ) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public void put(Key key,Value val) {
		root = put(root,key,val);
		root.color = BLACK;
	}
	
	private Node put(Node h , Key key, Value val) {
		if (h == null)
			return new Node(key,val,1,RED);
		
		int cmp = key.compareTo(h.key);
		
		if(cmp < 0 ) h.left = put(h.left,key,val);
		else if(cmp > 0) h.right  = put(h.right,key , val);
		else h.val = val;
		
		if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.right) && isRed(h.left)) flipColors(h);
		
		h.n = size(h.left) + size(h.right) + 1;
		
		
		
		return h;
	}
	
	
	
	

}
