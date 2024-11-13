/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viva1;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class V1Q5 {
    
    public static void main(String[] args) { 

        Scanner input = new Scanner(System.in); 
        String remix = input.nextLine(); 

        // Initialize an empty string to store the original song and word 
        String oriSong = ""; 
        String word = "";  

        // Iterate through the remix string 
        for (int i = 0; i < remix.length(); i++) { 

            // Check if we have encountered "REMIX" 
            if (i + 4 < remix.length() && remix.substring(i, i + 5).equals("REMIX")) { 

                // If a word is stored in word, add it to the original song 
                if (!word.isEmpty()) { 

                    // Add space if this is not the first word 
                    if (!oriSong.isEmpty()) { 
                        oriSong += " "; 
                    } 

                    oriSong += word; 
                    word = ""; // Clear word for the next one 
                } 

                // Skip the next 4 characters (the rest of "REMIX") 
                i += 4; 

            } else { 
                // If not "REMIX" add character to word 
                word += remix.charAt(i); 
            } 
        } 
  
        // Add the last word if any remaining 
        if (!word.isEmpty()) { 
            if (!oriSong.isEmpty()) { 
                oriSong += " "; 
            } 
            oriSong += word; 
        } 

        System.out.println("Input: "+remix+"\nOutput: "+oriSong); 

        input.close(); 
    } 
}
