package com.wh.sort;

import java.util.Arrays;
import java.util.List;

public class Sort {
	/**
	 * ֱ�Ӳ�������
	 * @param a
	 */
	public static void insertSort(Integer[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			for (; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
	}

	/**
	 * �۰��������
	 * @param a
	 */
	public static void binInsertSort(Integer[] a) {
		for (int i = 1; i < a.length; i++) {
			int l = 0;
			int h = i-1;
			int m = (h + l)/2;
			while (h >= l) {
			//�� h==l ʱ,Ҫ�ٱȽ�һ��,�����ſ���ȷ��Ҫ���뵽a[m]֮ǰ����֮��
			//����  ��Ҫʹ��ԭʼ�汾��ѭ���������
				if (a[i] > a[m]) {
					l = m+1;
				}else {
					h = m-1;
				}
				m = (h + l)/2;
			}
			int temp = a[i];
			//ԭʼ�汾
			/*if (temp > a[m]) {
				for (int j = i; j >= m+1; j--) {
					a[j] = a[j-1];
				}
				a[m+1] = temp;
			}else {
				for (int j = i; j > m; j--) {
					a[j] = a[j-1];
				}
				a[m] = temp;
			}*/
			//�Ľ��汾
			for (int j = i; j > h+1; j--) {
				a[j] = a[j-1];
			}
			a[h+1] = temp;
			
		}
	}
	
	public static void shellSort(Integer[] a) {
		for (int n = a.length/2; n >= 1; n = n/2) {
			for (int i = 0; i < n; i++) {
				for (int j = i; j < a.length; j = j + n) {
					for (int k = j + n; k > 0; k = k - n) {
						if (a[k] < a[k-n]) {
							int temp = a[k];
							a[k] = a[k-n];
							a[k-n] = temp;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = { 38, 65, 97, 76, 13, 27, 49, 78, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		print(a,"��ʼֵ");
		System.out.println("��ȷֵ:[4, 5, 12, 13, 15, 17, 18, 23, 25, 27, 34, 35, 38, 49, 51, 53, 54, 56, 62, 64, 65, 76, 78, 97, 98, 99]");
		//insertSort(a);
		//binInsertSort(a);
		shellSort(a);
		print(a,"�㷨ֵ");
	}
	
	private static void print(Integer[] a,String message) {
		List<Integer> l = Arrays.asList(a);
		System.out.println(message+":"+l);
		
	}
}
