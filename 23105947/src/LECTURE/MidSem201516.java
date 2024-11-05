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
public class MidSem201516 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int x, y;
        System.out.println("Enter the coordinates X and Y:");
        x = sc.nextInt();
        y = sc.nextInt();
        System.out.println("Enter the move:");
        String moves = sc.next();
        System.out.println("Initial Coordinate: (" + x + "," + y + ")");
        for(char move: moves.toCharArray()){
            switch (move){
                case'L':
                    x -= 1;
                    break;
                case 'R':
                    x += 1;
                    break;
                case 'U':
                    y += 1;
                    break;
                case 'D':
                    y -= 1;
                    break;
                default:
                    System.out.println("Invalid move: " + move);
                    break;
            }
        }
        System.out.println("Final Coordinate: (" + x + "," + y + ")");
        
    }
    
}
