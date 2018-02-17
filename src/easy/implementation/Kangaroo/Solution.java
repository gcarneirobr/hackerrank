package easy.implementation.Kangaroo;

import java.text.*;
import java.math.*;

import java.util.Scanner;

public class Solution {

    static String kangaroo(int x1, int v1, int x2, int v2) {

        int initialDifference = x2 - x1;
        int velocityDifference = v2 - v1;
        
        if (initialDifference >= 0 && velocityDifference >= 0) 
            return "NO";
        
        if (initialDifference <= 0 && velocityDifference <= 0) 
            return "NO";
        
        int positionDifference = initialDifference;
        
        if (initialDifference > 0) {
	        while (!(positionDifference <= 0)) {
	            positionDifference += velocityDifference;
	        }
        } else 
        while (!(positionDifference >= 0 )){
            positionDifference += velocityDifference;
        }
            
        if (positionDifference == 0) {
            return "YES";
        } else return "NO";
       
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        in.close();
        System.out.println(result);
    }
}
