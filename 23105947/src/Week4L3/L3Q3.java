/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week4L3;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class L3Q3 {
    
//Write a program that calculates the total commission receives based on the table
//below. The program will accept the sales volume and calculate the commission.
//Display the commission in two decimal places.
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sales: ");
        int sales = sc.nextInt();
        double comm, percentage = 0;
        
        if (sales <= 100)
            percentage = 0.05;
        else if (sales > 100 && sales <= 500)
            percentage = 0.075;
        else if (sales > 500 && sales <= 1000)
            percentage = 0.1;
        else if (sales > 1000)
            percentage = 0.125;
        
        
        comm = sales * percentage;
        System.out.printf("Total commision: %.2f" , comm);
    }

    
}
