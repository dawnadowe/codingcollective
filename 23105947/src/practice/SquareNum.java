/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

/**
 *
 * @author Acer
 */
public class SquareNum {
    
    //Square number of first n (in this case, 12) integers starting from 1
    
    public static void main(String[] args) {
        
        int n =1;
        for (int i = 0; i < 12; i++){
            int square = n * n;
            n++;
            System.out.print(square + ",");
        }
    }
    
}
