/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week6T5;

/**
 *
 * @author Acer
 */
public class T5Q1 {
    
 // a.   Declare an array that used to store 12 floating point numbers.
    
//    public static void main(String[] args) {
//        
//        double[] newArray = new double[12];
//    }
    
//b. Initialize an array that used to store the value of A to E.
    
//    public static void main(String[] args) {
//        
//        char[] newArray = {'A','B','C','D','E'};
//    }
    
//c. Declare an array that used to store 100 students name.
    
//    public static void main(String[] args) {
//        
//        String[] studentsName = new String[100];
//    }
    
//d. Declare an array for a table with 6 rows 2 columns that used to store integer value   
    
//    public static void main(String[] args) {
//        
//        int[][] table = new int[6][2]; //row followed by collumn
//    }
    
//e. Initialize an array with the following value:
    
//    public static void main(String[] args) {
//        
//        int[][] value =  {{6,9},{2,5},{4,6}};
        
//f. After initialize the array, modify the value of the above array to

//        value[1][1]=4;
//        value[2][0]=3;
//        value[2][1]=7;
//
//        for (int i = 0; i < value.length; i++){ //loop through rows
//            for (int j = 0; j < value[i].length; j++){ //loop through collums
//                System.out.print(value[i][j] + " "); //print each element
//            }
//            System.out.println(); //move to next row
//        }
//    }
    
//g. Display all the values of an array name contact in separate lines

    public static void main(String[] args) {
        
        String[] name = {"Ali", "Abu", "Aminah"};
        
        for (int i = 0; i< name.length; i++){
            System.out.println(name[i]);
    }
    }
    
}
