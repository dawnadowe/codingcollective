/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5T4;

/**
 *
 * @author Acer
 */
public class T4Q4 {
    
//Write the statements that display the string in reverse order. (use String.length() 
//to get the length of the string)
    
    public static void main(String[] args) {
        
        String word = "hi bye", reverse = "";
        System.out.println(word);
        for (int i = word.length()-1; i >= 0; i--){
            reverse += word.charAt(i);
            
        }
        System.out.println(reverse);
    }
    
}
