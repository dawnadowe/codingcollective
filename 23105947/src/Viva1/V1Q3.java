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

        // TODO code application logic here 

        Scanner sc = new Scanner(System.in); 

        int m=2, sum=0, count=0; 

        long pro=1; 

        long maxvalue = Integer.MAX_VALUE; 

         

        System.out.print("Enter number : "); 

        int num = sc.nextInt(); 

         

        boolean notPrime = false; 

        for(int i=2; i<num; i++){   

            if(num%i == 0) 

                notPrime = true; 

        } 

         

        if(notPrime){ 

            System.out.println("Integer is not a prime number"); 

            System.out.print("The factors of this integer are : "); 

            for(int j=1; j<=num; j++){ 

                if(num%j == 0){ 

                    if(j == num) 

                        System.out.print(j+" "); 

                    else 

                        System.out.print(j+", "); 

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

            System.out.println("Prime number is between 2 and "+num+" : "); 

            while(m <= num ){ 

            boolean isPrime = true; 

            for(int k=2; k<m; k++){ 

                if(m%k == 0){ 

                    isPrime = false; 

                    break; 

                } 

            }  

            if(isPrime){ 

                if(m == 2) 

                    System.out.print(m); 

                else 

                    System.out.print(", "+m);   

            } 

            m++; 

            } 

        }
        
        else{ 

            System.out.println("Integer is a prime number"); 

            System.out.println(num+" is not a perfect number"); 

        }         

        System.out.println();         

    }  
}  
