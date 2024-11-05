/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LECTURE;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class MidSem201516Q2 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String durianType;
        double sales;
        double total = 0.0;
        
        do {
            System.out.println("Enter the type of durian [Quit] to terminate: ");
            durianType = sc.nextLine();
            if (durianType.equalsIgnoreCase("Quit"))
                break;
            System.out.print("Enter the sales in kg: ");
            sales = sc.nextDouble();
            sc.nextLine();
            if (durianType.equals("MK")){
                total += sales * 25;
            }
            
            else if (durianType.equals("HL")) {
                total += sales * 22;
            }
            else if (durianType.equals("D24")) {
                total += sales * 20;
            }
            else if (durianType.equals("UM")) {
                total += sales * 18;
            }
        
    
        } while (!durianType.equalsIgnoreCase("Quit"));
            System.out.printf("Total Sales: RM %.2f", total);
        
    }}

