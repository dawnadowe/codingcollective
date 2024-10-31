/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2;
import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class T1Q8 {
    
    //8. Count the number of alphabet U and M from a sentence entered by user.
    
    public static void main(String[] args) {
        
        System.out.println("Enter a sentence");
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        int countU = 0;
        int countM = 0;


        // count each characters except spaces


        for(int i=0; i < str.length(); i++) {

            if(str.charAt(i) == 'u')

                countU++;
            
            if (str.charAt(i) == 'm')
                countM++;

        }

        System.out.println("Number of alphabet U: " + countU);
        System.out.println("Number of alphabet M: " + countM);

    }

}
    

