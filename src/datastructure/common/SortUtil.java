package common;

import java.util.Random;

public class SortUtil{
	
	public static boolean less(Comparable a, Comparable b) {
		
		
		return a.compareTo(b) < 0;
	}
	
	public static void exch(Comparable[] c,int a,int b) {
		Comparable temp = c[a];
		c[a] = c [b];
		c[b] = temp;
		
	}
	
	public static Integer[] createB(int size) {

		Integer[] a = new Integer[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Random().nextInt(100);

		}
		System.out.println("创建数组完成");
		show(a);
		return a;
	}
	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("    a[" + i + "]:" + a[i]);
			
		}
		System.out.println();

	}
	public static void show(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("    a[" + i + "]:" + a[i]);
			
		}
		System.out.println();

	}
}
