package binarySearch;
import java.util.Arrays;
public class BinarySearchExample {

	/**
     * Performs a binary search on a sorted array.
     *
     * @param arr    The sorted array to search in.
     * @param target The value to search for.
     * @return The index of the target if found, otherwise -1.
     */
	
	
	int binarySearch(int[] arr,int target) {
		int left=0;
		int right=arr.length-1;
		
		while(left<=right) {
			// Find the middle point
            // Using (left + right) / 2 can cause integer overflow for very large arrays
            // This is the safer way:
			int mid=left+(right-left)/2;
			
			// Check if target is present at mid
			if(arr[mid]==target) {
				return mid;//Traget found
			}
			// If target is smaller, ignore the right half
			if(arr[mid]>target) {
				right=mid-1;
			}
			// If target is larger, ignore the left half
			else {
				//arr[mid]<target
				left=mid+1;
			}
		}
		// If we reach here, the target was not in the array
		return -1;
	}
	// Main method to test the algorithm
	public static void main(String[] args) {
		BinarySearchExample bs=new BinarySearchExample();
		
		// IMPORTANT: The array MUST be sorted
		int []arr= {2,5,7,8,11,12,30};
		
		System.out.println("Array"+Arrays.toString(arr));
		
		// --- Test Case 1: Target found ---
		int target1=11;
		int result=bs.binarySearch(arr, target1);
		
		if(result ==-1) {
			System.out.println("Target"+target1+"Not found");
		}else {
			System.out.println("Target"+target1+"Found at index"+result);
		}
		
		// --- Test Case 2: Target not found ---
		int target2=6;
		int result2=bs.binarySearch(arr, target2);
		
		if(result2 == -1) {
			System.out.println("Target"+target2+"Not found");
		}else {
			System.out.println("Target"+target2+"Found at index"+result2 );
		}
	}
}
