/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week4T3;

/**
 *
 * @author Acer
 */
public class T3Q4 {
    
    public static void main(String[] args) {
        
   //   4. Write the java statements that used the if statement to find the biggest number among three given integers. 
   
        int x = 3, y = 6, z = 5;
        int biggest;
        if (x >= y && x >= z)
            biggest = x;
        else if ((y >= x && y >= z))
            biggest = y;
        else
            biggest = z;
        
        System.out.println("The biggest number is " + biggest);
    }
    
}
