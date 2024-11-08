/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5L4;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class L4Q7 {
    
//Write a program that used to calculate mortgage loan. The program will create the
//amortization table with equal total payment plan. The following are the formula and
//the sample output.
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter principal amount: ");
        double P = sc.nextDouble();
        System.out.print("Enter interest in %: ");
        double i = sc.nextDouble();
        System.out.print("Enter total number of month(s): ");
        int N = sc.nextInt();
        
        double temp = (i/1200);
        double temp2 = Math.pow(1 + temp,-N);
        double M = (P * temp)/(1-temp2);
        double totalInt = 0;
        
        System.out.println("Month  Monthly Payment   Principal    Interest    Unpaid Balance     Total Interest");
        
        for (int n=1; n<=N; n++){
        
                double Cn = M * Math.pow(1 + temp, -(1+N-n));
                double Ln = M - Cn;
                double Rn = Ln / (temp -Cn);
                
                P -= Cn;
                totalInt += Ln;
                
                System.out.printf("%-15d%-13.2f%-13.2f%-16.2f%-21.2f%-15.2f%n",n,M,Cn,Ln,P,totalInt);
                
        }
        
        
        
        
    }
    
}
