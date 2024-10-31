/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2;
import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class T1Q5 {
    
    public static void main(String[] args) {
        
        //Print the perimeter of a rectangle.
        
        double length, width, peri;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length");
        length = sc.nextDouble();
        System.out.println("Enter the width");
        width = sc.nextDouble();
        
        peri = (2 * length) + (2 * width);
        System.out.printf("The perimeter is: %.2f", peri);
        
    }
    
}
