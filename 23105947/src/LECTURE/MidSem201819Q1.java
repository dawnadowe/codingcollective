/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LECTURE;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class MidSem201819Q1 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter the number of staff [N]");
        int n = sc.nextInt();
        int weekend = 0;
        int[] staffID = new int[n];
        for (int i = 0; i < n ; i++){
            staffID[i] = rand.nextInt(10000,99999);
            System.out.print("Staff ID: "+ staffID[i]);
            String temp = String.valueOf(staffID[i]);
            if (Character.getNumericValue(temp.charAt(1)) %2 !=0 && Character.getNumericValue(temp.charAt(3)) %2 == 0){
                System.out.println("\nWeekend Duty");
                weekend += 1;
            }
            else {
                System.out.println("\nWeekend Off");
            }
        }
        
        System.out.printf("The number of staffs work during weekend is " + weekend);
        
        
    }
    
}
