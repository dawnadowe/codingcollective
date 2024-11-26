/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7L6;
import java.util.Arrays;

/**
 *
 * @author Acer
 */
public class L6Q3 {
    
//Write a Java method that accepts an array of 10 integers. The method should reverse
//the integer in the array. Example, if the number is 1234, the number will change to
//4321. 
    
    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(reverseInt()));
    }
    
    public static int[] reverseInt(){
        
        int[] myArray = {123, 335, 874};
        for (int i = 0; i < myArray.length; i++){
            int num = myArray[i];
            
            String numString = Integer.toString(num);
            String reversedString = "";
            
            for(int j = numString.length()-1; j>=0; j--){
                reversedString += numString.charAt(j);
            }
            
            myArray[i] = Integer.parseInt(reversedString);
        }
        
        return myArray;
    }
    
}
