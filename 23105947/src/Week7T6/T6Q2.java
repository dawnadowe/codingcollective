/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7T6;

/**
 *
 * @author Acer
 */
public class T6Q2 {
    
//Write a program that consists of a method that can display three numbers in
//decreasing order
    
    public static void main(String[] args) {
        
        decreasingOrder();
    }
    
    public static void decreasingOrder (){
        
        int num1 = 11;
        int num2 = 5;
        int num3 = 11;
        int temp;
        
        if (num2 > num1){
            temp = num2;
            num2 = num1;
            num1 = temp;  //num1 = 6, num2 = 2
        }
        if (num3 > num1){
            temp = num3;
            num3 = num1;
            num1 = temp;
        }
        if (num3 > num2){
            temp = num3;
            num3 = num2;
            num2 = temp;
        }
        
        System.out.println(num1 + ", " +  num2 +", " + num3);
        
    }
    
}
