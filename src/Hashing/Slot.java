package Hashing;

//The linked list for chaining
public class Slot {
    private Node head;
    private Node tail;

    public boolean insert(String name, String number) {

        // Handling excepted input error from the User
        if (name == null || number == null) {
            return false;
        }

        Node newNode = new Node(name, number);
        // if the slot is empty 'There is no collision'
        if (isEmpty()) {
            this.head = this.tail = newNode;

            // if there is a collision
        } else {
            this.tail.next = newNode;
            this.tail = this.tail.next;
        }

        return true;
    }

    public boolean delete(String name) {

        if (isEmpty() || name == null) {
            return false;
        }

        if (head.name.equals(name)) {
            head = head.next;
            // Update the tail if the list becomes empty
            if (head == null) {
                tail = null;
            }
            return true;
        }

        Node temp = head;
        // Traverse through the list searching for the node to delete
        while (temp.next != null) {
            if (temp.next.name.equals(name)) {
                // Update the tail if deleting the last node
                if (temp.next == tail) {
                    tail = temp;
                }
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean search(String name) {
        // Check if the name is null or the list is empty
        if (name == null || isEmpty()) {
            return false;
        }

        Node temp = head;
        // Traverse through the list searching for the node
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return true; // Found the contact
            }
            temp = temp.next;
        }

        return false; // Contact not found
    }


    public String findNumber(String name) {
        // Check if the name is null or the list is empty
        if (name == null || isEmpty()) {
            return null;
        }

        Node temp = head;
        // Traverse through the list searching for the node
        while (temp != null) {
            // Use ignore-case comparison to match the name
            if (temp.name.equalsIgnoreCase(name)) {
                return temp.phoneNumber; // Return the phone number if the contact is found
            }
            temp = temp.next;
        }

        return null; // Return null if contact is not found
    }

    public boolean update(String name, String newNumber) {
        if (isEmpty() || name == null) {
            return false;
        }

        Node temp = head;
        // Traverse throw the list searching for the node to delete
        while (temp != null) {
            if (temp.name.equals(name)) {
                temp.phoneNumber = newNumber;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public void Display() {
        if (!isEmpty()) {
            Node temp = head;
            while (temp.next != null) {
                System.out.print("{ " + temp.name + " , " + temp.phoneNumber + " } -> ");
                temp = temp.next;
            }
            System.out.println("{ " + temp.name + " , " + temp.phoneNumber + " } ");
        }
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }


    private class Node {
        // The data fields of each contact
        private String name;
        private String phoneNumber;
        protected Node next;

        public Node(String name, String number) {
            this.name = name;
            this.phoneNumber = number;
            this.next = null;
        }
    }
}
