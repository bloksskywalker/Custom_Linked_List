import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting linked list testing program");
        System.out.println("Select an option to test the list:");
        System.out.println("[1]: Run tests manually with user input");
        System.out.println("[2]: Run preset test method");
        System.out.print("Choose an option: ");

        while (true) {
            Scanner input = new Scanner(System.in);
            int choice;
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                continue;
            }

            if (choice == 1) {
                System.out.println("\nContinuing to user tests...");
                break;
            } else if (choice == 2) {
                System.out.println("\nRunning preset test method...");
                test();
                System.exit(0);
            } else {
                System.out.println("Invalid option!");
            }

        }

        System.out.println("Created new list");
        LinkedList list = new LinkedList();
        System.out.println("Available Options: ");
        System.out.println("----- [0]: Exit the program -----");
        System.out.println("[1]: Add First");
        System.out.println("[2]: Add Last");
        System.out.println("[3]: Insert at Index");
        System.out.println("[4]: Count Nodes");
        System.out.println("[5]: Get first index of a value");
        System.out.println("[6]: Get value from an index");
        System.out.println("[7]: Sort list in ascending order");
        System.out.println("[8]: Remove all duplicate values");
        System.out.println("[9]: Remove value at index");
        System.out.println("[10]: Remove first value");
        System.out.println("[11]: Print out entire list");
        System.out.println("----- [12]: Re-print this options list -----");
        while (true) {
            System.out.print("Choose an option from above: ");
            Scanner input = new Scanner(System.in);
            int choice;
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                continue;
            }

            int value;
            int index;

            switch (choice) {
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                case 1:
                    System.out.print("Enter the value to add first: ");
                    try {
                        value = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        continue;
                    }
                    list.addFirst(value);
                    System.out.println("Value added first successfully!");
                    break;
                case 2:
                    System.out.print("Enter the value to add last: ");
                    try {
                        value = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        continue;
                    }
                    list.addLast(value);
                    System.out.println("Value added last successfully!");
                    break;
                case 3:
                    System.out.print("Enter the index of the value to be inserted: ");
                    try {
                        index = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        continue;
                    }
                    System.out.print("Enter the value to be inserted there: ");
                    try {
                        value = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        continue;
                    }
                    list.insertAt(index, value);
                    System.out.println("Value inserted successfully!");
                    break;
                case 4:
                    System.out.println("Number of nodes in the linked list is: " + list.countNodes());
                    break;
                case 5:
                    System.out.print("Enter a value to get an index from: ");
                    try {
                        value = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        continue;
                    }
                    int result = list.getIndex(value);
                    if (result == -1) {
                        System.out.println("Value not found in list.");
                    } else {
                        System.out.println("Value found in list at index: " + result);
                    }
                    break;
                case 6:
                    System.out.print("Enter an index to get a value from: ");
                    try {
                        index = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        continue;
                    }
                    value = list.get(index);
                    System.out.println("Value found in list from index: " + value);
                    break;
                case 7:
                    list.sort();
                    System.out.println("List sorted in ascending order");
                    break;
                case 8:
                    list.removeDuplicates();
                    System.out.println("Duplicates removed from list");
                    break;
                case 9:
                    System.out.print("Enter an index to remove: ");
                    try {
                        index = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input!");
                        continue;
                    }
                    list.remove(index);
                    System.out.println("Value removed successfully!");
                    break;
                case 10:
                    list.removeFirst();
                    System.out.println("Removed first value successfully!");
                    break;
                case 11:
                    System.out.println("Here is the entire list: ");
                    list.printList();
                    break;
                default:
                    System.out.println("Invalid option! Here is the list of available options: ");
                    System.out.println("Available Options: ");
                    System.out.println("----- [0]: Exit the program -----");
                    System.out.println("[1]: Add First");
                    System.out.println("[2]: Add Last");
                    System.out.println("[3]: Insert at Index");
                    System.out.println("[4]: Count Nodes");
                    System.out.println("[5]: Get first index of a value");
                    System.out.println("[6]: Get value from an index");
                    System.out.println("[7]: Sort list in ascending order");
                    System.out.println("[8]: Remove all duplicate values");
                    System.out.println("[9]: Remove value at index");
                    System.out.println("[10]: Remove first value");
                    System.out.println("[11]: Print out entire list");
                    System.out.println("----- [12]: Re-print this options list -----");

            }
            System.out.println("\nYou can type 12 to re-print the available actions list.\n");
        }




    }

    //Some sample tests you can use to check list methods.
    public static void test() {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("Here is the data on the list: ");
        list.printList();
        System.out.println("Index of 1 is: " + list.getIndex(1));
        System.out.println("Index of 2 is: " + list.getIndex(2));
        System.out.println("Index of 3 is: " + list.getIndex(3));
        System.out.println("Index of 4 is: " + list.getIndex(4));
        System.out.println("Index of 5 is: " + list.getIndex(5));
        System.out.println("Removing 2...");
        list.remove(2);
        list.printList();
        System.out.println("Index of 5 is: " + list.getIndex(5));
        System.out.println("Inserting 6 before 5...");
        list.insertAt((list.getIndex(5) - 1), 6);
        list.printList();

        System.out.println("Removing first...");
        list.removeFirst();
        list.printList();

        System.out.println("Removing 5...");
        list.remove(list.getIndex(5));
        list.printList();

        System.out.println("Node count: " + list.countNodes());

        System.out.println("Index 0 is: " + list.get(0));

        System.out.println("Adding last: ");
        list.addLast(67);

        list.printList();

        System.out.println(list.getIndex(4));
        list.addLast(11);
        list.addLast(16);
        list.addLast(93);
        list.addLast(104);
        list.addLast(195);

        list.printList();

        list.remove(list.getIndex(67));

        list.insertAt(list.getIndex(16), 67);

        list.printList();

        System.out.println("List 1 processing done, moving on to list 2.");

        LinkedList list2 = new LinkedList();

        list2.addFirst(0);
        list2.addFirst(1);
        list2.addFirst(2);
        list2.addFirst(3);
        list2.addFirst(4);
        list2.addFirst(6);
        list2.addFirst(5);
        list2.addLast(0);
        list2.addFirst(7);
        list2.addFirst(0);
        list2.addFirst(8);
        list2.addFirst(9);
        list2.addLast(1001);

        for (int i = 0; i < 32; i++) {
            list2.addLast(1000);
        }
        list2.addFirst(1000);

        System.out.println("List 2 results: ");
        list2.printList();
        list2.removeDuplicates();
        list2.sort();
        list2.printList();
        System.out.println("Count: " + list2.countNodes());

        System.out.println("All tests completed, exiting...");
    }
}
