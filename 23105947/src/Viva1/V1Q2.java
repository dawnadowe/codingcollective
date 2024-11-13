/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viva1;
import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class V1Q2 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Read input values for n, a, and b        
        System.out.print("Enter n, a, and b: ");
        long n = scanner.nextLong(); // Use long for large numbers up to 10^9        
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        
        if (n < 1 || n > Math.pow(10, 9)){
            System.out.println("n has to be within this range: 1 <= n <= 10^9");
        }
        if (a < 1 || a > n){
            System.out.println("a has to be within this range: 1 <= a <= n");
        }
        if (b < 2 || b > Math.pow(10, 5)){
            System.out.println("b has to be within this range: 2 <= b <= 10^5");
        }
        
    // Step counter to keep track of the number of operations        
        int steps = 0;
        // Loop until we reach 1 or determine it's impossible
        while (n > 1) {
            if (n % b == 0) {                
// If n is divisible by b, divide by b
                n /= b;            
            } else {
                // Otherwise, subtract a                
                n -= a;
            }            
            steps++;
            // If n goes below 1, it's impossible to reach exactly 1
            if (n < 1) {                
                System.out.println(-1);
                System.out.println("It is impossible to reach 1 from the three integers.");
                return;            }
        }
        // Output the number of steps taken to reach 1        
        System.out.println("The minimum number of steps to reduce to 1: " + steps);
    }
}
