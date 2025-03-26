/**
 * Author: Nija Steward
 * Date: 03.11.2025
 * Description: A Java program that simulates turn-based participation in a game or shared system.
 * It allows adding, removing, listing, and taking turns among participants.
 */

 import java.util.Scanner;

 // Represents a participant in the turn-based system
 class Person {
     private String name;
 
     public Person(String name) {
         this.name = name;
     }
 
     public String getName() {
         return name;
     }
 }
 
 // Manages the turn order using an array-based list
 class TurnManager {
     private Person[] participants;
     private int count;
     private int currentTurn;
 
     public TurnManager(int capacity) {
         participants = new Person[capacity];
         count = 0;
         currentTurn = 0;
     }
 
     // Adds a new person at the end of the turn order
     public void addPerson(String name) {
         if (count >= participants.length) {
             System.out.println("The participant list is full.");
             return;
         }
         participants[count] = new Person(name);
         count++;
         System.out.println(name + " has been added to the participants.");
     }
 
     // Removes a person by name and adjusts the turn order
     public void removePerson(String name) {
         int index = -1;
         for (int i = 0; i < count; i++) {
             if (participants[i].getName().equalsIgnoreCase(name)) {
                 index = i;
                 break;
             }
         }
 
         if (index == -1) {
             System.out.println("Participant not found.");
             return;
         }
 
         for (int i = index; i < count - 1; i++) {
             participants[i] = participants[i + 1];
         }
         participants[count - 1] = null;
         count--;
 
         if (currentTurn >= count) {
             currentTurn = 0;
         }
 
         System.out.println(name + " has been removed from the participants.");
     }
 
     // Lists all participants starting from the next turn
     public void listParticipants() {
         if (count == 0) {
             System.out.println("No participants available.");
             return;
         }
 
         System.out.println("Current Participants:");
         for (int i = 0; i < count; i++) {
             int displayIndex = (currentTurn + i) % count;
             System.out.println((i + 1) + ". " + participants[displayIndex].getName());
         }
     }
 
     // Starts the next turn and rotates the order
     public void startTurn() {
         if (count == 0) {
             System.out.println("No participants available to take a turn.");
             return;
         }
 
         System.out.println("It's " + participants[currentTurn].getName() + "'s turn.");
         currentTurn = (currentTurn + 1) % count;
     }
 }
 
 // Public main class to ensure correct execution
 public class Client {
     public static void main(String[] args) {
         System.out.println("Java program is running..."); // Ensures the program starts properly
 
         Scanner scanner = new Scanner(System.in);
         TurnManager manager = new TurnManager(10); // Maximum of 10 participants for simplicity
 
         // Initialize with some participants
         manager.addPerson("Alice");
         manager.addPerson("Bob");
         manager.addPerson("Charlie");
 
         while (true) {
             System.out.println("\nOptions: A (Add) | D (Drop) | L (List) | S (Start) | E (End)");
             System.out.print("Enter your choice: ");
             String input = scanner.next().toUpperCase();
 
             if (input.length() != 1) {
                 System.out.println("Invalid choice. Please enter a single letter.");
                 continue;
             }
 
             char choice = input.charAt(0);
 
             switch (choice) {
                 case 'A':
                     System.out.print("Enter participant name: ");
                     scanner.nextLine(); // Consume newline
                     String nameToAdd = scanner.nextLine().trim();
                     if (nameToAdd.isEmpty()) {
                         System.out.println("Name cannot be empty.");
                     } else {
                         manager.addPerson(nameToAdd);
                     }
                     break;
 
                 case 'D':
                     System.out.print("Enter participant name to remove: ");
                     scanner.nextLine();
                     String nameToRemove = scanner.nextLine().trim();
                     if (nameToRemove.isEmpty()) {
                         System.out.println("Name cannot be empty.");
                     } else {
                         manager.removePerson(nameToRemove);
                     }
                     break;
 
                 case 'L':
                     manager.listParticipants();
                     break;
 
                 case 'S':
                     manager.startTurn();
                     break;
 
                 case 'E':
                     System.out.println("Exiting the simulation.");
                     scanner.close();
                     return;
 
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         }
     }
 }