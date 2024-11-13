/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viva1;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class V1Q3 {
    
    public static void main(String[] args) { 

     Scanner sc = new Scanner(System.in); 
       int m=3, sum=1, count=1; 
         long pro=1; 
         long maxvalue = Integer.MAX_VALUE; 

         System.out.print("Enter number : "); 
         int num = sc.nextInt(); 
         boolean notPrime = false; 

        for(int i=2; i<=num/2; i++){ 
             if(num%i == 0) 
                 notPrime = true; 
         } 

         if(notPrime){ 

             System.out.println("Integer is not a prime number"); 
             System.out.print("The factors of this integer are : \n1"); 

             for(int j=2; j<=num; j++){
                 
                 if(num%j == 0){ 
                     System.out.print(", " + j); 
                     count++; 
                     sum += j; 
                     pro *= j; 
                 }  
             } 

             System.out.println("\nIt has "+count+" factors"); 
             System.out.println("The sum of the factors is "+sum); 

             if(pro > maxvalue) 
                 System.out.println("The product of the factor is too large to display"); 

             else 
                 System.out.println("The product of the factors is "+pro); 

             if(sum == num) 
                 System.out.println(num+" is a perfect number"); 

             else 
                 System.out.println(num+" is not a perfect number"); 
         }
         
         else{ 
             System.out.println("Integer is a prime number"); 
         } 
 
         System.out.print("Prime number is between 2 and "+num+" : \n2"); 

         while(m <= num ){ 

             boolean isPrime = true; 

             for(int k=2; k<=m/2; k++){ 

                 if(m%k == 0){ 
                     isPrime = false; 
                     break; 
                 } 
             }  

             if(isPrime){ 
                 System.out.print(", " + m); 
             } 
             m++; 
         }                           
     } 
}
