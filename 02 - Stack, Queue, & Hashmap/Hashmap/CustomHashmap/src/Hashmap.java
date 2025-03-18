public class Hashmap {
    private Entry[] table;
    private int capacity = 4;

    public Hashmap(){
        table = new Entry[capacity];
    }

    private int hash(Integer key){
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(Integer newKey, Integer data){
        if (newKey == null){
            return;
        }

        int hash = hash(newKey);

        Entry newEntry = new Entry(newKey, data);

        if (table[hash] == null){
            table[hash] = newEntry;
        }
        else{
            Entry previous = null;
            Entry current = table[hash];

            while (current != null){
                if (current.getKey() == newKey){
                    if (previous == null){
                        newEntry.setNext(current.getNext());
                        table[hash] = newEntry;
                        return;
                    }
                }
                else{
                    newEntry.setNext(current.getNext());
                    previous.setNext(newEntry);
                    return;
                }
                previous = current;
                current.setNext(current.getNext());
            }
            previous.setNext(newEntry);
        }
    }

    public Integer get(Integer key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else{
            Entry temp = table[hash];
            while(temp!= null){
                if(temp.getKey() == key) {
                    return temp.getValue();
                }
                temp = temp.getNext();
            }
            return null;
        }
    }
}
