package easy.warmup.PlusMinus;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void plusMinus(int[] arr) {
    	double positive = 0, negative = 0, zero = 0;	
    	
    	for (int i : arr) {
			if (i > 0) {
				positive++;
			} else if (i < 0) {
				negative++;
			} else zero++;
		}
    	
    	System.out.format("%.6f%n", positive / arr.length);
    	System.out.format("%.6f%n", negative/ arr.length);
    	System.out.format("%.6f%n", zero / arr.length);
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
