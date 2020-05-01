package com.practice;


/**
 * 
 * @author ajinkyab
 *
 *
 *A flock of  birds is flying across the continent. Each bird has a type, and the different types are designated by the ID numbers , , , , and .

Given an array of  integers where each integer describes the type of a bird in the flock, find and print the type number of the most common bird. If two or more types of birds are equally common, choose the type with the smallest ID number.

 Input Format

The first line contains an integer denoting  (the number of birds). 
The second line contains  space-separated integers describing the respective type numbers of each bird in the flock.

Constraints

It is guaranteed that each type is , , , , or .
Output Format

Print the type number of the most common bird; if two or more types of birds are equally common, choose the type with the smallest ID number.

Sample Input 0

6
1 4 4 4 5 3
Sample Output 0

4
Explanation 0

The different types of birds occur in the following frequencies:

Type :  bird
Type :  birds
Type :  bird
Type :  birds
Type :  bird
The type number that occurs at the highest frequency is type , so we print  as our answer.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        Map<Integer,Integer> birdTypeMap = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < ar.length ; i++)
        {
            if(birdTypeMap.containsKey(ar[i]))
            {
                int frequency = birdTypeMap.get(ar[i]);
                frequency += 1;
                birdTypeMap.put(ar[i],frequency);
            }
            else
                birdTypeMap.put(ar[i],1);
        }
        System.out.println("Map Size:" + birdTypeMap.size());

        int maxKey=0;
        int maxVal = 0;
        for(Map.Entry<Integer,Integer> entry : birdTypeMap.entrySet())
        {
        	//System.out.println("Current Max:" + max);
        	 System.out.println("Map, Key: " +  entry.getKey() + " , Value: " + entry.getValue());
            if(entry.getValue() > maxVal)
            {	
            	maxKey = entry.getKey();
            	maxVal = entry.getValue();
            }
        }
        
        return maxKey;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("migratoryBird.txt"));
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        System.out.println("Array Size:" + ar.length);
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
