class Solution {
    // Set<String> op = Set.of("+","-","*","/");
    static Map<String, BiFunction<Integer, Integer, Integer>> op = new HashMap<>();
    static {
    op.put("+",(a,b) -> a+b);
    op.put("-",(a,b) -> a-b);
    op.put("*",(a,b) -> a*b);
    op.put("/",(a,b) -> a/b);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(var tok : tokens) {
            if(op.containsKey(tok)) {
                var first = (st.pop());
                var second = (st.pop());
                // second op first
                var ans = (int) op.get(tok).apply(second, first);
                st.push(ans);
            } else {
                st.push(Integer.parseInt(tok));
            }
        }
        return st.peek();
    }
}