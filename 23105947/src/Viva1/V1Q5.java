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

        String remix; 

         

        // Loop until valid input is provided 

        while (true) { 

            System.out.print("Enter the remix string: "); 

            remix = input.nextLine(); 

            remix = remix.toUpperCase(); 

             

            // Check for empty input 

            if (remix == null || remix.trim().isEmpty()) { 

                System.out.println("Error: Input cannot be empty. Please enter a valid string."); 

                continue;  // Ask for input again 

            } 

if (remix.length()>200){ 

                System.out.println("Error: Input can't be more than 200 characters");  

                continue;  // Ask for input again  

            } 

 

            // check if the input contains only uppercase letters and "REMIX" 

            if (!remix.matches("[A-Z]+")) { 

                System.out.println("Error: Input contains invalid characters. Only uppercase English letters are allowed."); 

                continue;  // Ask for input again 

            } 

            break;  // Exit the loop  

        }         

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
