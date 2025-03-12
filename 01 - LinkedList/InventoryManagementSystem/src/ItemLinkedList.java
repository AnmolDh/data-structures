public class ItemLinkedList {
    private ItemListNode head;

    public ItemLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addItemAtBeginning(Item item) {
        ItemListNode newItem = new ItemListNode(item);
        if (isEmpty()) {
            head = newItem;
        } else {
            newItem.setNext(head);
            head = newItem;
        }
    }

    public void addItemAtEnd(Item item) {
        ItemListNode newItem = new ItemListNode(item);
        if (isEmpty()) {
            head = newItem;
        } else {
            ItemListNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newItem);
        }
    }

    public void addItemAtPosition(Item item, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position should be >= 1.");
            return;
        }
        if (position == 1) {
            addItemAtBeginning(item);
        } else {
            ItemListNode newItem = new ItemListNode(item);
            ItemListNode temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.getNext();
                if (temp == null) {
                    System.out.println("Position out of range.");
                    return;
                }
            }
            newItem.setNext(temp.getNext());
            temp.setNext(newItem);
        }
    }

    public void removeItemById(int itemId) {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.getItem().getItemId() == itemId) {
            head = head.getNext();
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }
        ItemListNode temp = head;
        ItemListNode prev = null;
        while (temp != null && temp.getItem().getItemId() != itemId) {
            prev = temp;
            temp = temp.getNext();
        }
        if (temp == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            prev.setNext(temp.getNext());
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        ItemListNode temp = head;
        while (temp != null) {
            if (temp.getItem().getItemId() == itemId) {
                temp.getItem().setQuantity(newQuantity);
                System.out.println("Quantity updated for Item ID " + itemId + ".");
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void searchById(int itemId) {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        ItemListNode temp = head;
        while (temp != null) {
            if (temp.getItem().getItemId() == itemId) {
                System.out.println("Item found: " + temp);
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void searchByName(String itemName) {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        ItemListNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.getItem().getItemName().equalsIgnoreCase(itemName)) {
                System.out.println("Item found: " + temp);
                found = true;
            }
            temp = temp.getNext();
        }
        if (!found) {
            System.out.println("Item with name " + itemName + " not found.");
        }
    }

    public void calculateTotalValue() {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        double totalValue = 0;
        ItemListNode temp = head;
        while (temp != null) {
            totalValue += temp.getItem().getQuantity() * temp.getItem().getPrice();
            temp = temp.getNext();
        }
        System.out.println("Total value of inventory: " + totalValue);
    }

    public void sortByName(boolean ascending) {
        if (isEmpty() || head.getNext() == null) {
            System.out.println("Inventory is empty or has only one item.");
            return;
        }
        head = mergeSort(head, true, ascending);
        System.out.println("Inventory sorted by Item Name (" + (ascending ? "ascending" : "descending") + ").");
    }

    public void sortByPrice(boolean ascending) {
        if (isEmpty() || head.getNext() == null) {
            System.out.println("Inventory is empty or has only one item.");
            return;
        }
        head = mergeSort(head, false, ascending);
        System.out.println("Inventory sorted by Price (" + (ascending ? "ascending" : "descending") + ").");
    }

    private ItemListNode mergeSort(ItemListNode head, boolean sortByName, boolean ascending) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ItemListNode middle = getMiddle(head);
        ItemListNode nextOfMiddle = middle.getNext();
        middle.setNext(null);
        ItemListNode left = mergeSort(head, sortByName, ascending);
        ItemListNode right = mergeSort(nextOfMiddle, sortByName, ascending);
        return merge(left, right, sortByName, ascending);
    }

    private ItemListNode getMiddle(ItemListNode head) {
        if (head == null) {
            return head;
        }
        ItemListNode slow = head;
        ItemListNode fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private ItemListNode merge(ItemListNode left, ItemListNode right, boolean sortByName, boolean ascending) {
        ItemListNode result = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (sortByName) {
            if ((ascending && left.getItem().getItemName().compareTo(right.getItem().getItemName()) <= 0) || (!ascending && left.getItem().getItemName().compareTo(right.getItem().getItemName()) >= 0)) {
                result = left;
                result.setNext(merge(left.getNext(), right, sortByName, ascending));
            } else {
                result = right;
                result.setNext(merge(left, right.getNext(), sortByName, ascending));
            }
        } else {
            if ((ascending && left.getItem().getPrice() <= right.getItem().getPrice()) || (!ascending && left.getItem().getPrice() >= right.getItem().getPrice())) {
                result = left;
                result.setNext(merge(left.getNext(), right, sortByName, ascending));
            } else {
                result = right;
                result.setNext(merge(left, right.getNext(), sortByName, ascending));
            }
        }
        return result;
    }

    public void displayInventory() {
        if (isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        ItemListNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}
