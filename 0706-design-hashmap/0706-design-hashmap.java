class MyHashMap {

    private class Node {
        int key;
        int value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Node[] buckets;
    private int capacity;
    private int size;
    private final double LOAD_FACTOR = 0.75;

    public MyHashMap() {
        capacity = 16;
        buckets = new Node[capacity];
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {
        int index = hash(key);

        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        Node node = new Node(key, value);
        node.next = buckets[index];
        buckets[index] = node;
        size++;

        if ((double) size / capacity >= LOAD_FACTOR) {
            rehash();
        }
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {

                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }

                size--;
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    private void rehash() {
        Node[] oldBuckets = buckets;

        capacity *= 2;
        buckets = new Node[capacity];
        size = 0;

        for (Node head : oldBuckets) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }
}