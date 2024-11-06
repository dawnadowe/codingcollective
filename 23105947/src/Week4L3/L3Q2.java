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
public class L3Q2 {
    
//     Generate a random integer within 0 to 5 and display the integer in word
    
    public static void main(String[] args) {
        
        String word = " ";
        Random rand = new Random();
        int integer = rand.nextInt(0,5);
        switch(integer){
            case 0:
                word = "Zero";
                break;
            case 1:
                word = "One";
                break;
            case 2:
                word ="Two";
                break;
            case 3:
                word = "Three";
                break;
            case 4:
                word ="Four";
                break;
            case 5:
                word ="Five";
                break;

        }
        
        System.out.println(integer + " is " + word);
        
    }
    
}
