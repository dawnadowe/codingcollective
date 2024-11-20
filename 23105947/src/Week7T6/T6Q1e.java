/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7T6;

/**
 *
 * @author Acer
 */
public class T6Q1e {
    
//Define a static method that displays the number of letters and the number of
//digits of a String parameter.
    
    public static void main(String[] args) {
        
        count("i am 21 years old");
    }
    
    public static void count (String a){
        
        int letterCount = 0;
        int digitCount = 0;
        
        for (int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
                letterCount++;
            else if (c >= '0' && c <= '9')
                    digitCount++;
        }
        
        System.out.println("The string \"" + a + "\" has: " + letterCount + " letters and " + digitCount + " digits.");
    }
    
}
