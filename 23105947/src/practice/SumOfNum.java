/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class SumOfNum {
    
        public static void main(String[] args) {
            
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter a number: ");
//        int num = sc.nextInt();
//        int sum = 0;
//        
//        for (int i =1; i <= num; i++){
//            sum += i;
//        }
//        System.out.println(sum);
//        
//    }
        
        int num1 = 1;
        int num2 = 25;
        double sum;
        double total = 0;
        
        for (int i = 1; i <= 25; i++){
            sum = (double) num1/num2;
            total += sum;
            num1++;
            num2--;
        }
            System.out.printf("%.2f",total);
    }
}
