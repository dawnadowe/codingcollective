/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5T4;

/**
 *
 * @author Acer
 */
public class T4Q3 {
    
//Write the statements that display the first ten values of the Fibonacci sequence. 
//Given the formula f1 = 1, f2 =1, fn = fn-1 + fn-2. 

    public static void main(String[] args) {
        
//        int a = 1;
//        int b = 0;
//        int c;
//        System.out.print(" " + a + " ");
//        for (int n = 0; n < 9; n++){
//            c = a + b; 
//            b = a; 
//            a = c; 
//            System.out.print(" " + a + " ");
//        }

        int f1 = 1, f2 = 1;
        System.out.println("The first 10 values of the Fibonacci sequence are:");

        System.out.print(f1 + ", " + f2);

        for (int i = 3; i <= 10; i++) {
            int fn = f1 + f2;
            System.out.print(", " + fn);
            f1 = f2;
            f2 = fn;
        }
        System.out.println();
            
        
    }


    
}
    

