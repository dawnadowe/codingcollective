/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5L4;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class L4Q1 {
    
//Write a program that accepts an integer from user. Then, display its entire factors in
//increasing order.
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        System.out.print("The factors of " + num + " are ");
        for (int i= num; i>0; i--){
            int calc = num % i;
            if (calc == 0){
                int factor = i;
                System.out.print(factor + ", ");
            }
        }
    }
    
}
