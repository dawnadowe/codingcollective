/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week6T5;

/**
 *
 * @author Acer
 */
public class T5Q5 {
    
//Write the statements that display the string array name sentence in reverse order.
//Each string element must be displayed in reverse order as well.    
    
    public static void main(String[] args) {
        
        String[] sentence = {"hello","it","is","world"};
        for(int i = sentence.length-1; i>=0;i--){
            String word = sentence[i];
            String reversedWord ="";
            
            for(int j = word.length()-1; j>=0; j--){
                reversedWord += word.charAt(j);
            }
            
            System.out.print(reversedWord + " ");
        }
    }
    
}
