/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week4L3;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class L3Q1 {
    
//Write a program that stimulates a simple calculator. It reads two integers and a
//character. If the character is a +, the sum is printed; if it is a -, the difference is
//printed; if is a *, the multiplication is printed; if it is a /, the quotient is printed; and if
//it is a %, the remainder is printed. (Use the String.charAt(0) to return the character)
    
    public static void main(String[] args) {
        
        int ans;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int a = sc.nextInt();
        System.out.print("Enter second integer: ");
        int b = sc.nextInt();
        System.out.println("Enter the operand:");
        char operand = sc.next().charAt(0);
        if (operand == '+'){
            ans = a + b;
            System.out.println(a + " " + operand + " " +  b + " = " + ans);
        }
        else if (operand == '-'){
            ans = a - b;
            System.out.println(a + " " + operand + " " +  b + " = " + ans);
        }
        else if (operand == '*'){
            ans = a * b;
            System.out.println(a + " " + operand + " " +  b + " = " + ans);
        }
        else if (operand == '/'){
            ans = a / b;
            System.out.println(a + " " + operand + " " +  b + " = " + ans);
        }
        else if (operand == '%'){
            ans = a % b;
            System.out.println(a + " " + operand + " " +  b + " = " + ans);
        }
        else
            System.out.println("Invalid operand");
    
}}
