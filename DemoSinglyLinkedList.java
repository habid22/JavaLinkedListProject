package LA1Q1;

import java.util.*;

public class DemoSinglyLinkedList {

    public Scanner input;


    public static void stackDemo(SinglyLinkedList list) { // Stack Demo method
        // Initializing values
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        boolean error;
        System.out.println(" \n"+"Stack demo with the Integer Linked List...");
        System.out.println("Which end of the Linked List would you like to use as the stack top?\nEnter 1 for head or 2 for tail:");
        // Validation Do Loop using try and catch to make sure the user can only enter 1 or 2.
        do {
            try {
                userInput = input.nextInt();
                if (userInput < 1 || userInput > 2) {
                    throw new InputMismatchException(); // Throws input mismatch exception to make sure user can only enter 1 and 2
                } else {
                    error = false;
                }
            } catch (InputMismatchException e) { // catch statement, will catch till user enters asked values
                System.out.println("Please enter a valid number! Which end of the Linked List would you like to use as the stack top? 1 or 2 \nEnter 1 for head or 2 for tail: ");
                error = true;
                input.nextLine();
            }
        } while (error);


        if (userInput == 1) { // Demo if user selects 1
            System.out.println("Stack Top: Head of the linked list");
            int size = list.getSize(); // Gets list size to be used in for loop to pop values from the head
            System.out.println("\n"+"Lets pop all elements from the stack in sequence: ");
            System.out.println("The current stack: " + list.toString() + "\n");
            for (int i = 0; i < size; i++) {
                System.out.println(list.popFromHead() + " has been popped!" + " The revised stack: " + list.toString()); // pops values and prints revised stack
            }
            // Pushing Values from Head
            System.out.println(" \n" + "Let push 39 and -58 back into the stack...");
            System.out.println("The current stack: " + list.toString());
            list.pushAtHead(39); // Using .pushAtHead to push values inside
            System.out.println("After 39 is pushed, the revised stack: " + list.toString());
            list.pushAtHead(-58);
            System.out.println("After -58 is pushed, the revised stack: " + list.toString());

        }


        if (userInput == 2) { // Demo if user selects 2
            System.out.println("Stack Top: Tail of the linked list");
            System.out.println(" \n" + "Lets pop all elements from the stack in sequence: ");
            System.out.println("The current stack: " + list.toString() + "\n");

            for (int i = 0; i < 3; i++) { // for loop to pop 3 elements from the tail
                System.out.println(list.popFromTail() + " has been popped!" + " The revised stack: " + list.toString()); // pops values using popFromTail method created and prints revised stack
            }
            // Pushing Values from Tail
            System.out.println(" \n" + "Let push 39 and -58 back into the stack...");
            System.out.println("The current stack: " + list.toString());
            list.pushAtTail(39); // using pushAtTail method to push
            System.out.println("After 39 is pushed, the revised stack: " + list.toString());
            list.pushAtTail(-58);
            System.out.println("After -58 is pushed, the revised stack: " + list.toString());

        }
    }


    public static void queueDemo(SinglyLinkedList list) { // queueDemo
        System.out.println(" \n" + "Queue Demo with the String linked list ...");
        System.out.println("Note: Head is the Q-front, and Tail is the Q-rear");

        System.out.println(" \n" + "Lets enqueue Joelle and Lukas in the queue sequence...");
        // using enqueue method to add element to a queue
        System.out.println(" \n" + "The current queue: " + list.toString());

        list.enqueueAtTail("Joelle");
        System.out.println(" \n"+"After Joelle is enqueued, the revised queue: " + list.toString());

        list.enqueueAtTail("Lukas");
        System.out.println("After Lukas is enqueued, the revised queue: " + list.toString() + "\n");
        list.enqueueAtTail("Hassan");
        System.out.println("After Hassan is enqueued, the revised queue: " + list.toString() + "\n");


        System.out.println("Lets dequeue the first three elements from the queue in sequence...");
        System.out.println(" \n" + "The current queue: " + list.toString()); // Dequeue method, using for loop to dequeue the first 3 values at the head
        for (int i = 0; i < 3; i++) {
            System.out.println(list.dequeueAtHead() + " has been dequeued!" + " The revised queue: " + list.toString());
        }


    }

    public static void main(String[] args) { // main method
        header(); // calling header method to display lab info
        // two ArrayLists that contain the needed values
        ArrayList<Integer> integerValues = new ArrayList<>(Arrays.asList(56, -22, 34, 57, 98));
        ArrayList<String> stringNames = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));
        // print statements for ArrayLists
        System.out.println("The given Integer Array: " + integerValues);
        System.out.println("The given String Array: " + stringNames);
        // Assigning LLinValues to SinglyLinked list
        SinglyLinkedList LLintValues = new SinglyLinkedList();
        for (int i = 0; i < 3; i++) { // for loop to add the first 3 values from ArrayList integerValues to add to the head
            LLintValues.addFirst(integerValues.get(i));
        }
        for (int i = integerValues.size()-1; i >= 3; i--) { // for loop to add remaining values to tail
            LLintValues.addLast(integerValues.get(i));
        }

        SinglyLinkedList LLStringValues = new SinglyLinkedList();
        for (int i = 0; i < 3; i++) { // for loop to add the first 3 values from ArrayList stringNames to add to the head
            LLStringValues.addFirst(stringNames.get(i));
        }
        for (int i = stringNames.size()-1; i >= 3; i--) { // for loop to add remaining values to tail
            LLStringValues.addLast(stringNames.get(i));
        }
        // print statements for the new lists
        System.out.println("Your Integer List: " + LLintValues.toString());
        System.out.println("Your String List: " + LLStringValues.toString());

        // calling stackDemo and queueDemo inside this main class
        DemoSinglyLinkedList.stackDemo(LLintValues);
        DemoSinglyLinkedList.queueDemo(LLStringValues);
        // scanner value
        Scanner input = new Scanner(System.in);
        System.out.println(" \n" + "Lets search the Stack...");
        System.out.println("The current stack: " + LLintValues.toString());

        char choice;
        // start of do loop to see if the user wants to continue or not
        do {
            System.out.println(" \n" + "Enter the value you are searching for: ");
            // assigning int value to search input
            int searchInput = input.nextInt();
            // this checks if the searchInput is inside the stack and assigns the index value to searchIndex
            int searchIndex = LLintValues.searchStack(searchInput);
            if (searchIndex == 0) { // if SearchInput  is not found it returns 0, therefore value will not be found
                System.out.println("Value is not found!");
            } else {
                System.out.println("The value " + searchInput + " is found in location " + searchIndex + " from top of the stack"); // else statement to print the entered value and displays the index location
            }
            System.out.println("Do you want to continue? (Enter the key y to CONTINUE or any other key to TERMINATE): "); // statement to see if the user wants to continue
            choice = input.next().charAt(0);
        } while (choice == 'y'); // will run till the user enters y

        footer(); // method which displays completion information


    }

    public static void header() { // Method for Header
        System.out.println("=================================================");
        System.out.println("Lab Assignment 1-Q1");
        System.out.println("Prepared by: " + "Hassan" + " Abid Amin");
        System.out.println("Student Number: " + "251219098");
        System.out.println("Goal of this Exercise: " + "Using Singly Linked Lists to demonstrate our understanding of how to apply different methods to them...");
        System.out.println("================================================= \n");
    }

    public static void footer() { // Method for Footer
        System.out.println("=================================================");
        System.out.println("Completion of Lab Assignment 1-Q1 is successful!");
        System.out.println("Signing off -" + " Hassan");
        System.out.println("=================================================");
    }
}