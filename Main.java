import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList singly = new SinglyLinkedList();
        DoublyLinkedList doubly = new DoublyLinkedList();
        try {
            while (true) {
                System.out.println("\n==================================================");
                System.out.println("          LINKED LIST MANAGEMENT SYSTEM");
                System.out.println("==================================================");
                System.out.println("1. Singly Linked List");
                System.out.println("2. Doubly Linked List");
                System.out.println("3. Compare Singly vs Doubly Linked List");
                System.out.println("4. Exit");
                switch (readInt("Enter your choice: ")) {
                    case 1: singlyMenu(singly); break;
                    case 2: doublyMenu(doubly); break;
                    case 3: compareLists(); break;
                    case 4:
                        System.out.println("Goodbye!");
                        return;
                    default: System.out.println("Invalid choice. Enter 1 to 4.");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("\nInput ended. Exiting.");
        } finally {
            scanner.close();
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a whole number between -2147483648 and 2147483647.");
            }
        }
    }

    private static void singlyMenu(SinglyLinkedList list) {
        while (true) {
            System.out.println("\n********** Operation on Singly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle Element");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Exit (Back to Main Menu)");
            switch (readInt("Enter the choice: ")) {
                case 1: list.insertBeginning(readInt("Enter value: ")); break;
                case 2: list.insertEnd(readInt("Enter value: ")); break;
                case 3: list.insertAtPosition(readInt("Enter value: "), readInt("Enter position (1-based): ")); break;
                case 4: list.insertAfter(readInt("Enter target value: "), readInt("Enter new value: ")); break;
                case 5: list.insertBefore(readInt("Enter target value: "), readInt("Enter new value: ")); break;
                case 6: list.deleteBeginning(); break;
                case 7: list.deleteEnd(); break;
                case 8: list.deleteAtPosition(readInt("Enter position (1-based): ")); break;
                case 9: list.deleteByValue(readInt("Enter value to delete: ")); break;
                case 10: list.search(readInt("Enter value to search: ")); break;
                case 11: list.update(readInt("Enter old value: "), readInt("Enter new value: ")); break;
                case 12: list.display(); break;
                case 13: System.out.println("Node count: " + list.count()); break;
                case 14: list.findMaximum(); break;
                case 15: list.findMinimum(); break;
                case 16: list.findMiddle(); break;
                case 17: list.reverse(); System.out.println("List reversed."); break;
                case 18: list.sort(); System.out.println("List sorted in ascending order."); break;
                case 19: list.removeDuplicates(); System.out.println("Duplicates removed."); break;
                case 20: return;
                default: System.out.println("Invalid choice. Enter 1 to 20.");
            }
        }
    }

    private static void doublyMenu(DoublyLinkedList list) {
        while (true) {
            System.out.println("\n********** Operation on Doubly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit (Back to Main Menu)");
            switch (readInt("Enter the choice: ")) {
                case 1: list.insertBeginning(readInt("Enter value: ")); break;
                case 2: list.insertEnd(readInt("Enter value: ")); break;
                case 3: list.insertAtPosition(readInt("Enter value: "), readInt("Enter position (1-based): ")); break;
                case 4: list.insertAfter(readInt("Enter target value: "), readInt("Enter new value: ")); break;
                case 5: list.insertBefore(readInt("Enter target value: "), readInt("Enter new value: ")); break;
                case 6: list.deleteBeginning(); break;
                case 7: list.deleteEnd(); break;
                case 8: list.deleteAtPosition(readInt("Enter position (1-based): ")); break;
                case 9: list.deleteByValue(readInt("Enter value to delete: ")); break;
                case 10: list.search(readInt("Enter value to search: ")); break;
                case 11: list.update(readInt("Enter old value: "), readInt("Enter new value: ")); break;
                case 12: list.displayForward(); break;
                case 13: list.displayBackward(); break;
                case 14: System.out.println("Node count: " + list.count()); break;
                case 15: list.findMaximum(); break;
                case 16: list.findMinimum(); break;
                case 17: list.findMiddle(); break;
                case 18: list.reverse(); System.out.println("List reversed."); break;
                case 19: list.sort(); System.out.println("List sorted in ascending order."); break;
                case 20: list.removeDuplicates(); System.out.println("Duplicates removed."); break;
                case 21: return;
                default: System.out.println("Invalid choice. Enter 1 to 21.");
            }
        }
    }

    private static void compareLists() {
        System.out.println("\nSINGLY VS DOUBLY LINKED LIST (these implementations)");
        System.out.printf("%-25s %-25s %s%n", "Property / Operation", "Singly", "Doubly");
        System.out.printf("%-25s %-25s %s%n", "Node references", "next", "prev and next");
        System.out.printf("%-25s %-25s %s%n", "List references", "head", "head and tail");
        System.out.printf("%-25s %-25s %s%n", "Traversal", "Forward", "Forward and backward");
        System.out.printf("%-25s %-25s %s%n", "Reference memory/node", "One reference", "Two references");
        System.out.printf("%-25s %-25s %s%n", "Insert at beginning", "O(1)", "O(1)");
        System.out.printf("%-25s %-25s %s%n", "Insert at end", "O(n)", "O(1) with tail");
        System.out.printf("%-25s %-25s %s%n", "Delete from beginning", "O(1)", "O(1)");
        System.out.printf("%-25s %-25s %s%n", "Delete from end", "O(n)", "O(1) with tail");
        System.out.printf("%-25s %-25s %s%n", "Insert/delete position", "O(n)", "O(n)");
        System.out.printf("%-25s %-25s %s%n", "Search/display/count", "O(n)", "O(n)");
        System.out.printf("%-25s %-25s %s%n", "Min/max/middle", "O(n)", "O(n)");
        System.out.printf("%-25s %-25s %s%n", "Reverse", "O(n), O(1) extra space", "O(n), O(1) extra space");
        System.out.printf("%-25s %-25s %s%n", "Bubble sort (worst)", "O(n^2)", "O(n^2)");
        System.out.printf("%-25s %-25s %s%n", "Remove duplicates", "O(n^2)", "O(n^2)");
        System.out.println("Doubly linked lists maintain both prev and next when changing links.");
        System.out.println("Both lists select the second middle element for even-length lists.");
    }
}
