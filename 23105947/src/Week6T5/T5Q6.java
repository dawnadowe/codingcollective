/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week6T5;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class T5Q6 {
    
//Write the statements that generate 1 random integer within 0 – 255. Convert the
//number to binary and store the bit into an 8 bit array. Then, display the binary
//number.
    
    public static void main(String[] args) {
        
        Random rand = new Random();
        int num = rand.nextInt(256);
        System.out.println("Random integer withint 0-255: "+ num);
        
        int[] binary = new int[8]; 
        for (int i = 7; i>=0; i--){
            binary[i] = num % 2;
            num = num/2;
        }
        
        System.out.print("Binary representation: ");
        
        for(int i = 0; i<binary.length; i++){
            System.out.print(binary[i]);
        }
    }
    
}
