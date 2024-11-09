/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class reverseString {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String sentence = sc.nextLine();
        String reverse = "";
        
        for (int i = sentence.length()-1; i>=0;  i--){
            reverse += sentence.charAt(i);
            
        }
        System.out.print(reverse); // have to print outside of loop
    }
    
}
