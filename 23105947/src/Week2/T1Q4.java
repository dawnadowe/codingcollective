/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class T1Q4 {
    
    public static void main(String[] args) {
        
        //Print the results of the two players’ dice game.
        
        Random rand = new Random();
        int player1 = rand.nextInt(6) + 1;
        System.out.print("Player 1: " + player1);
        int player2 = rand.nextInt(6) + 1;
        System.out.print("\nPlayer 2: " + player2);
        
        if (player1>player2) {System.out.println("\nPlayer 1 wins");}
        
        else if (player1<player2) {System.out.println("\nPlayer 2 wins");}
        
        else {System.out.println("\nIts a tie");}
        }
        
        
    }
    

