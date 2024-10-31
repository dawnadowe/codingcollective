/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

/**
 *
 * @author Acer
 */
public class CountLetter {
    
    public static void main(String[] args) {
        
        //Week2 T1Q8 is another example
        
    String str = "This is a sample string";

        int count = 0;


        // count each characters except spaces


        for(int i=0; i < str.length(); i++) {

            if(str.charAt(i) != ' ')

                count++;

        }

        System.out.println("Length of the String: " + count);

    }

}

