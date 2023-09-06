class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ds = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        ds.add("(");
        helper(1, 0, ds, ans, n);

        return ans;
    }

    void helper(int open, int close, List<String> ds, List<String> ans,  int N) {
        if(open > N || close > N) return;
        if(close > open) return;

        // System.out.println(String.join("", ds) +  "         -o-" + open + "-c-" + close);
        if(ds.size() == N*2 && open == close && open == N) {
            ans.add(String.join("", ds));
            return;
        }
        ds.add("(");
        helper(open+1, close, ds, ans, N);
        ds.remove(ds.size() - 1);
        ds.add(")");
        helper(open, close+1, ds, ans, N);
        ds.remove(ds.size() - 1);
    }
}