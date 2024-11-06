/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week4T3;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class T3Q5 {
    
    //5.Write the java statements that determine whether the Leap year. A Leap year is divisible by 4 but not by 100. 
    //  However, a Leap year is also divisible by 400
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year (eg. 2024) : ");
        int year = sc.nextInt();
        if (year % 4 == 0 || year % 400 == 0 && year % 100 != 0){
            System.out.println("It is a leap year");
        }
        else
            System.out.println("It is not a leap year");
    }
    
}
