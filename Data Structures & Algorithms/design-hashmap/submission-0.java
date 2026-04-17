class MyHashMap {

    // Node for linked list
    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private int size = 1000; // bucket size

    public MyHashMap() {
        buckets = new Node[size];
    }

    // Hash function
    private int hash(int key) {
        return key % size;
    }

    // PUT operation
    public void put(int key, int value) {
        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // update existing
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }

        curr.next = new Node(key, value); // insert new
    }

    // GET operation
    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1;
    }

    // REMOVE operation
    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next; // remove head
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}