class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for (String op : operations) {
            if (op.equals("+")){
                int last = st.pop();
                int secLast = st.peek();
                st.push(last);
                st.push(last + secLast);
            }
            else if(op.equals("D")){
                st.push(2 * st.peek());
            }
            else if(op.equals("C")){
                st.pop();
            }
            else {
                st.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for(int score: st){
            sum += score;
        }
        return sum;
    }
}