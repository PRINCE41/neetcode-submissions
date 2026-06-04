class FreqStack {

    private Map<Integer, Integer> freq;
    private Map<Integer, Deque<Integer>> group;
    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int newFreq = freq.getOrDefault(val, 0) + 1;
        freq.put(val, newFreq);

        group
            .computeIfAbsent(newFreq, k -> new ArrayDeque<>())
            .push(val);

        maxFreq = Math.max(maxFreq, newFreq);
    }

    public int pop() {
        Deque<Integer> stack = group.get(maxFreq);

        int val = stack.pop();

        freq.put(val, freq.get(val) - 1);

        if (stack.isEmpty()) {
            group.remove(maxFreq);
            maxFreq--;
        }

        return val;
    }
}