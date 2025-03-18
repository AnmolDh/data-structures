public class Entry {
    private Integer key;
    private Integer value;
    private Entry next;

    public Entry(Integer key, Integer value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public int getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
    public Entry getNext() {
        return next;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setNext(Entry next) {
        this.next = next;
    }
}
