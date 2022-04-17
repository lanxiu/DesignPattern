package com.queue;

import com.sort.SimpleSort;
import static com.sort.SimpleSort.show;

public class MaxPQInt {

	public int[] a = null;
	int max = 0;

	public MaxPQInt() {
		a = new int[5];
		this.max = 5;
	}
	public MaxPQInt(int max) {
		a = new int[max];
		this.max = max;

	}
	public MaxPQInt(int[] a) {
		this.a = a;
		this.max = a.length;
	}

	void insert(int v) {
		a[max-1 ] = v;
		swim(max - 1);

	}

	int max() {

		return 0;
	}
	int delMax() {

		int tmp = a[1];
		a[1] = a[max - 1];
		a[max - 1] = tmp;
		max--;
		sink(1);

		return 0;
	}

	boolean isEmpty() {
		return true;
	}

	private void swim(int k) {
		while (k > 1 && a[k] > a[k / 2]) {
			int tmp = a[k];
			a[k] = a[k / 2];
			a[k / 2] = tmp;
			k= k/2;
		}
	}

	private void sink_origin(int k) {
		while (k > 1 && k < max) {

			if (2 * k < max && a[k] < a[2 * k]) {

				int tmp = a[k];
				a[k] = a[2 * k];
				a[2 * k] = tmp;
				k = 2 * k;
			} else if (2 * k < max && a[k] < a[2 * k + 1]) {

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
		while (k * 2 <= max) {
			int j = k * 2;
			if (j < max && a[j] < a[j + 1])
				j++;
			if (a[k] > a[j])
				break;
			int tmp = a[k];
			a[k] = a[j];
			a[j] = tmp;
		}
	}

	int size() {
		return 0;
	}
	
	
	public static void main(String[] args) {
		int a[] =  SimpleSort.createB(5);
		  new SimpleSort().bubbleSort(a);
//		  a[0] = -1;
//		  a[1] =5;
//		  a[2] =4;
//		  a[3] =3 ;
//		  a[4] =18 ;
//		  show (a);
		MaxPQInt  mp = new MaxPQInt(a);
		mp.swim(4);
		show(a);
		
		
	}
	

}
