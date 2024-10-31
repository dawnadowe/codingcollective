/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;
import java.util.*;

/**
 *
 * @author Acer
 */
public class SortDescend {
    
    public static void main(String[] args)
    {
        // Initializing the array
        int a[] = { 1, 2, 3, 4, 5 };

        // Sorting the array in ascending order
        Arrays.sort(a);

        // Reversing the array
        reverse(a);

        // Printing the elements
        System.out.println(Arrays.toString(a));
    }

    public static void reverse(int[] a)
    {
        // Length of the array
        int n = a.length;

        // Swapping the first half elements 
        // With last Half Elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int t = a[i];

            // Assigning the first half
              // to the last half
            a[i] = a[n - i - 1];

            // Assigning the last half
            // to the first half
            a[n - i - 1] = t;
        }
    }
}
    

