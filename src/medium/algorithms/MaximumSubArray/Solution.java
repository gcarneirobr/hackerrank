package medium.algorithms.MaximumSubArray;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static int[] maxCrossingSubArray(int[] arr, int low, int mid, int high) {

		int maxSumLeft = Integer.MIN_VALUE;
		int highLeft = mid;

		int sum = 0;

		for (int i = mid; i >= low; i--) {
			sum += arr[i];
			if (maxSumLeft < sum) {
				maxSumLeft = sum;
				highLeft = i;
			}
		}

		sum = 0;

		int maxSumRight = Integer.MIN_VALUE;
		int highRight = mid+1;

		for (int i = mid+1; i <= high; i++) {
			sum += arr[i];
			if (maxSumRight < sum) {
				maxSumRight = sum;
				highRight = i;
			}
		}

		int[] result = {highLeft, highRight, maxSumLeft+maxSumRight};

		return result;

	}

	static int[] maxSubArray(int[] arr, int low, int high) {

	    if (low == high) {
	        int[] result = {low, high, arr[low]};
	        return result;
        }


        int[] maxLeft = maxSubArray(arr, low, (low+high)/2);
	    int[] maxRight = maxSubArray(arr, ((low+high)/2)+1, high);
        int[] maxCrossing = maxCrossingSubArray(arr, low, (low+high)/2, high);

        
        if ((maxLeft[2] > maxCrossing[2]) && (maxLeft[2] > maxRight[2])) {
        	return maxLeft;
        } else if ((maxRight[2] > maxCrossing[2]) && (maxRight[2] > maxCrossing[2])) {
        	return maxRight;
        } else return maxCrossing;

	}

	static int maxNonConsecutiveArray(int[] arr) {
		int sum = 0;
		
		for (int i : arr) {
			if (i > 0) {
				sum += i;
			}
		}

		if (sum == 0) {
			int higher = Integer.MIN_VALUE;
			
			for (int i : arr) {
				if (i > higher) {
					higher = i;
				}
			}
			
			sum = higher;
		}
		
		return sum;
	}
	
    static int[] maxSubarray(int[] arr) {
       
    	int[] maxSub = maxSubArray(arr, 0, arr.length-1);
    	int[] result = {maxSub[2], maxNonConsecutiveArray(arr)} ;
    	
    	return result;
   }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = maxSubarray(arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}