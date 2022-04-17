package com.sort;

import static com.sort.SimpleSort.show;

import org.junit.jupiter.api.Test;;

public class MergeSort {

	public void merge(int[] a, int start, int mid, int end) {

		int i = start;
		int j = mid+1;

		int[] acopy = new int[end   + 1];
		for (int k = i; k <= end; k++) {
			acopy[k] = a[k];
		}
		show(acopy);
		for (int k = i; k <= end; k++) {

			if (i > mid)
				a[k] = acopy[j++];
			else if (j > end)
				a[k] = acopy[i++];
			else if (acopy[i] > acopy[j])
				a[k] = acopy[j++];
			else
				a[k] = acopy[i++];

		}
		System.out.println("归并排序完成");
		 show(a);

	}

	// 自顶向下
	public void sort(int[] a, int start, int end) {
		if (start >= end)
			return;
		int mid = start + (end-start) / 2;
		sort(a, start, mid);
		sort(a, mid + 1, end);
		merge(a, start, mid, end);
	}
	// 自下向上
	//TODO: 十分巧妙的处理方式
	//我的想法是从2开始，计算各段数据，后续还要拉出来单独处理
	public void sort2(int[] a  ) {

		int  n =  a.length;
		for(int sz = 1;sz<n;sz*=2) {
			
			for(int k = 0;k<n-sz;k+=2*sz) {
				merge(a, k, k+sz-1, Math.min(k+sz*2-1, n-1));
			}
			
			
		}

 
	}
	
	
	public int[] create() {
		int[] a = SimpleSort.createB(5);

		int[] b = SimpleSort.createB(5);

		SimpleSort ss = new SimpleSort();
		ss.bubbleSort(a);
		ss.bubbleSort(b);

		int[] d = new int[10];
		for (int k = 0; k < 5; k++) {
			d[k] = a[k];
			d[k + 5] = b[k];

		}
		System.out.println("合并数组：");
		 show(d);
		return d;
	}
	
	
	@Test
	public void testMergeSort() {
		int[] d = this.create();
		this.merge(d, 0, 4, 9);
	}

	@Test
	public void testCIrcleMergeSort() {
		
		int[] a = SimpleSort.createB(4);
		
		sort(a, 0, a.length-1);
		System.out.println("递归归并排序完成");
		show(a);
		
	}
	@Test
	public void testSort2() {
		
		int[] a = SimpleSort.createB(4);
		
		sort2(a );
		System.out.println("自上向下递归归并排序完成");
		show(a);
		
	}

}
