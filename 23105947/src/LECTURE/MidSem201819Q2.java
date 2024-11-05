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
public class MidSem201819Q2 {
    
    public static void main(String[] args) {
        
        int num;
        int factor;
        boolean answer;
        int score = 0;
        int total = 0;
        
        Scanner sc = new Scanner(System.in);
        do {System.out.println("Enter a number (-1)");
            num = sc.nextInt();
            if (num == -1)
                break;
            System.out.println("Enter a factor: ");
            factor = sc.nextInt();
            System.out.println(factor + " is a factor of " + num + "? (true/false): ");
            answer = sc.nextBoolean();
            total ++;
            if (num % factor == 0){
                if (answer == true){System.out.println("Your answer is correct.");
                score ++;}
                else {System.out.println("Your answer is incorrect.");
                        }}
            else {
                if (answer == false){System.out.println("Your answer is correct.");
                score ++;}
                else {System.out.println("Your answer is incorrect.");
                }
            }
    }
        while (num != -1);
            System.out.println("The final score is " + score + "/" + total);
        }
    
}
