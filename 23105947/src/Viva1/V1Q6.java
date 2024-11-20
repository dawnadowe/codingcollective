/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viva1;

import java.util.Scanner;


public class V1Q6 {
    
    public static void main(String[] args) {
        
        boolean NegativeNum = false; 
        
        //user input for the first score to initialize for the largest value
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        int num = sc.nextInt();
        
        int sum = num;
        int largest= num;
        int secondLargest = 0;
        int count = 1;              //occurence for largest
        int count2 = 0;             //occurence for second largest

        //to know if user entered a negative number for summary purposes
        if (num<0){
                NegativeNum = true;}
        
        //loop for the remaining scores
        do{
            num = sc.nextInt();
            sum += num;
            
            //if new input is more than current largest number
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
        while (num != 0);

        System.out.println("The largest number is " + largest);
        System.out.println("The occurence count of the largest number is " + count);
        if (secondLargest ==0){
            System.out.println("There is no second largest number");
        }
        else {
        System.out.println("The second largest number is " + secondLargest);
        System.out.println("The occurence count of the second largest number is " + count2);
        }
        System.out.println("The total sum of all numbers is " + sum);
        if (NegativeNum == true)
            System.out.println("Negative numbers were entered.");
        else
            System.out.println("No negative numbers were entered.");
        
    } 
}
