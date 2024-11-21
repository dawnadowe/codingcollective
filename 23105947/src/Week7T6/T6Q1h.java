/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7T6;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class T6Q1h {
    
//Define a static method that generate random number within 0 – 10. The
//method will return the first random number that generate twice. 
    
    public static void main(String[] args) {
       
        System.out.println("The first number that generated twice is: " + generateNum());
    }
    
    public static int generateNum (){
        
        Random rand = new Random();
        int[] occurences = new int[11];
        while(true){
            int num = rand.nextInt(11);
            occurences[num]++ ;
            if (occurences[num]==2)
                return num;
        }  
            
        }
        
        
    }
    

