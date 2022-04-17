package com.sort;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class SimpleSort {

	public void bubbleSort(int[] a) {
		for (int j = 0; j < a.length - 1; j++) {

			for (int i = 0; i < a.length - 1; i++) {

				if (a[i] > a[i + 1]) {
					int temp = a[i + 1];
					a[i + 1] = a[i];
					a[i] = temp;
				}
			}
			System.out.println("循环" + j);
		}
	}

	public void selectSort(int[] a) {
		int temp = 0;
		for (int j = 0; j < a.length; j++) {

			// TODO: i =0 j 的时候为最大排序
			for (int i = j + 1; i < a.length; i++) {

				if (a[j] > a[i]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}

			}

		}

	}

	public void insertSort(int[] a) {

		int temp = 0;
		for (int j = 1; j < a.length; j++) {

			// TODO: 我本人的想法是从前往后比较，再加一层循环移动，书上的从后往前比较明显更简洁，二者效率并不会差太多
			for (int i = j; i > 0 && a[i] < a[i - 1]; i--) {

				temp = a[i];
				a[i] = a[i - 1];
				a[i - 1] = temp;

			}

		}

	}

	public void shellSort(int[] a) {

		int h = 1;
		while (h < a.length / 3)
			h = 3 * h + 1;
		int temp = 0;
		while (h >= 1) {
			System.out.println(h );

			for (int j = h; j < a.length; j++) {

				for (int i = j; i >= h && a[i] < a[i - h]; i -= h) {
					temp = a[i];
					a[i] = a[i - h];
					a[i - h] = temp;
				}
				show(a);
			}
			h = h / 3;
		}
	}

	public static void show(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("    a[" + i + "]:" + a[i]);
			
		}
		System.out.println();

	}

	public int a[];
	
	public static int[] createB(int size) {

		 int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Random().nextInt(100);

		}
		show(a);
		System.out.println();
		return a;
	}

	public int[] createA(int size) {
		a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Random().nextInt(100);

		}
		show(a);
		System.out.println();
		return a;
	}
	public  int[] createA() {
		createA(5);
		return a;
	}

	// TODO: this ss 对象与类的空间内存
	@Test
	public void TestBubbleSort() {
		SimpleSort ss = new SimpleSort();

		ss.createA();
		ss.bubbleSort(ss.a);

		show(ss.a);
	}
	@Test
	public void TestSelectSort() {
		SimpleSort ss = new SimpleSort();

		ss.createA();
		ss.selectSort(ss.a);

		show(ss.a);
	}
	@Test
	public void TestInsertSort() {
		SimpleSort ss = new SimpleSort();

		ss.createA();
		ss.insertSort(ss.a);

		show(ss.a);
	}
	@Test
	public void TestShellSort() {
		SimpleSort ss = new SimpleSort();

		ss.createA(16);
		ss.shellSort(ss.a);

		show(ss.a);
	}

}
