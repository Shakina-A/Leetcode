class MyHashMap {
    private static final int SIZE = 10000;
    private LinkedList<Node>[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
            buckets[index].add(new Node(key, value));
        } else {
            for (Node node : buckets[index]) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
            }
            buckets[index].add(new Node(key, value));
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) return -1;
        for (Node node : buckets[index]) {
            if (node.key == key) return node.value;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) return;
        Iterator<Node> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                iterator.remove();
                return;
            }
        }
    }

    private static class Node {
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
