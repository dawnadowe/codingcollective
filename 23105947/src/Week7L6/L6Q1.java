/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7L6;

/**
 *
 * @author Acer
 */
public class L6Q1 {
    
//Write a Java method that returns a triangular number. A triangular number is defined
//as 1+2+3+…+ n. Then, write a Java program to use the method to display the first 20
//triangular numbers
    
    public static void main(String[] args) {
        
        System.out.println(triangularNum());
    }
    
    public static int[] triangularNum(){
        
        int triNum;
        int[] myArray = new int[20];
        for (int i = 0; i< myArray.length; i++){
            for (int j = 1; j <= i +1; j++){
                myArray[i] += j;
            }
            System.out.println(myArray[i]);
        }
        
        return myArray;
    }
    
}
