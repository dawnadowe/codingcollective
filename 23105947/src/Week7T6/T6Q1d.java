/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7T6;

/**
 *
 * @author Acer
 */
public class T6Q1d {
    
//Define a static method that used to determine whether the parameter is a
//pentagonal number. A pentagonal number is a figurate number that extends
//the concept of triangular and square numbers to the pentagon. Pn = (1/2) * n(3n -1)
    
    public static void main(String[] args) {
        
        System.out.println("15 is a pentagonal number: " + pentagonalNum(15));
    }
    
    public static boolean pentagonalNum (int a){
        
        int n = 1;
        int pentagon;
        
        while(true){
            pentagon = (n * (3*n -1))/2;
            if (pentagon == a)
                return true;
            else if (pentagon > a)
                return false;
            
            n++;
        }
    }
}
