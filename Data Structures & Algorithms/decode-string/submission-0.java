class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                countStack.push(number);
                stringStack.push(current);

                current = new StringBuilder();
                number = 0;
            } 
            else if (ch == ']') {
                int count = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < count; i++) {
                    previous.append(current);
                }

                current = previous;
            } 
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}