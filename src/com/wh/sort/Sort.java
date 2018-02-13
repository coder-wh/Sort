package com.wh.sort;

import java.util.Arrays;
import java.util.List;

public class Sort {
	/**
	 * ֱ�Ӳ�������
	 * @param a
	 */
	public static void insertSort(Integer[] a) {
		//��ѭ���ӵڶ���Ԫ�ؿ�ʼ���κ���
		for (int i = 1; i < a.length; i++) {
			//�˴��ж�Ϊ���ڲ�������ļ���  ǰ���Ԫ�ض��������  �������a[i] �Ѿ����ڵ��� a[i-1]ʱ  ���ʱa[i]�Ͳ���Ҫ������һ��������
			if (a[i] < a[i-1]) {
				int temp = a[i];
				int j = i - 1;
				for (; j >= 0 && temp < a[j]; j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = temp;
			}
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
	
	/**
	 * ϣ������
	 * @param a
	 */
	public static void shellSort(Integer[] a) {
		//���Ʋ���n ��������ȡ������һ��  �����Լ�����ÿ�εĲ���    �����ղ�����Ҫ˥����1
		for (int n = a.length/2; n >= 1; n = n/2) {
			//���ݲ�����ÿ������ĵ�һ��Ԫ�ؿ�ʼ
			for (int i = 0; i < n; i++) {
				//��ÿ������ĵڶ���Ԫ�ؿ�ʼ����������
				for (int j = i + n; j < a.length; j = j + n) {
					for (int k = j; (k-n) >= 0 && k < a.length; k = k - n) {
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
	
	/**
	 * �Ľ���ϣ������
	 * ��Դ������    http://blog.csdn.net/luoweifu/article/details/9273067
	 * @param a
	 */
	public static void shellSort2(Integer[] a) {
		for (int n = a.length/2; n >= 1; n = n/2) {
			for (int i = 0 + n; i < a.length; i++) {
				if (a[i] < a[i-n]) {
					int temp = a[i];
					int j = i - n;
					for (; j >= 0 && temp < a[j]; j = j-n) {
						a[j+n] = a[j];
					}
					a[j+n] = temp;
				}
			}
		}
	}
	
	/**
	 * ð������
	 * @param a
	 */
	public static void bubbleSort(Integer[] a) {
		for (int i = a.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * ��������
	 * ԭ������:  http://blog.csdn.net/code_ac/article/details/74158681
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void quickSort(Integer[] a, int l, int h) {
		int key = a[l];
		int i = l;
		int j = h;
		while (i < j) {
			for (; a[j] > key && i < j; j--) {
				
			}
			if (i < j) {
				swap(a,i,j);
				i++;
			}
			for (; a[i] < key && i < j; i++)	{
				
			}
			if (i < j) {
				swap(a,i,j);
				j--;
			}
		}
		if (i-1 > l) {
			quickSort(a,l,i-1);
		}
		if (j+1 < h) {
			quickSort(a,j+1,h);
		}
	}
	
	/**
	 * ��������
	 * ��Դ������
	 * @param targetArr
	 * @param start
	 * @param end
	 */
	/*//////////////��ʽ�������ٽ������������Ч��/////////////////////*/
	private <T extends Comparable<? super T>> void quickSort(T[] targetArr, int start, int end) {
		int i = start, j = end;
		T key = targetArr[start];
		while (i < j) {
			/* ��j--�������Ŀ�����飬ֱ����keyС��ֵΪֹ */
			while (j > i && targetArr[j].compareTo(key) >= 0) {
				j--;
			}
			if (i < j) {
				/* targetArr[i]�Ѿ�������key�У��ɽ������������ */
				targetArr[i] = targetArr[j];
				i++;
			}
			/* ��i++�������Ŀ�����飬ֱ����key���ֵΪֹ */
			while (i < j && targetArr[i].compareTo(key) <= 0)
			/* �˴�һ��ҪС�ڵ����㣬��������֮����һ�ڸ�1��0������ֵĻ�����key��ֵ��ǡ����1�Ļ�����ô���С�ڵ��ڵ����þͻ�ʹ�����if�����ִ��һ�ڴΡ� */
			{
				i++;
			}
			if (i < j) {
				/* targetArr[j]�ѱ�����targetArr[i]�У��ɽ�ǰ���ֵ���� */
				targetArr[j] = targetArr[i];
				j--;
			}
		}
		/* ��ʱi==j */
		targetArr[i] = key;
		/* �ݹ���ã���keyǰ���������� */
		this.quickSort(targetArr, start, i - 1);
 		/* �ݹ���ã���key������������ */
		this.quickSort(targetArr, j + 1, end);

	}
	
	private static void swap(Integer[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * ѡ������
	 * @param a
	 */
	public static void selectSort(Integer[] a) {
		for (int i = 0; i < a.length; i++) {
			int index = i;
			int minValue = a[i];
			for (int j = i+1; j < a.length; j++) {
				if (a[j] < minValue) {
					minValue = a[j];
					index = j;
				}
			}
			swap(a,i,index);
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = { 38, 65, 97, 76, 13, 27, 49, 78, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		print(a,"��ʼֵ");
		System.out.println("��ȷֵ:[4, 5, 12, 13, 15, 17, 18, 23, 25, 27, 34, 35, 38, 49, 51, 53, 54, 56, 62, 64, 65, 76, 78, 97, 98, 99]");
		//insertSort(a);
		//binInsertSort(a);
		//shellSort2(a);
		//bubbleSort(a);
		//quickSort(a,0,a.length-1);
		selectSort(a);
		print(a,"�㷨ֵ");
	}
	
	private static void print(Integer[] a,String message) {
		List<Integer> l = Arrays.asList(a);
		System.out.println(message+":"+l);
		 
	}
}
