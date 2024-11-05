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
public class PracticeMidSem1516Q1 {
    
    public static void main(String[] args) {

//        Q1        
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the coordinate X and Y:");
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        System.out.println("Enter the move:");
//        String moves = sc.next();
//        System.out.println("Initial Coordinate: (" + x + "," + y + ")");
//        
//        for(char move: moves.toCharArray()){
//            switch (move) {
//                case 'L':
//                    x -= 1;
//                    break;
//                case 'R':
//                    x += 1;
//                    break;
//                case 'U':
//                    y += 1;
//                    break;
//                case 'D':
//                    y -= 1;
//                    break;
//                default:
//                    System.out.println("\nInvalid move" + move);
//                    break;
//            }
//            
//    }
//        System.out.println("Final Coordinate (" + x + "," + y + ")");


//      Q2

        Scanner sc = new Scanner(System.in);
        String durianType;
        double total = 0;
        double sales;
        

        
        do {    
                System.out.print("Enter the type of durian [Quit] to terminate: ");
                durianType = sc.nextLine();
                if (durianType.equalsIgnoreCase("Quit"))
                    break;
                
                
                System.out.print("Enter the sales in kg: ");
                sales = sc.nextDouble();
                sc.nextLine();
                if (durianType.equalsIgnoreCase("MK")){
                    total += sales * 25;
                }
                else if (durianType.equalsIgnoreCase("HL")) {
                    total += sales * 22;
                }
                else if (durianType.equalsIgnoreCase("D24")) {
                    total += sales * 20;
                }
                else if (durianType.equalsIgnoreCase("UM")) {
                    total += sales * 18;
                }
        
        }
        
        while (!durianType.equalsIgnoreCase("Quit"));
              System.out.printf("Total Sales: RM%.2f", total);
    }
    
}
