class LFUCache {

    private final int capacity;
    private int minFreq;

    private Map<Integer, Node> keyMap;
    private Map<Integer, LinkedHashSet<Node>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);
        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            increaseFrequency(node);
            return;
        }

        if (keyMap.size() == capacity) {
            LinkedHashSet<Node> minFreqSet = freqMap.get(minFreq);
            Node nodeToRemove = minFreqSet.iterator().next();

            minFreqSet.remove(nodeToRemove);
            keyMap.remove(nodeToRemove.key);
        }

        Node newNode = new Node(key, value);
        keyMap.put(key, newNode);

        freqMap.putIfAbsent(1, new LinkedHashSet<>());
        freqMap.get(1).add(newNode);

        minFreq = 1;
    }

    private void increaseFrequency(Node node) {
        int oldFreq = node.freq;

        LinkedHashSet<Node> oldSet = freqMap.get(oldFreq);
        oldSet.remove(node);

        if (oldFreq == minFreq && oldSet.isEmpty()) {
            minFreq++;
        }

        node.freq++;

        freqMap.putIfAbsent(node.freq, new LinkedHashSet<>());
        freqMap.get(node.freq).add(node);
    }

    static class Node {
        int key;
        int value;
        int freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */