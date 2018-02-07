package com.wh.sort;

public class Sort {
	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (temp < a[j]) {
					a[j + 1] = a[j];
				}else {
					break;
				}
			}
			a[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		insertSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
