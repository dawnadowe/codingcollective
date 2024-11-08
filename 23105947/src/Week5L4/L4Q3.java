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
public class L4Q3 {
    
//Write a program that calculates the minimum, maximum, average and standard
//deviation (s) of the exam score in a subject. The program will accepts the score and
//quit if negative score is enter. A sample output is given below.
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int score = 0;
        
        System.out.print("Enter a score [negative score to quit]: ");
        score = sc.nextInt();
        int sum = score;
        int min = score;
        int max = score;
        int n = 1;
        double avg;
        int x2 = score * score;
        
        if (score >=0){
            do{
                System.out.print("Enter a score [negative score to quit]: ");
                score = sc.nextInt();
                if (score >=0){
                    sum += score;               
                    n++;}
                
                x2 += (score * score) ;
                
                int temp = score;
                if (temp <= min && temp >= 0)
                    min = temp;

                if (temp >= max && temp >= 0)
                    max = temp;
                
            }
            while (score > 0);
        }
        
        else
            return;
        
        
        avg = (double) sum / n;
        double var = (x2 - (Math.pow(sum,2))/n)/(n-1);
        double std = Math.sqrt(var);
        
        System.out.println(sum);
        System.out.println("Minimum score: " + min);
        System.out.println("Maximum score: " + max);
        System.out.printf("Average score: %.2f" , avg);
        System.out.printf("\nStandard deviation: %.2f", std);
        
       
    }
    
}
