public class ItemListNode {
    private Item item;
    private ItemListNode next;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemListNode getNext() {
        return next;
    }

    public void setNext(ItemListNode next) {
        this.next = next;
    }

    public ItemListNode(Item item) {
        this.item = item;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Item ID: " + item.getItemId() + ", Item Name: " + item.getItemName() + ", Quantity: " + item.getQuantity() + ", Price: " + item.getPrice();
    }
}
