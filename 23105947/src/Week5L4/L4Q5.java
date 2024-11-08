/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5L4;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class L4Q5 {
    
//Write a simple two players dice game. Each player will take turns to roll a dice. The
//first players that reach more than 100 points win the game. If the player rolls a 6, the
//player will score 6 points and has the chance to roll again.
    
    public static void main(String[] args) {
        
        Random rand = new Random();
        int sum1 = 0; int sum2 = 0;
        int play1 = 0; int play2 = 0;
        
        do {
            do {    
                System.out.print("Player 1: ");
                play1 = rand.nextInt(1,7);
                System.out.println(play1);
                sum1 += play1;
                }
                while (play1==6 && sum1 <100);
                


            do {

                System.out.print("Player 2: ");
                play2 = rand.nextInt(1,7);  
                System.out.println(play2);
                sum2 += play2;
                }
            while (play2==6 && sum2 <100);
        }
        while (sum1 <100&& sum2<100);
        
        System.out.println(sum1);
        System.out.println(sum2);
        
        if(sum1>sum2)
            System.out.println("Player 1 wins");
        else if (sum2>sum1)
            System.out.println("Player 2 wins");
        else
            System.out.println("Its a tie");
    }}
    
