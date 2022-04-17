package com.linklist;

import com.queue.MaxPQ;

import common.SortUtil;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	
	private class Node {
		Key key;
		Value value;
		Node left,right;
		int n ;
		public Node(Key key,Value value,int n) {
			this.key = key;
			this.value=value;
			this.n  = n ;
		}
	}
	private Node root;

	private Key[] keys;
	private Value[] vals;
	private int n;
	public BinarySearchTree(int size) {
		keys = (Key[]) new Comparable[size];
		vals = (Value[]) new Object[size];
		n=0;

	}

	public int size() {
		return size(root);
	}
	public int size(Node x) {
		
		if(x == null) 
			return 0;
		return x.n;
		
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public Value get(Key key) {
		 return get(root,key);

	}
	
	public Value get(Node x,Key key) {
		if(x== null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0 ) return get(x.left,key);
		if(cmp > 0 ) return get(x.right,key);
		return x.value;
		
	}

	 

	public void put(Key key, Value val) {
		 
		root = put(root,key,val);
	}
	public Node put( Node x,Key key, Value val) {
		 
		
		if(x== null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		if(cmp<0)
			x.left = put(x.left,key,val);
		else if(cmp >0)
			x.right = put(x.right,key,val);
		else
			x.value  = val;
		x.n = size(x.left)+ size(x.right)+1;
		return x;
		
	}
	
	public Key min () {
		return min(root).key;
	}
	
	public Node min(Node x) {
		if(x.left == null)
			return x;
		return min(x.left);
	}
	
	public Key floor(Key key) {
		Node x = floor(root,key);
		if(x== null)
			return null;
		return x.key;
	}
	
	public Node floor(Node x,Key key) {
		
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp <0 ) return floor(x.left,key);
		Node t = floor(x.right,key);
		if(t!=null) return t;
		return x;
		
		
	}
	
	public Key select(int k) {
		return select(root,k).key;
	}
	
	public Node select(Node x,int k) {
		
		if(x== null)
			return null;
		int  t = size(x.left);
		if(t>k) return select(x.left,k);
		if(t<k) return select(x.right,k-t-1);
		return x;
		
	}
	
	public int rank(Key key) {
		
		return rank(key,root);
	}
	
	public int rank(Key key,Node x) {
		
		if(x==null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return rank(key,x.left);
		if(cmp > 0) return 1+size(x.left)+rank(key,x.right);
		return size(x.left);
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	public Node deleteMin(Node x) {
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left	);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
		
		
	}
	
	
	public Node delete(Node x, Key key) {

		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.n = size(x.left) + size(x.right) + 1;

		return x;

	}
	
 
	//TODO:
	public Iterable<Key> keys(Key lo,Key hi) {
		 return null;
		
		
	}
	

	public static void main(String[] args) {
		BinarySearchST<Integer, Integer> bst = new BinarySearchST(5);

		Integer[] a = SortUtil.createB(5);
		new MaxPQ().sort(a);
		for (int i = 0; i < a.length; i++) {
			bst.put(a[i], a[i]);
		}
		 
	}

}
