public class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public void insertBeginning(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        System.out.println(value + " inserted at the beginning.");
    }

    public void insertEnd(int value) {
        Node node = new Node(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        System.out.println(value + " inserted at the end.");
    }

    public void insertAtPosition(int value, int position) {
        if (position < 1 || position > count() + 1) {
            System.out.println("Invalid position. Valid positions are 1 to " + (count() + 1) + ".");
            return;
        }
        if (position == 1) {
            insertBeginning(value);
            return;
        }
        if (position == count() + 1) {
            insertEnd(value);
            return;
        }
        Node current = head;
        for (int i = 1; i < position; i++) current = current.next;
        Node node = new Node(value);
        node.prev = current.prev;
        node.next = current;
        current.prev.next = node;
        current.prev = node;
        System.out.println(value + " inserted at position " + position + ".");
    }

    public void insertAfter(int target, int value) {
        Node current = findNode(target);
        if (current == null) {
            System.out.println("Value " + target + " not found.");
            return;
        }
        if (current == tail) {
            insertEnd(value);
            return;
        }
        Node node = new Node(value);
        node.prev = current;
        node.next = current.next;
        current.next.prev = node;
        current.next = node;
        System.out.println(value + " inserted after " + target + ".");
    }

    public void insertBefore(int target, int value) {
        Node current = findNode(target);
        if (current == null) {
            System.out.println("Value " + target + " not found.");
            return;
        }
        if (current == head) {
            insertBeginning(value);
            return;
        }
        Node node = new Node(value);
        node.next = current;
        node.prev = current.prev;
        current.prev.next = node;
        current.prev = node;
        System.out.println(value + " inserted before " + target + ".");
    }

    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        int removed = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Deleted: " + removed);
    }

    public void deleteEnd() {
        if (tail == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        int removed = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Deleted: " + removed);
    }

    public void deleteAtPosition(int position) {
        int size = count();
        if (position < 1 || position > size) {
            System.out.println("Invalid position. List has " + size + " node(s).");
            return;
        }
        if (position == 1) {
            deleteBeginning();
            return;
        }
        if (position == size) {
            deleteEnd();
            return;
        }
        Node current = head;
        for (int i = 1; i < position; i++) current = current.next;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        System.out.println("Deleted: " + current.data);
    }

    public void deleteByValue(int value) {
        Node current = findNode(value);
        if (current == null) {
            System.out.println("Value " + value + " not found.");
            return;
        }
        if (current == head) {
            deleteBeginning();
        } else if (current == tail) {
            deleteEnd();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            System.out.println("Deleted first occurrence of " + value + ".");
        }
    }

    public void search(int value) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == value) {
                System.out.println(value + " found at position " + position + ".");
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println(value + " not found.");
    }

    public void update(int oldValue, int newValue) {
        Node current = findNode(oldValue);
        if (current == null) {
            System.out.println("Value " + oldValue + " not found.");
            return;
        }
        current.data = newValue;
        System.out.println("Updated " + oldValue + " to " + newValue + ".");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("NULL <- ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            if (current != null) System.out.print(" <-> ");
        }
        System.out.println(" -> NULL");
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("NULL <- ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data);
            current = current.prev;
            if (current != null) System.out.print(" <-> ");
        }
        System.out.println(" -> NULL");
    }

    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        for (Node current = head.next; current != null; current = current.next)
            if (current.data > max) max = current.data;
        System.out.println("Maximum value: " + max);
    }

    public void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int min = head.data;
        for (Node current = head.next; current != null; current = current.next)
            if (current.data < min) min = current.data;
        System.out.println("Minimum value: " + min);
    }

    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: " + slow.data + " (second middle for even-length lists).");
    }

    public void reverse() {
        Node current = head;
        while (current != null) {
            Node temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public void sort() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    Node duplicate = runner;
                    runner = runner.next;
                    if (duplicate.prev != null) duplicate.prev.next = duplicate.next;
                    if (duplicate.next != null) duplicate.next.prev = duplicate.prev;
                    if (duplicate == tail) tail = duplicate.prev;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    private Node findNode(int value) {
        Node current = head;
        while (current != null && current.data != value) current = current.next;
        return current;
    }
}
