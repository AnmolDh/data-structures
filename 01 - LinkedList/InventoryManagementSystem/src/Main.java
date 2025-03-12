public class Main {
    public static void main(String[] args) {
        ItemLinkedList inventory = new ItemLinkedList();

        inventory.addItemAtBeginning(new Item("Laptop", 101, 10, 1200.0));
        inventory.addItemAtEnd(new Item("Mouse", 102, 50, 25.0));
        inventory.addItemAtPosition(new Item("Keyboard", 103, 30, 50.0), 2);

        System.out.println("All Items:");
        inventory.displayInventory();

        System.out.println("\nSearching for Item ID 102:");
        inventory.searchById(102);

        System.out.println("\nSearching for Item Name 'Keyboard':");
        inventory.searchByName("Keyboard");

        System.out.println("\nUpdating quantity of Item ID 101 to 15:");
        inventory.updateQuantity(101, 15);
        inventory.displayInventory();

        System.out.println("\nCalculating total value of inventory:");
        inventory.calculateTotalValue();

        System.out.println("\nSorting inventory by Item Name (ascending):");
        inventory.sortByName(true);
        inventory.displayInventory();

        System.out.println("\nSorting inventory by Price (descending):");
        inventory.sortByPrice(false);
        inventory.displayInventory();

        System.out.println("\nRemoving Item ID 102:");
        inventory.removeItemById(102);
        inventory.displayInventory();
    }
}