/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week4L3;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class L3Q4 {
    
//Write a simple two players dice game. Each player will roll the dice twice and the
//player with the highest score wins the game. 
    
    public static void main(String[] args) {
        
        Random rand = new Random();
        System.out.print("Player 1: ");
        int player1a = rand.nextInt(1,6);
        int player1b = rand.nextInt(1,6);
        System.out.println(player1a + "," + player1b);
        
        int total1 = player1a + player1b;
        
        System.out.print("Player 2: ");
        int player2a = rand.nextInt(1,6);
        int player2b = rand.nextInt(1,6);
        System.out.println(player2a + "," + player2b);
        
        int total2 = player2a + player2b;
        
        System.out.println("Total for player 1: " + total1);
        System.out.println("Total for player 2: " + total2);
        
        if (total1 > total2)
            System.out.println("Player 1 wins");
        else
            System.out.println("Player 2 wins");
    }
    }
    

