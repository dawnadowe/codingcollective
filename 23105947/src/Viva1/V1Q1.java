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
public class V1Q1 {
    
    public static void main(String[] args) {
        
        boolean NegativeNum = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        int num = sc.nextInt();
        int sum = num;
        int largest= num;
        int secondLargest = Integer.MIN_VALUE;
        int count = 1;
        int count2 = 0;

        
        if (num<0){
                NegativeNum = true;}
        
        while (num != 0){
            num = sc.nextInt();
            sum += num;
            
            if(num>largest){
                secondLargest = largest;
                count2 = count;
                largest = num;
                count = 1;
            }
            
            else if (num == largest){
                count++;
            } 
            else if (num > secondLargest){
                secondLargest = num;
                count2 = 1;
            }
            else if (num == secondLargest){
                count2++;
            }
            
            if (num<0){
                NegativeNum = true;
            }


        }
        
        
        System.out.println("The largest number is " + largest);
        System.out.println("The occurence count of the largest number is " + count);
        System.out.println("The second largest number is " + secondLargest);
        System.out.println("The occurence count of the second largest number is " + count2);
        System.out.println("The total sum of all numbers is " + sum);
        if (NegativeNum == true)
            System.out.println("Negative numbers were entered.");
        
    }
    
}
