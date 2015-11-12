package Hashtable;

import java.util.HashSet;
import java.util.Set;

public class FindMissing {
		
		public static Set<Integer> findMissingNumbers(int arr[], int m) {
			
				Set<Integer> set = new HashSet<Integer>();
				// dealing with array that does not start with 1
				for (int i = 1; i < arr[0]; i++) {
					set.add(i);
				}
				// dealing with the middle elements
				findMissingNumbersBetweenToIndexes(arr, set, 0, arr.length - 1);
				// recalculate m for any extra tail's numbers
				m = m - (((arr[arr.length - 1] - arr[0] + 1) - arr.length))
						- (arr[0] - 1);
				// dealing with the any extra tail's numbers
				for (int i = 1; i <= m; i++) {
					set.add(arr[arr.length - 1] + i);
				}

				return set;
			}

			public static void findMissingNumbersBetweenToIndexes(int[] arr,
					Set<Integer> set, int start, int finish) {
				if (arr.length == 1) {
					return;
				}
				if ((arr[finish] - arr[start] + 1) - (finish - start) == 0) {
					return;
				}
				if (start + 1 == finish) {
					for (int i = arr[start] + 1; i < arr[finish]; i++) {
						set.add(i);
					}
					return;
				}
				int middle = (start + finish) / 2;
				// right
				findMissingNumbersBetweenToIndexes(arr, set, start, middle);

				// left
				findMissingNumbersBetweenToIndexes(arr, set, middle, finish);
			}
			public static void main(String[] args) {
				int [] A = {1,2,4,5,6,8};
				System.out.println(findMissingNumbers(A, 8));
			}
}
