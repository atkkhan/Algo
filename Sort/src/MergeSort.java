import java.util.*;
public class MergeSort {

	private int[] numbers;
	private int[] helper;
	private int number;
	
	public void sort(int[] values){
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergesort(0, number -1);
	}
	
	private void mergesort(int low, int high){
		if(low < high){
			int middle = low + (high - low)/2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
		}
	}
	private void merge(int low, int middle, int high){
		
		for(int i = low; i <= high; i++){
			helper[i] = numbers[i];
		}
		int i = low;
		int j= middle + 1;
		int k = low;
		while(i <= middle && j <= high){
			if(helper[i] <= helper[j]){
				numbers[k] = helper[j];
				i++;
			}
			else {
				numbers[k] = helper[j];
				j++;
			}
			++k;
		}
		while(i <= middle){
			numbers[k] = helper[i];
			k++;
			i++;
		}
	}
	
	/**
	 * @param args
	 */
	
	  private final static int SIZE = 7;
	  private final static int MAX = 20;
	public static void main(String[] args) {
		int[] nums = new int[SIZE];
	    Random generator = new Random();
	    for (int i = 0; i < nums.length; i++) {
	      nums[i] = generator.nextInt(MAX);
	      System.out.println(nums[i] + ",");
	    }
	  
	    MergeSort sorter = new MergeSort();
	    sorter.sort(nums);

	      System.out.println("...");
	    for (int i = 0; i < nums.length - 1; i++) {
	      if (nums[i] > nums[i + 1]) {
	        System.out.println("Should not happen");
	      }
	      System.out.println(nums[i] + ",");
	      
	    }
	}

}
