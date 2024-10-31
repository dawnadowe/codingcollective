/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2;
import java.util.Random;
import java.util.*;

/**
 *
 * @author Acer
 */
public class T1Q11 {
    
    //11. Display a list of 5 random numbers in descending order. (Sort)
    
    public static void main(String[] args) {  
    
        int n = 5;
        int[] randArray = new int[n];
        Random rand = new Random();
        for (int i=0; i < n; i++)
            {randArray[i] = rand.nextInt(100);}
        
        Arrays.sort(randArray);
        
        reverse(randArray);
        
        System.out.println(Arrays.toString(randArray));
    } 
        public static void reverse(int[] randArray){
            
            int n = randArray.length;
            for (int i = 0; i < n/2; i++){
                int temp = randArray[i];
                randArray[i]= randArray[n-i-1];
                randArray[n-i-1] = temp;
            }
                
        }
    
    
}
