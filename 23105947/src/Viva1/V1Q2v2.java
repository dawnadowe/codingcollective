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
public class V1Q2v2 {
    

    public static void main(String[] args) {
        
    Scanner scanner = new Scanner(System.in);
        long n, a, b;

        // Loop for input validation
        while (true) {
            System.out.print("Enter n, a, and b: ");
            n = scanner.nextLong(); // Use long for large numbers up to 10^9
            a = scanner.nextLong();
            b = scanner.nextLong();

            // Check if inputs are within the specified ranges
            boolean validInput = true;

            if (n < 1 || n > Math.pow(10, 9)) {
                System.out.println("Error: n has to be within this range: 1 <= n <= 10^9");
                validInput = false;
            }
            if (a < 1 || a > n) {
                System.out.println("Error: a has to be within this range: 1 <= a <= n");
                validInput = false;
            }
            if (b < 2 || b > Math.pow(10, 5)) {
                System.out.println("Error: b has to be within this range: 2 <= b <= 10^5");
                validInput = false;
            }

            // If all inputs are valid, exit the loop
            if (validInput) {
                break;
            } else {
                System.out.println("Please re-enter all values for n, a, and b.");
            }
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
                return;
            }
        }

        // Output the number of steps taken to reach 1        
        System.out.println("The minimum number of steps to reduce to 1: " + steps);
}

    
}
