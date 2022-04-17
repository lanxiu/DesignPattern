package com.sort;

import static com.sort.SimpleSort.show;

import org.junit.jupiter.api.Test;

public class SpeedSort {

	//TODO: 三向切分排序  待补充
	
	public void sort(int[] a, int lo, int hi) {

		if (lo >= hi)
			return;
		int j = 0;

		j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	public int partition2(int[] a, int lo, int hi) {

		int j = hi;
		int i = lo + 1;
		int tt = lo;
		int temp;
		for (; i <= j; i++) {

			if (a[i] >= a[lo]) {

				for (; j > i; j--) {
					if (a[j] < a[lo]) {
						temp = a[j];
						a[j] = a[i];
						a[i] = temp;
						tt = i;
						break;
					}
				}

			} else
				tt = i;

		}
		temp = a[lo];
		a[lo] = a[tt];
		a[tt] = temp;

		return j;

	}
	public int partition (int[] a, int lo, int hi) {
		int i= lo;
		int j = hi+1;
		int v = a[i];
		int temp;
		while(true) {

			while(a[++i] <= v)
				if (i== hi)
					break;

			while(a[--j] > v)
				if (j==lo)
					break;
			if(i>=j)
				break;
			

			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			
		}
		

		temp = a[lo];
		a[lo] = a[j];
		a[j] = temp;
		return j;
	}

		 
	
	

	@Test
	public void testSort() {
		SimpleSort ss = new SimpleSort();
		// int a[] = {1,2,3,4,5};
		// int a[] = {80,6,84,71,73};
		// for (int i = 0; i < 4; i++) {
		// int a[] = ss.createA();
		int a[] = {80, 6, 84, 71, 99};
		partition(a, 0, a.length - 1);
		System.out.println("sort complete");
		show(a);
		// }
	}

}
