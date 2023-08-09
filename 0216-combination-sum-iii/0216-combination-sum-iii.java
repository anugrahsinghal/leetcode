class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1,k,target, new ArrayList<>(), ans);

        return ans;
    }

    void helper(int start, int k, int target, List<Integer> ds, List<List<Integer>> ans) {
        if(ds.size() == k && target == 0) {
            ans.add(new ArrayList<>(ds));
        } 
        if(ds.size() == k && target != 0) return;
        if(ds.size() != k && target == 0) return;

        for(int i = start; i <= 9; i++) {
            if(i > target) return;
            ds.add(i);
            helper(i+1, k, target-i, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}