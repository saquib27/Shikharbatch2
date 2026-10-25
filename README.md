# Linked List Management System

A menu-driven Java console application implementing Singly and Doubly Linked Lists for a DSA mini project.

## Objective

Practice linked-list operations, reference management, traversal, and algorithm complexity using custom node classes. The linked lists are implemented without arrays or built-in list collections.

## Language Used

Java. A Java Development Kit (JDK) 8 or later is required to compile and run the application. No external libraries are needed.

## Project Structure

```text
shikharbatchll/
├── Main.java              # Application entry point, menus, and input validation
├── SinglyLinkedList.java  # Singly linked list implementation
├── DoublyLinkedList.java  # Doubly linked list implementation
└── README.md
```

## Features

- Separate Singly and Doubly Linked Lists with integer values.
- Insert, delete, search, update, display, and count nodes.
- Find minimum, maximum, and middle elements.
- Reverse, sort in ascending order, and remove duplicates.
- Forward and backward traversal for the Doubly Linked List.
- Compare the two implementations and their time complexities.
- Handle invalid menu choices, non-integer input, and out-of-range integers.

### Singly Linked List

Each node stores `data` and a `next` reference. The list maintains a `head` reference and supports forward traversal.

### Doubly Linked List

Each node stores `data`, `prev`, and `next` references. The list maintains both `head` and `tail`, allowing traversal in either direction and constant-time insertion and deletion at the ends.

## How to Run

Open a terminal in the project folder. Confirm that the JDK is installed:

```bash
java -version
javac -version
```

Compile the source files:

```bash
javac Main.java SinglyLinkedList.java DoublyLinkedList.java
```

Start the application:

```bash
java Main
```

Enter each menu choice or requested integer on its own line.

## Main Menu

```text
==================================================
          LINKED LIST MANAGEMENT SYSTEM
==================================================
1. Singly Linked List
2. Doubly Linked List
3. Compare Singly vs Doubly Linked List
4. Exit
Enter your choice:
```

Option `20` in the Singly menu and option `21` in the Doubly menu return to the main menu. Main-menu option `4` exits the application.

Both lists retain their values when switching menus during a run. Data is stored in memory and is cleared when the application exits.

## Operations

| Operation | Singly menu | Doubly menu |
| --- | --- | --- |
| Insert at beginning | 1 | 1 |
| Insert at end | 2 | 2 |
| Insert at position | 3 | 3 |
| Insert after a node | 4 | 4 |
| Insert before a node | 5 | 5 |
| Delete from beginning | 6 | 6 |
| Delete from end | 7 | 7 |
| Delete from position | 8 | 8 |
| Delete by value | 9 | 9 |
| Search | 10 | 10 |
| Update | 11 | 11 |
| Display / display forward | 12 | 12 |
| Display backward | Not available | 13 |
| Count nodes | 13 | 14 |
| Find maximum | 14 | 15 |
| Find minimum | 15 | 16 |
| Find middle element | 16 | 17 |
| Reverse | 17 | 18 |
| Sort | 18 | 19 |
| Remove duplicates | 19 | 20 |
| Return to main menu | 20 | 21 |

### Behavior and Rules

- Positions are **1-based**. For a list of size `n`, insertion accepts positions `1` through `n + 1`; deletion accepts `1` through `n`.
- Insert before/after, delete by value, search, and update use the **first matching value**.
- For even-length lists, the middle operation returns the **second middle**. For example, the middle of `10 -> 20 -> 30 -> 40` is `30`.
- Sorting uses Bubble Sort and swaps node data.
- Reversing changes node references in place.
- Removing duplicates preserves the first occurrence and the order of the remaining values.
- Zero, negative values, and duplicate values are supported. Values must fit in a Java `int` (`-2147483648` to `2147483647`).
- Missing values, empty lists, and invalid positions are handled without changing valid list contents. Sorting or reversing an empty list is safe.
- End of input exits the application cleanly.

## Sample Output

The examples below show list output; repeated menus and prompts are omitted.

### Singly Linked List: Sort and Reverse

Choose main-menu option `1`. Use operation `2` five times to insert `40`, `10`, `30`, `20`, and `50`. Choose operation `12` to display:

```text
40 -> 10 -> 30 -> 20 -> 50 -> NULL
```

Choose operation `18` to sort, then `12` to display:

```text
List sorted in ascending order.
10 -> 20 -> 30 -> 40 -> 50 -> NULL
```

Choose operation `17` to reverse, then `12` to display:

```text
List reversed.
50 -> 40 -> 30 -> 20 -> 10 -> NULL
```

### Doubly Linked List: Forward and Backward

Choose main-menu option `2`. Use operation `2` to insert `10`, `20`, `30`, and `40`. Choose operation `12`:

```text
NULL <- 10 <-> 20 <-> 30 <-> 40 -> NULL
```

Choose operation `13`:

```text
NULL <- 40 <-> 30 <-> 20 <-> 10 -> NULL
```

## Time Complexity

Here, `n` is the number of nodes. These are worst-case time bounds for the current implementations.

| Operation | Singly Linked List | Doubly Linked List |
| --- | --- | --- |
| Insert at beginning | O(1) | O(1) |
| Insert at end | O(n) | O(1) |
| Insert at position | O(n) | O(n) |
| Insert before/after a value | O(n) | O(n) |
| Delete from beginning | O(1) | O(1) |
| Delete from end | O(n) | O(1) |
| Delete from position / by value | O(n) | O(n) |
| Search / update | O(n) | O(n) |
| Display / count | O(n) | O(n) |
| Find minimum / maximum / middle | O(n) | O(n) |
| Reverse | O(n) | O(n) |
| Bubble Sort | O(n²) | O(n²) |
| Remove duplicates | O(n²) | O(n²) |

The Doubly Linked List uses a tail reference for efficient operations at the end. Position-based methods still take O(n) because they count and/or traverse nodes. Both lists use O(n) storage overall; reversal uses O(1) extra space. Doubly linked nodes store one additional reference per node.

## Manual Testing Checklist

- Try display, search, deletion, min/max/middle, sort, reverse, and duplicate removal on an empty list.
- Insert one node, reverse/sort it, then delete it.
- Insert and delete at position `1`; insert at position `n + 1`.
- Try position `0`, a negative position, and an out-of-range position.
- Search, update, or delete a value that does not exist.
- Insert repeated values and confirm that duplicate removal preserves first occurrences.
- Insert zero and negative values; check sorting, minimum, and maximum.
- Check the middle for odd- and even-length lists.
- Check forward and backward displays after Doubly Linked List insertions, deletions, and reversal.
- Enter letters, blank input, or an integer outside the supported range.
- Switch between menus and confirm each list retains its own data.
