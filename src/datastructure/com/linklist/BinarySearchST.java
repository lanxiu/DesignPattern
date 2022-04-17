package com.linklist;

import java.util.Queue;

import com.queue.MaxPQ;

import common.SortUtil;

/**
 * 链表 折半查找
 * @author lenchol
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private Key[] keys;
	private Value[] vals;
	private int n;
	public BinarySearchST(int size) {
		keys = (Key[]) new Comparable[size];
		vals = (Value[]) new Object[size];
		n=0;

	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public Value get(Key key) {
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < n && keys[i].compareTo(key) == 0)
			return vals[i];
		return null;

	}

	public int rank(Key key) {

		// rank(key,0,keys.length -1);

		int lo = 1;
		int hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			System.out.println(mid);
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	public int rank(Key key, int lo, int hi) {

		if (hi < lo)
			return lo;
		int mid = lo + (hi - lo) / 2;
		int cmp = key.compareTo(keys[mid]);
		if (cmp < 0)
			return rank(key, lo, mid - 1);
		if (cmp > 0)
			return rank(key, mid + 1, hi);
		return mid;

	}

	public void put(Key key, Value val) {
		int i = rank(key);
		if (i < n && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}

		for (int j = n; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}

		keys[i] = key;
		vals[i] = val;
		n++;
	}
	
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
		SortUtil.show(bst.keys);
	}

}
