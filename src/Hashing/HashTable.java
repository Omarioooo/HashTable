package Hashing;

public class HashTable {
    private final int table_size = 1009;
    private Slot[] slots;

    public HashTable() {
        this.slots = new Slot[table_size];
    }

    public void insert(String name, String number) {
        int index = calc_hash(name);

        // Initializing the slot
        if (slots[index] == null) {
            slots[index] = new Slot();
        }

        boolean isInserted = slots[index].insert(name, number);

        // Check if inserted correctly
        if (isInserted) {
            System.out.println("The contact { " + name + " , " + number + " } is inserted successfully... :)");
        } else {
            System.out.println("Plz add a correct name and number.... :(");
        }
    }

    public void delete(String name) {
        int index = calc_hash(name);

        if (slots[index] == null) {
            System.out.println("The slot[" + (index + 1) + "] is empty");
            return;
        }

        // Getting the old number before deleting
        String deletedNumber = slots[index].findNumber(name);
        boolean isDeleted = slots[index].delete(name);

        // Check if deleted correctly
        if (isDeleted) {
            System.out.println("The contact { " + name + " , " + deletedNumber + " } is deleted successfully... :)");
        } else {
            System.out.println("The contact {" + name + "} is not found");
        }
    }


    public void search(String name) {
        int index = calc_hash(name);

        if (slots[index] == null) {
            System.out.println("The slot[" + (index + 1) + "] is empty so not founded");
            return;
        }

        boolean isFound = slots[index].search(name);

        // Check if found correctly
        if (isFound) {
            System.out.println("The contact { " + name + " , " + slots[index].findNumber(name) + " } is into slot[" + index + "]... :)");
        } else {
            System.out.println("The contact {" + name + "} is not found");
        }
    }

    public void update(String name, String number) {
        int index = calc_hash(name);

        if (slots[index] == null) {
            System.out.println("The slot[" + (index + 1) + "] is empty so The contact {" + name + "} is not found");
            return;
        }

        // Getting the old number before updating
        String oldNumber = slots[index].findNumber(name);
        boolean isFound = slots[index].update(name, number);

        // Check if found & updated correctly
        if (isFound) {
            System.out.println("The contact { " + name + " , " + oldNumber + " } now is ---> { " + name + " , " + number + " }... :)");
        } else {
            System.out.println("The contact {" + name + "} is not found");
        }

    }

    public void display() {
        for (int i = 0; i < table_size; i++) {
            if (slots[i] != null && !slots[i].isEmpty()) {
                System.out.println("Contacts on slot[" + (i + 1) + "] : ");
                slots[i].Display();
                System.out.println();
            }
        }
    }

    // Hash function to find the index
    private int calc_hash(String key) {
        int keyLength = key.length();
        int hashValue = 0;
        for (int i = 0; i < keyLength; i++) {
            hashValue += Character.getNumericValue(key.charAt(i));
            hashValue += (hashValue << 10);
            hashValue ^= (hashValue >> 6);
        }
        hashValue += (hashValue << 3);

        if (hashValue > 0) return hashValue % table_size;
        else return -hashValue % table_size;
    }
}

