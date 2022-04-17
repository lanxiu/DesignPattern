package com.sort;

import java.util.Random;

public class Test {

	public int a[];

	public void createA() {
		a = new int[20];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Random().nextInt(100);

			System.out.print("    a[" + i + "]:" + a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.createA();
		System.out.println(test.a);

		for (int i = 0; i < 1; i++) {

			System.out.println("aaaaaaaa        " + i);
		}

		int h = 1;
		while (h < 5 / 3)
			h = 3 * h + 1;
		System.out.println(h);
		h = 1;
		while (h < 13 / 3)
			h = 3 * h + 1;
		System.out.println(h);
		h = 1;
		while (h < 15 / 3)
			h = 3 * h + 1;
		System.out.println(h);
		h = 1;
		while (h < 16 / 3)
			h = 3 * h + 1;
		System.out.println(h); 
	}

}
