/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week6T5;

/**
 *
 * @author Acer
 */
public class T5Q4 {
    
//Write the statements that display the number of occurrence of the word "the" (case
//sensitive) in a string array name sentence
    
    public static void main(String[] args) {
        
        int count=0;
        String[] sentence = {"the","Queen","has","arrived","at","the","hall"};
        for(int i=0; i<sentence.length;i++){
            if(sentence[i].equals("the")){
                count++;
            }
        }
        System.out.println("The word \"the\" appeared " + count + " times.");
    }
    
}
