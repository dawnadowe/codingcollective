/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week4L3;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class L3Q5 {
    
//    Cramer’s rule is used to solve the linear equations
//    ax + by = e, 
//    cx + dy = f; 
//    x = (ed-bf)/(ad-bc) 
//    y=(af-ec)/(ad-bc)
//    Write a program that ask the user to enter a, b, c, d, e, f. and display the result of x
//    and y. If ad – bc is equal to 0. Display "The equation has no solution"
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number for 'a': ");
        int a = sc.nextInt();
        System.out.println("Enter a number for 'b': ");
        int b = sc.nextInt();
        System.out.println("Enter a number for 'c': ");
        int c = sc.nextInt();
        System.out.println("Enter a number for 'd': ");
        int d = sc.nextInt();
        System.out.println("Enter a number for 'e': ");
        int e = sc.nextInt();
        System.out.println("Enter a number for 'f': ");
        int f = sc.nextInt();
        
        int x, y;
        x = ((e * d) - (b * f))/ ((a * d)- (b * c));
        y = ((a * f) - (e * c))/((a * d) - (b * c));
        e = (a * x) + (b * y);
        f = (c * x) + (d * y);
        int check = (a * d)-(b * c);
        
        if (check == 0){
            System.out.println("The equation has no solution");
        }
        else {
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        
        }
    }
    
}
