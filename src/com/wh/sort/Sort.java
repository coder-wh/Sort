package com.wh.sort;

import java.util.Arrays;
import java.util.List;

public class Sort {
	/**
	 * 直接插入排序
	 * @param a
	 */
	public static void insertSort(Integer[] a) {
		//外循环从第二个元素开始依次后移
		for (int i = 1; i < a.length; i++) {
			//此处判断为基于插入排序的假设  前面的元素都是有序的  所以如果a[i] 已经大于等于 a[i-1]时  则此时a[i]就不需要再做这一轮排序了
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
	 * 折半查找排序
	 * @param a
	 */
	public static void binInsertSort(Integer[] a) {
		for (int i = 1; i < a.length; i++) {
			int l = 0;
			int h = i-1;
			int m = (h + l)/2;
			while (h >= l) {
			//当 h==l 时,要再比较一次,这样才可以确定要插入到a[m]之前还是之后
			//否则  就要使用原始版本的循环插入语句
				if (a[i] > a[m]) {
					l = m+1;
				}else {
					h = m-1;
				}
				m = (h + l)/2;
			}
			int temp = a[i];
			//原始版本
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
			//改进版本
			for (int j = i; j > h+1; j--) {
				a[j] = a[j-1];
			}
			a[h+1] = temp;
			
		}
	}
	
	/**
	 * 希尔排序
	 * @param a
	 */
	public static void shellSort(Integer[] a) {
		//控制步长n 可以依次取步长的一半  可以自己定义每次的步长    但最终步长需要衰减到1
		for (int n = a.length/2; n >= 1; n = n/2) {
			//依据步长从每个分组的第一个元素开始
			for (int i = 0; i < n; i++) {
				//从每个分组的第二个元素开始做插入排序
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
	 * 改进版希尔排序
	 * 来源于网络    http://blog.csdn.net/luoweifu/article/details/9273067
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
	 * 冒泡排序
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
	 * 快速排序
	 * 原理剖析:  http://blog.csdn.net/code_ac/article/details/74158681
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
	 * 快速排序
	 * 来源于网络
	 * @param targetArr
	 * @param start
	 * @param end
	 */
	/*//////////////方式三：减少交换次数，提高效率/////////////////////*/
	private <T extends Comparable<? super T>> void quickSort(T[] targetArr, int start, int end) {
		int i = start, j = end;
		T key = targetArr[start];
		while (i < j) {
			/* 按j--方向遍历目标数组，直到比key小的值为止 */
			while (j > i && targetArr[j].compareTo(key) >= 0) {
				j--;
			}
			if (i < j) {
				/* targetArr[i]已经保存在key中，可将后面的数填入 */
				targetArr[i] = targetArr[j];
				i++;
			}
			/* 按i++方向遍历目标数组，直到比key大的值为止 */
			while (i < j && targetArr[i].compareTo(key) <= 0)
			/* 此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。 */
			{
				i++;
			}
			if (i < j) {
				/* targetArr[j]已保存在targetArr[i]中，可将前面的值填入 */
				targetArr[j] = targetArr[i];
				j--;
			}
		}
		/* 此时i==j */
		targetArr[i] = key;
		/* 递归调用，把key前面的完成排序 */
		this.quickSort(targetArr, start, i - 1);
 		/* 递归调用，把key后面的完成排序 */
		this.quickSort(targetArr, j + 1, end);

	}
	
	private static void swap(Integer[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * 选择排序
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
		print(a,"初始值");
		System.out.println("正确值:[4, 5, 12, 13, 15, 17, 18, 23, 25, 27, 34, 35, 38, 49, 51, 53, 54, 56, 62, 64, 65, 76, 78, 97, 98, 99]");
		//insertSort(a);
		//binInsertSort(a);
		//shellSort2(a);
		//bubbleSort(a);
		//quickSort(a,0,a.length-1);
		selectSort(a);
		print(a,"算法值");
	}
	
	private static void print(Integer[] a,String message) {
		List<Integer> l = Arrays.asList(a);
		System.out.println(message+":"+l);
		 
	}
}
