/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7T6;

/**
 *
 * @author Acer
 */
public class T6Q1g {
    
//Define a static void method that returns the area and the circumference of a
//circle given the argument is radius. Area = πr2
//and Circumference = 2 πr.
    
    public static void main(String[] args) {
        
        calcAreaCirc(5);
        
    }
    
    public static void calcAreaCirc (int radius){
        
        double circ = Math.PI * (2 * (double)radius);
        double area = Math.PI * Math.pow(radius, 2);
        System.out.printf("The circumference of the circle of radius = %d is: %.2f" , radius , circ);
        System.out.printf("\nThe area of the circle of radius = %d is: %.2f" , radius , area);
    }
    
}
