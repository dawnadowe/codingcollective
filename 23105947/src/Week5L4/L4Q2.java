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
public class L4Q2 {
    
//Write a program that accepts an integer n from user and then sum the following series
//1 + (1+2) + (1+2+3) + … + (1+2+3+…+n)
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++){
            System.out.print("(");
            
            for(int j = 1; j <= i; j++){
                System.out.print(j);
                if(j < i){
                    System.out.print("+");
                }
                else System.out.print(")");
            }
            
           if (n>1) System.out.print("+");
        }


    }
}
