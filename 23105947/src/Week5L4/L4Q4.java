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
public class L4Q4 {

//Write a program that ask user to enter the year and the first day of the year (0 for
//Sunday, 1 for Monday, … , 6 for Saturday). Display the calendar for May and
//August.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        System.out.print("Enter the first day of the year (0 for Sunday, 1 for Monday, ..., 6 for Saturday): ");
        int firstDay = sc.nextInt();
        int totalDaysBfrMay = 0;
        int totalDaysBfrAug = 0;
        
        //check leap year
        boolean leapyear =  (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
        
        if (leapyear = true){
            totalDaysBfrMay = 121;
            totalDaysBfrAug = 213;  
        }
        else {
            totalDaysBfrMay = 120;
            totalDaysBfrAug = 212; 
        }
        
         //first day of may & aug
         int firstDayMay = (firstDay + totalDaysBfrMay)%7;
         int firstDayAug = (firstDay + totalDaysBfrAug)%7;
         
         // Display calendar for May
        System.out.println("\nCalendar for May:");
        displayMonthCalendar("May", 31, firstDayMay);

        // Display calendar for August
        System.out.println("\nCalendar for August:");
        displayMonthCalendar("August", 31, firstDayAug);
        

    }

    // Method to display the calendar for a specific month
    public static void displayMonthCalendar(String monthName, int numDays, int startDay) {
        System.out.println("         " + monthName);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print initial spaces for the first day of the month
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print days of the month
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0) { // Move to the next line after Saturday
                System.out.println();
            }
        }

        // Print a newline if the last printed day was not a Saturday
        if ((numDays + startDay) % 7 != 0) {
            System.out.println();
        }

         
        
    
    }

}
