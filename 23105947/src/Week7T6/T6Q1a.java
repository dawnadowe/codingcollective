/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7T6;

/**
 *
 * @author Acer
 */
public class T6Q1a {
    
//  Define a static method that returns the maximum number from 3 integer parameters
    
    public static void main(String[] args) {
        
        int max = findMax(40,60,60);
        System.out.println("The maximum number is: " + max);
    }
    
    public static int findMax (int a, int b, int c){
        int largest = a;
        if (b >= a && b >= c)
            largest = b;
        else if (c >= a && c >= b)
            largest = c;
        return largest;
    }
    
}
