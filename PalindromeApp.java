/*
 * Completed By: Tyler Powell, Nicholas Phillips, and Frank Nkurunziza 
 * 
 * The purpose of this code is to determine whether a given input phrase is a palindrome, which 
 * is a word or phrase that reads the same backward as forward. The program uses a stack 
 * and a queue by stripping the input of non-alphabetic characters, converting all letters to lowercase, 
 * and then comparing the characters in the original input. The program prompts the user to 
 * enter a phrase, and then provides output indicating whether the input is a palindrome or not. 
 * 
 * 
 * isPalindromeQUEUE RunTime = 3N + N + 3
 * isPalindromeSTACK RunTime = 3N + N + 3
 * Code Given in D2L = 3N + 3/2 N
 * 
 * 
 * The runtime for isPalindromeQUEUE, isPalindromeSTACK, and the code in D2L are the same. 
 * The runtimes are linear, meaning that as the input size (N) increases, the time it takes to run will also increase
 *  at a proportional rate.
 */

import java.util.Scanner;

public class PalindromeApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        System.out.print("Enter a phrase: ");
        input = scanner.nextLine();
        
        while (!input.equals("quit")) {

            // Remove all non-letter characters from the input
            String strippedInput = input.replaceAll("\\W", "");
            
            // Convert all letters to lower case
            strippedInput = strippedInput.toLowerCase();
            System.out.println("Phrase: "+strippedInput);
            System.out.println("Queue: "+isPalindromeQUEUE(strippedInput));
            System.out.println("Stack: "+isPalindromeSTACK(strippedInput));

            if (isPalindromeQUEUE(strippedInput) && isPalindromeSTACK(strippedInput)) {
                System.out.println("Using a queue and a stack, we confirmed the input is a palindrome");
            } else {
                System.out.println("The input is NOT a palindrome");
            }
            System.out.print("Enter a phrase (or 'quit'): ");
            input = scanner.nextLine();
        }
    }

    /*
     * Run Time: 3N + N + 3
     */

    public static boolean isPalindromeSTACK(String str) {
        StackX stack = new StackX(str.length()); //1
        // Add each character of the string to the stack
        for (int i = 0; i < str.length(); i++) { //N
            stack.push(str.charAt(i)); // 1/2 N
        }
        // Pop each character from the stack and compare it to the corresponding character in the original string
        for (int i = 0; i < str.length(); i++) { //N
            char c1 = str.charAt(i); //1
            char c2 = stack.pop(); //1
            if (c1 != c2) { //N
                return false; // 1/2 N
            }
        }
        return true; //1
    }

    /*
     * Run Time: 3N + N + 3
     */
    public static boolean isPalindromeQUEUE(String str) {
        Queue queue = new Queue(str.length()); //1
        // Add each character of the string to the queue
        for (int i = 0; i < str.length(); i++) { //N
            queue.insert(str.charAt(i)); // 1/2 N
        }
        // Remove each character from the queue and compare it to the corresponding character in the original string
        for (int i =str.length()-1 ; i >=0; i--) { //N
            char c1 = str.charAt(i); // 1
            char c2 = queue.remove(); // 1
            if (c1 != c2) { //N
                return false; // 1/2 N
            }
        }
        return true; //1
    }
}

/*

Run Time: 3N + 3/2 N

   for i from 0 to n/2 do // N
	if a[i] != a[n-i] // N
	    exit // 1/2 N
    if i != n/2  // N 
   	return false // 1/2 N
  else
	return true // 1/2 N
 */