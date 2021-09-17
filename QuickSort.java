/**
*	Assignment: Bonus Assignment
*	Professor: Ken Nguyen
*	Course: Data Structures & Algorithms
*	Goal: To develop a non-recursive quick-sort
*	algorithm
*/

import java.util.*;
import java.lang.reflect.*;

public class QuickSort {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your array(Enter numbers with no spaces" +
						   " between and only a comma separating them): ");
		String input = keyboard.nextLine();
		String[] arr = input.split(",");
		int[] nums = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			nums[i] = Integer.parseInt(arr[i]);
		}
		
		quicksort(nums);
		
		for(int a: nums) {
			System.out.print(a + ",");
		}
	}
	
	/**
	*	Divide and Conquer or splitting
	* 	up the list in 3 parts
	*/
	public static int[] quicksort(int[] arr) {
		int num = (int)Array.get(arr, arr.length-1);
		int l = 0;
		int e = 0;
		int g = 0;
		
		/**
		*	Checking how many are equal to
		* 	less than and greater than for size
		*/
		for(int i = 0; i < arr.length; i++) {
			if ((int)Array.get(arr, i) < num)
				l++;
		}
		for(int i = 0; i < arr.length; i++) {
			if ((int)Array.get(arr, i) == num)
				e++;
		}
		for(int i = 0; i < arr.length; i++) {
			if ((int)Array.get(arr, i) > num)
				g++;
		}
		
		int[] L = new int[l];
		int[] E = new int[e];
		int[] G = new int[g];
		
		int j = 0;
		int k = 0;
		int m = 0;
		
		/**
		*	Filling array with the variables
		* 	that are less than, greater than,
		* 	and equal to with appropritate size
		*/
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] < num) {
				j++;
				L[j-1] = arr[i];
			}
			else 
				continue;
		}
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				k++;
				E[k-1] = arr[i];
			}
			else 
				continue;
		}
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > num) {
				m++;
				G[m-1] = arr[i];
			}
			else 
				continue;
		}
		
		selectionSort(L);
		selectionSort(E);
		selectionSort(G);
		
		int x = 0;
		int y = 0;
		int z = 0;
		
		/**
		* 	Filling original array with now
		*	sorted array equivalent
		*/
		for(int i = 0; i < L.length; i++) {
			x++;
			arr[i] = L[x-1];
		}
		for(int i = 0; i < E.length; i++) {
			y++;
			arr[i+l] = E[y-1];
		}
		for(int i = 0; i < G.length; i++) {
			z++;
			arr[i+l+e] = G[z-1];
		}
		return arr;
	}
	
	/**
	*	Actual method for sorting
	*/
	public static int[] selectionSort(int[] arr) {
		int startScan, i, minIndex, minValue;
		
		for(startScan = 0; startScan < (arr.length-1); startScan++) {
			minIndex = startScan;
			minValue = arr[startScan];
			for(i = startScan + 1; i < arr.length; i++) {
				if (arr[i] < minValue) {
					minValue = arr[i];
					minIndex = i;
				}
			}
			arr[minIndex] = arr[startScan];
			arr[startScan] = minValue;
		}
		return arr;
	}
}