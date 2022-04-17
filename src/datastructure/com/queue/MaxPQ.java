package com.queue;

import static common.SortUtil.exch;
import static common.SortUtil.less;
import static common.SortUtil.show;

import common.SortUtil;

/**
 * 堆的处理
 * 
 * 未处理:索引优先队列 处理归并问题
 * 
 * @author lenchol
 *
 * @param <Key>
 */

public class MaxPQ<Key extends Comparable<Key>> {

	public Key[] pq = null;
	private int n = 0;

	public MaxPQ( ) {
	}
 
		public MaxPQ(int n) {

		pq = (Key[]) new Comparable[n + 1];
		
		this.n = n;

	}
	public MaxPQ(Integer[] n) {
		this.n = n.length-1;
		pq = (Key[]) new Comparable[this.n+1];
		for(int i=0;i<n.length;i++)
			pq[i] = (Key)n[i];

	 
		

	}

	void insert(Key v) {
		pq[++n] = v;
		swim(n);
	}

	public Key delMax() {

		Key max = pq[1];
		exch(pq, 1, n--);
		pq[n + 1] = null;
		sink(1);

		return max;
	}
	public int size() {
		return n;
	}

	boolean isEmpty() {
		return n == 0;
	}

	private void swim(int k) {
		while (k > 1 && less(pq[k / 2], pq[k])) {
			exch(pq, k, k / 2);
			k = k / 2;
		}
	}

	private void sink_origin(int a[], int k) {
		while (k > 1 && k < a.length) {

			if (2 * k < a.length && a[k] < a[2 * k]) {

				int tmp = a[k];
				a[k] = a[2 * k];
				a[2 * k] = tmp;
				k = 2 * k;
			} else if (2 * k < a.length && a[k] < a[2 * k + 1]) {

				int tmp = a[k];
				a[k] = a[2 * k + 1];
				a[2 * k + 1] = tmp;
				k = 2 * k + 1;
			} else {
				return;
			}

		}
	}

	private void sink(int k) {
		while (k * 2 <= n) {
			int j = k * 2;
			if (j < n && less(pq[j], pq[j + 1]))
				j++;
			if (less(pq[j], pq[k]))
				break;
			exch(pq, k, j);
			k = j;

		}

	}
	private void sink(Comparable pq[], int k, int n) {
		while (k * 2 <= n) {
			int j = k * 2;
			if (j < n && less(pq[j], pq[j + 1]))
				j++;
			if (less(pq[j], pq[k]))
				break;
			exch(pq, k, j);
			k = j;

		}

	}

	public void sort(Comparable[] a) {
		int n = a.length-1;
		for (int k = n / 2; k >= 1; k--)
			sink(a, k, n);
		System.out.println("堆有序化");
		show(a);

		while (n > 1) {
			exch(a, 1, n--);
			sink(a, 1, n);
		}
		System.err.println("排序完成");
		show(a);
	}
	
	public static void main(String[] args) {
		MaxPQ<Integer> mq = new MaxPQ<Integer>( SortUtil.createB(10));
		mq.sort(SortUtil.createB(10));
		 
	}

}
