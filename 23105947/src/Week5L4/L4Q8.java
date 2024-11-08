/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5L4;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class L4Q8 {
    
//Write a program that generates the first n prime number. n is an random integer
//within 0 to 100.
    
    public static void main(String[] args) {
        
        Random rand = new Random();
        int n = rand.nextInt(101);
        System.out.println(n);
        
        int count = 0;
        int prime = 2;
        
        while (count<n){
            boolean isPrime = true;
            for(int i=2; i<= Math.sqrt(prime); i++){
                if(prime % i ==0){
                    isPrime = false;
                    break;}

                }
            if (isPrime) {
                System.out.println(prime);
                count++;
            }
            
            prime++;
                
            
                
            }
        
        

        
    }}