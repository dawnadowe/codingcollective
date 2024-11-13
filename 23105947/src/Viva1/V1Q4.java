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
public class V1Q4 {
   
    
    public static void main(String[] args) {
        
        Scanner myObj = new Scanner(System.in);
        int total = 0;
        int choice = 0;
        int menu1 = 0;
        int menu2 = 0;
        int menu3 = 0;
        
        while(true){
            System.out.print("""
                               Welcome to Maroni's Pizza!
                               1. Pizza
                               2. Drinks
                               3. Dessert
                               4. CHECKOUT
                               
                               Pick an option: """);
            
            int submenu = myObj.nextInt();
            System.out.println();
            
            if (submenu == 1){
                while (true){
                System.out.print("""
                                PIZZA
                                1 Chicken Peperoni - RM15
                                2 Chicken Supreme - RM18
                                3 Vegan Indulgence - RM12
                                4 Beef Delight - RM22
                                5 Margherita - RM9
                                6 BACK TO MAIN MENU
                                
                                Pick an option: """);
                
                choice = myObj.nextInt();
                
                if (choice == 1){
                    System.out.println("Added Chicken Peperoni");
                    total += 15;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu1++;
                    continue;
                }
                
                if (choice == 2){
                    System.out.println("Added Chicken Supreme");
                    total += 18;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu1++;
                    continue;
                }
                
                if (choice == 3){
                    System.out.println("Added Vegan Indulgence");
                    total += 12;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu1++;
                    continue;
                }
                
                if (choice == 4){
                    System.out.println("Added Beef Delight");
                    total += 22;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu1++;
                    continue;
                }
                
                if (choice == 5){
                    System.out.println("Added Margherita");
                    total += 9;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu1++;
                    continue;
                }
                
                if (choice == 6){
                    System.out.println();
                    break;
                }else{
                    System.out.println("Enter a valid choice!");
                    continue;
                }
                }
            }
            
            else if (submenu == 2){
                while (true){
                System.out.print("""
                                DRINKS
                                1 Strawberry Smoothie - RM8
                                2 Banana Smoothie - RM8
                                3 Mocktail - RM12
                                4 Soft Drink - RM5
                                5 Mineral Water - RM3
                                6 BACK TO MAIN MENU
                                
                                Pick an option: """);
                
                choice = myObj.nextInt();
                
                if (choice == 1){
                    System.out.println("Added Strawberry Smoothie");
                    total += 8;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu2++;
                    continue;
                }
                
                if (choice == 2){
                    System.out.println("Added Banana Smoothie");
                    total += 8;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu2++;
                    continue;
                }
                
                if (choice == 3){
                    System.out.println("Added Mocktail");
                    total += 12;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu2++;
                    continue;
                }
                
                if (choice == 4){
                    System.out.println("Added Soft Drink");
                    total += 5;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu2++;
                    continue;
                }
                
                if (choice == 5){
                    System.out.println("Added Mineral Water");
                    total += 3;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu2++;
                    continue;
                }
                
                if (choice == 6){
                    System.out.println();
                    break;
                }else{
                    System.out.println("Enter a valid choice!");
                    continue;
                }
                }
            }
            
            else if (submenu == 3){
                while (true){
                System.out.print("""
                                DESSERT
                                1 Tiramisu - RM7
                                2 Strawberry Smoothie - RM10
                                3 Green Jello - RM4
                                4 Creme Brûlée - RM15
                                5 Raspberry Pie - RM20
                                6 BACK TO MAIN MENU
                                 
                                Pick an option: """);
                
                choice = myObj.nextInt();
                
                if (choice == 1){
                    System.out.println("Added Tiramisu");
                    total += 7;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu3++;
                    continue;
                }
                
                if (choice == 2){
                    System.out.println("Added Strawberry Shortcake");
                    total += 10;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu3++;
                    continue;
                }
                
                if (choice == 3){
                    System.out.println("Added Green Jello");
                    total += 4;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu3++;
                    continue;
                }
                
                if (choice == 4){
                    System.out.println("Added Creme Brûlée");
                    total += 15;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu3++;
                    continue;
                }
                
                if (choice == 5){
                    System.out.println("Added Raspberry Pie");
                    total += 20;
                    System.out.println("Current total: RM"+(double)total);
                    System.out.println();
                    menu3++;
                    continue;
                }
                
                if (choice == 6){
                    System.out.println();
                    break;
                }else{
                    System.out.println("Enter a valid choice!");
                    continue;
                }
                }
            }
            
            else if (submenu == 4){
                break;
            }else{
                    System.out.println("Enter a valid choice!");
                    continue;
                }
        }
        
        if ((menu1>=1 && menu2>=1) && menu3>=1){
            System.out.println("Your total is RM"+(double)total);
            System.out.println("You're availed the One-of-each offer. You get a 20% discount!");
            double totalFinal = (double)0.8*total;
            System.out.printf("Your new total is RM"+"%.2f",totalFinal);
            System.out.println("\nHave a nice day!");
        }else{
            System.out.println("Your total is RM"+(double)total);
            System.out.println("Have a nice day!");
        }
        myObj.close();
                
                
            
        
        
    
}
}
