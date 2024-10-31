/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3L2;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class L2Q4 {
    
    //Write a program that converts the seconds to hours, minutes and seconds.
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter time in seconds");
        int time = sc.nextInt();
        
        int h = time/3600;
        int m = (time - (h * 3600))/60;
        int s = (time - (h * 3600) - (m * 60));
        
        System.out.println(time +" seconds is " + h + " hours " + m + " minutes " + s + " seconds ");
    }

    
}
