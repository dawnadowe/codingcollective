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
public class V1Q4notmine {
    
    public static void main(String[] args) { 
        Scanner myObj = new Scanner(System.in); 
        double total = 0; //total price 
        int choice = 0; //variable for chosen menu item, eg 1,2,3 
        int menu1 = 0; //counter for menu 1 (how many items ordered) 
        int menu2 = 0; //counter for menu 2 (how many items ordered) 
        int menu3 = 0; //counter for menu 3 (how many items ordered) 
        
        mainloop: while(true){//while loop so that it cycles back to main menu unless user choose to checkout 

            System.out.print(""" 
                               Welcome to Maroni's Pizza! 
                               1. Pizza 
                               2. Drinks 
                               3. Dessert 
                               4. CHECKOUT 
                               
                               Pick an option: """); //outputs the main menu 
            
            int submenu = myObj.nextInt(); //variable to choose between pizza, drinks and dessert menu or checkout 
            System.out.println(); 
             
            if (submenu == 1){ //if loop for option pizza menu 
                pizzaloop: while (true){ //while loop so that everytime it loops back here unless user choose to go back to main menu 
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
                    System.out.println("Added Chicken Peperoni");//displays menu item chosen 
                    total += 15;//adds price to total 
                    System.out.printf("Current total: RM%.2f\n",total);//displays current total 
                    System.out.println(); 
                    menu1++;//increase pizza menu counter 
                    continue pizzaloop;//goes back to loop line 30 (pizza menu) 
                } 
                 
                if (choice == 2){ 
                    System.out.println("Added Chicken Supreme"); 
                    total += 18; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu1++; 
                    continue pizzaloop; 
                } 
                
                if (choice == 3){ 
                    System.out.println("Added Vegan Indulgence"); 
                    total += 12; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu1++; 
                    continue pizzaloop; 
                } 
                
                if (choice == 4){ 
                    System.out.println("Added Beef Delight"); 
                    total += 22; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu1++; 
                    continue pizzaloop; 
                } 
                 
                if (choice == 5){ 
                    System.out.println("Added Margherita"); 
                    total += 9; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu1++; 
                    continue pizzaloop; 
                } 
                 
                if (choice == 6){ 
                    System.out.println(); 
                    break pizzaloop;//breaks inner while loop and goes back to main menu(line 16) 
                }
                else{ 
                    System.out.println("Enter a valid choice!");//error handling: if user inputs choice other than given 
                    continue pizzaloop;//loops back to line 30 
                } 
                } 
            } 
            
            else if (submenu == 2){ 
                drinkloop: while (true){ 
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
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu2++; 
                    continue drinkloop; 
                } 
                 
                if (choice == 2){ 
                    System.out.println("Added Banana Smoothie"); 
                    total += 8; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu2++; 
                    continue drinkloop; 
                } 
                 
                if (choice == 3){ 
                    System.out.println("Added Mocktail"); 
                    total += 12; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu2++; 
                    continue drinkloop; 
                } 
                
                if (choice == 4){ 
                    System.out.println("Added Soft Drink"); 
                    total += 5; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu2++; 
                    continue drinkloop; 
                } 
               
                if (choice == 5){ 
                    System.out.println("Added Mineral Water"); 
                    total += 3; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu2++; 
                    continue drinkloop; 
                } 
                 
                if (choice == 6){ 
                    System.out.println(); 
                    break drinkloop; 
                }else{ 
                    System.out.println("Enter a valid choice!"); 
                    continue drinkloop; 
                } 
                } 
            } 
             
            else if (submenu == 3){ 
                dessertloop: while (true){ 
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
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu3++; 
                    continue dessertloop; 
                } 
                 
                if (choice == 2){ 
                    System.out.println("Added Strawberry Shortcake"); 
                    total += 10; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu3++; 
                    continue dessertloop; 
                } 
                 
                if (choice == 3){ 
                    System.out.println("Added Green Jello"); 
                    total += 4; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu3++; 
                    continue dessertloop; 
                } 
                 
                if (choice == 4){ 
                    System.out.println("Added Creme Brûlée"); 
                    total += 15; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu3++; 
                    continue dessertloop; 
                } 
                 
                if (choice == 5){ 
                    System.out.println("Added Raspberry Pie"); 
                    total += 20; 
                    System.out.printf("Current total: RM%.2f\n",total); 
                    System.out.println(); 
                    menu3++; 
                    continue dessertloop; 
                } 
                 
                if (choice == 6){ 
                    System.out.println(); 
                    break dessertloop; 
                }else{ 
                    System.out.println("Enter a valid choice!"); 
                    continue dessertloop; 
                } 
                } 
            } 
             
            else if (submenu == 4){ 
                break mainloop;//breaks while loop and goes to checkout (line 247 onwards) 
            }else{ 
                    System.out.println("Enter a valid choice!");//error handling if user chose options other than 1-4 
                    continue mainloop;//goes back to while loop (line 16) 
                } 
        } 
         
        if ((menu1>=1 && menu2>=1) && menu3>=1){//checkout if each menu has atleast 1 item ordered 
            System.out.printf("Your total is RM%.2f",total); 
            System.out.println("\nYou're availed the One-of-each offer. You get a 20% discount!"); 
            double totalFinal = (double)0.8*total;//counts total with discount applied 
            System.out.printf("Your new total is RM%.2f",totalFinal); 
            System.out.println("\nHave a nice day!"); 
        }else{//checkout if no discount applied 
            System.out.printf("Your total is RM%.2f",total); 
            System.out.println("\nHave a nice day!"); 
        } 
        myObj.close(); 
    } 
}


