package Hashing;

public class Test {
    public static void main(String[] args) {
        // Create a new hash table
        HashTable hashTable = new HashTable();

        // Test inserting contacts
        System.out.println("Inserting Contacts:");
        hashTable.insert("Alice", "12345");
        hashTable.insert("Bob", "67890");
        hashTable.insert("Charlie", "11122");
        hashTable.insert("Dave", "33344");
        System.out.println();

        // Test searching for contacts
        System.out.println("Searching for Contacts:");
        hashTable.search("Alice");
        hashTable.search("Eve"); // Contact not in the hash table
        System.out.println();

        // Test updating a contact
        System.out.println("Updating Contacts:");
        hashTable.update("Bob", "99999");
        hashTable.search("Bob"); // Confirm the update
        hashTable.update("Eve", "55555"); // Contact not in the hash table
        System.out.println();

        // Test deleting contacts
        System.out.println("Deleting Contacts:");
        hashTable.delete("Charlie");
        hashTable.delete("Eve"); // Contact not in the hash table
        System.out.println();

        // Display all contacts in the hash table
        System.out.println("Displaying All Contacts:");
        hashTable.display();
    }
}
