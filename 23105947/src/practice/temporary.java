/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

/**
 *
 * @author Acer
 */
public class temporary {
    
    public static void main(String[] args) {
        
        int f1 = 1;
        int f2 = 1;
        int fn;
        
        System.out.print("The first 10 values of fibonacci sequence are: " + f1 + ", " + f2);
        for (int i = 3; i <= 10; i++){
            fn = f2 + f1;
            System.out.print(", " + fn);
            f1 = f2;
            f2 = fn;
        }

        
    }
    
}
