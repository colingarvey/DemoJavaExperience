package net.colingarvey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DataStructuresExamples {
    public static void arrayListInteraction(){
        // Array List allow O(1) lookups if an index is known. Insert operations are O(n), and append ops are O(1)
        // ArrayList objects are dynamically resized, and occasionally add operations can be O(n) as the objects need
        // to be copied to a new array once the initial capacity is reached.
        ArrayList<String> myAL = new ArrayList<>();

        myAL.add("fizzBuzz"); // add some bogus data
        myAL.add("foo");
        myAL.add("bar");
        myAL.add("baz");
        myAL.add(2, "boom!") ;// add allows specification of index to insert value into

        // iteration by for-each or enhanced for loop idiom
        for (String entry : myAL ) {
            System.out.println(entry);
        }

        // Traditional for-loop syntax to iterate over ArrayList indices
        for (int i=0; i<myAL.size(); i++){
            System.out.println(myAL.get(i));
        }
    }

    public static void arrayInteraction(){
        // Traditional arrays require preempting size requirements, is a simple primitive data structure
        // that is great if you know how many values you are going to iterate over or reference beforehand.
        String[] myAL = new String[4];

        myAL[0] = "fizzBuzz";
        myAL[1] = "foo"; // add some bogus data
        myAL[2] = "bar"; // add some bogus data
        myAL[3] = "baz"; // add some bogus data


        // iteration by for-each or enhanced for loop idiom
        for (String entry : myAL ) {
            System.out.println(entry);
        }

        // Traditional for-loop syntax to iterate over ArrayList indices
        for (int i=0; i<myAL.length;  i++){
            System.out.println(myAL[i]);
        }
    }

    public static void hashMapInteraction(){
        // Hash maps are useful as associate arrays between key/value pairs. O(1) lookup speed if the key is known
        // key, value pairs are unordered. Useful when you want to link two pieces of data.
        HashMap<String, Integer> myMap = new HashMap<>();
        myMap.put("foo", 1);
        myMap.put("bar", 3);
        myMap.put("baz", 9);
        myMap.put("bob", 27);

        System.out.println("Iterating over the entrySet...");
        for (Map.Entry<String, Integer> entry :  myMap.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue()); // Iterate via entrySet(); shows unordered set
        }

        System.out.println("Accessing by Key...");
        System.out.printf("Key: %s, Val: %d\n", "bob", myMap.get("bob"));
    }

    public static void queueInteraction(){
        /*
        Implemented my own abstract data type in the Queue class; this is redundant to java.util's implementation;
        however, I wanted to demonstrate proficiency in basic algorithms. Queue is a useful data structure as a First-in
        First-out (FIFO) iterator. This models many real life scenarios such as waiting in line at the grocery store.

        For fairness, the individual who arrived first, thus waited the longest should be served first.

         */

        Queue<String> myQueue = new Queue<>();
        myQueue.enqueue("Bob"); // Bob is first in line
        myQueue.enqueue("Billy");
        myQueue.enqueue("Sharon");

        while (!myQueue.isEmpty()){
            System.out.printf("Welcome to Safeway, %s! How is your day going?\n", myQueue.dequeue());
        }

    }
    public static void stackInteraction(){
        /*
        Implemented my own abstract data type in the Stack class; this is redundant to java.util's implementation;
        however, I wanted to demonstrate proficiency in basic algorithms. Stack is a useful convention when you want to
        deal with the last-arrived item first. This can be a stack of books on your desk, where the most recent is the
        most relevant to your work. Alternatively, we can look at a mail client that prioritizes reading of most recent
        mail first.

         */
        Stack<String> myStack = new Stack<>();
        myStack.push("Email from Bob");
        myStack.push("Email from Johnny");
        myStack.push("Email from The Dude (TM)");

        while (!myStack.isEmpty()){
            System.out.printf("You've got mail: %s\n", myStack.pop());
        }
    }


    public static void main(String[] args) {
        System.out.println("=".repeat(30) + "\nInteracting with ArrayLists:\n" + "=".repeat(30));
        arrayListInteraction();
        System.out.println("=".repeat(30) + "\nInteracting with Arrays:\n" + "=".repeat(30));
        arrayInteraction();
        System.out.println("=".repeat(30) + "\nInteracting with HashMaps:\n" + "=".repeat(30));
        hashMapInteraction();
        System.out.println("=".repeat(30) + "\nInteracting with a Queue:\n" + "=".repeat(30));
        queueInteraction();
        System.out.println("=".repeat(30) + "\nInteracting with a Stack:\n" + "=".repeat(30));
        stackInteraction();
    }
}
