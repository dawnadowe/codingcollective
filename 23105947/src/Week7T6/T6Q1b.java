/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7T6;

/**
 *
 * @author Acer
 */
public class T6Q1b {
    
//Define a static method that that determine whether the given integer is a
//square number.
    
    public static void main(String[] args) {
        
        System.out.println("26 is a square number: " + squareNum(26));
    }
    
    public static boolean squareNum (int a){
        
        int square = (int) Math.sqrt(a);
        if (square * square == a){
            return true;
        }
        else 
            return false;
        
    }
    
}
