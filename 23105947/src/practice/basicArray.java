/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

/**
 *
 * @author Acer
 */
public class basicArray {
    
    //e. Initialize an array with the following value:
    
    public static void main(String[] args) {
        
        int[][] value =  {{6,9},{2,5},{4,6}};
        
//f. After initialize the array, modify the value of the above array to

        value[1][1]=4;
        value[2][0]=3;
        value[2][1]=7;

        for (int i = 0; i < value.length; i++){ //loop through rows
            for (int j = 0; j < value[i].length; j++){ //loop through collums
                System.out.print(value[i][j] + " "); //print each element
            }
            System.out.println(); //move to next row
        }
    }
    
}
