/*
Completed:
By: Nicholas Phillips
Date: 02/06/2023

Purpose: The purpose of this code is to sort the roster file based on the following, first name, last name, college attended, player number, age, and weight
 as specified by the user's input. The code first prompts the user for the desired sorting criteria, then reads the contents of the roster file, and sorts it based 
 on the user's input. First name, last name, and collge attended will be sorted by selection sort and player number, age, and weight will be sorted using bubble sort. 
 Finally, the code displays the sorted contents of the file.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class brownsRosterTest {
    private static final int MAX = 100;
    private static Player[] players = new Player[MAX];

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Sort by: 1) First Name of the player 2) Last Name of the player 3) College that the player attended 4) Player Number 5) Age 6) Weight");
        int optionSort = userInput.nextInt();
        userInput.close();

        filePlayers();

        // takes userInput and sorts by an input of 1 - 6
        switch(optionSort) {
            case 1:
                selectionSort(optionSort);
                break;
            case 2:
                selectionSort(optionSort);
                break;
            case 3:
                selectionSort(optionSort);
                break;
            case 4:
                bubbleSort(optionSort, players);
                break;
            case 5:
                bubbleSort(optionSort, players);
                break;
            case 6:
                bubbleSort(optionSort, players);
                break;
            case 7:
                System.out.println("Invalid number, below is the original file");
                break;
        }

        displayPlayers();
    }


    // received help by Tyler Powell on 06/03/2023 to help load players and read the fields separately
    private static void filePlayers() {
        // try-catch block to handle potential file not found exception
        try {
            Scanner fileScan = new Scanner(new File("roster.txt"));
            int playArray = 0; // counter
            // loop through the file while there is still data to read
            while (fileScan.hasNext()) {
                String firstName = fileScan.next(); // first column 
                String lastName = fileScan.next(); // second column 
                int playerNumber = fileScan.nextInt();
                String playerPosition = fileScan.next();
                String playerHeight = fileScan.next();
                int playerWeight = fileScan.nextInt();
                int playerAge = fileScan.nextInt();
                String yearsPlayed = fileScan.next();
                String playerCollege = fileScan.nextLine().trim(); // seventh column
                players[playArray] = new Player(firstName, lastName, playerNumber, playerPosition, playerHeight, playerWeight, playerAge, yearsPlayed, playerCollege);
                playArray++;
            }
            fileScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find roster.txt file: " + e);
        }
    }

    private static void bubbleSort (int optionSort, Player[] players){
        boolean flag = true; 
        int fileLength = players.length;        
        int j = 0;

        while (flag) {
            flag = false;
            for (j = 0; j < fileLength; j++) {
                // skip to the next iteration if either of the elements to be compared are null
                if (players[j] == null || players[j + 1] == null) {
                    continue;
                }
                // compare player number and swap if the current element is greater than the next
                if (optionSort == 4 && players[j].playerNumber > players[j + 1].playerNumber){
                    Player temp = players[j];
                    players[j] = players[j+1];
                    players[j+1] = temp;
                     // set flag to true if a swap was made
                    flag = true;
                }

                if (optionSort == 5 && players[j].playerAge > players[j + 1].playerAge){
                    Player temp = players[j];
                    players[j] = players[j+1];
                    players[j+1] = temp;
                    flag = true;
                }

                if (optionSort == 6 && players[j].playerWeight > players[j + 1].playerWeight){
                    Player temp = players[j];
                    players[j] = players[j+1];
                    players[j+1] = temp;
                    flag = true;
                }

            }
        }
     }

    //Prints out the contents of the orginial file called roster.txt
    private static void displayPlayers() {
        int i = 0; // loop control
        int fileLength = 63; // number of lines within the file
        for (i = 0; i < fileLength; i++) {
             System.out.println(players[i]);
        }
    }

    private static void selectionSort(int optionSort) {
        int fileLength = 63;
        int i = 0; // loop counter
        int minimum = i;

        // loop through the players array
        for (i = 0; i < fileLength; i++) {
            for (int j = i + 1; j < fileLength; j++) {
                if (players[j] == null) {
                    break;
                }
                // if j is greater than or equal to the length of the players array, break the inner loop
                else if (j >= fileLength) {
                break;
            }
            Player p1 = players[j];
            Player p2 = players[minimum];
            int compareSelectionSort = 0;

            // comparison is made between the first names of p1 and p2.
        
            if (optionSort == 1) {
                compareSelectionSort = p1.firstName.compareTo(p2.firstName);
            } 
            else if (optionSort == 2) {
                compareSelectionSort = p1.lastName.compareTo(p2.lastName);
            } 
            else if (optionSort == 3) {
                compareSelectionSort = p1.playerCollege.compareTo(p2.playerCollege);
            }
            if (compareSelectionSort < 0) {
                minimum = j;
            } 
        }
        // swap the player with a player at the minimum index
            Player temp = players[i];
            players[i] = players[minimum];
            players[minimum] = temp;
        }
    }
}   

// access modifier allows the contents of the String to be accessed by subclasse
class Player {
    protected String firstName;
    protected String lastName;
    protected int playerNumber;
    protected String playerPosition;
    protected String playerHeight;
    protected int playerWeight;
    protected int playerAge;
    protected String yearsPro;
    protected String playerCollege;

    // initializes all the class attributes with the parameters passed in
    public Player(String firstName, String lastName, int playerNumber, String playerPosition, String playerHeight, int playerWeight, int playerAge, String yearsPro, String playerCollege) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerNumber = playerNumber;
        this.playerPosition = playerPosition;
        this.playerHeight = playerHeight;
        this.playerWeight = playerWeight;
        this.playerAge = playerAge;
        this.yearsPro = yearsPro;
        this.playerCollege = playerCollege;
    }

    // help by Tyler Powell on 06/03/2023
    // overrides the toString method to return a string representation of the player's information from roster.txt
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + playerNumber + " " + playerPosition + " " + playerHeight + " " + playerWeight + " " + playerAge + " " + yearsPro + " " + playerCollege;
    }

    // Returns the player's number
    public int getNumber() {
        return playerNumber;
    }

    public int getAge() {
        return playerAge;
    }

    public int getWeight() {
        return playerWeight;
    }
}