class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        helper(0, digits, new ArrayList<>(), ans);

        return ans;
    }

    void helper(int pickIndex, String digits, List<String> ds, List<String> ans) {

        if(digits.length() == pickIndex) {
            ans.addAll(ds);
            return;
        }

        int num = Integer.parseInt("" + digits.charAt(pickIndex));// 2 -- 3
        List<String> newds = new ArrayList<>();
        
        for(String value : t9Values.get(num)) {// a,b,c -- d,e,f
            if(pickIndex == 0) {
                newds.add(value);//a,b,c
            } else {
                for(String item : ds) { // a
                    newds.add(item + value);
                }
            }
        }

        helper(pickIndex + 1, digits, newds, ans);
        
    }

    
    static Map<Integer, List<String>> t9Values = new HashMap<>();
    static {
        t9Values.put(2, Arrays.asList("a", "b", "c"));
        t9Values.put(3, Arrays.asList("d", "e", "f"));
        t9Values.put(4, Arrays.asList("g", "h", "i"));
        t9Values.put(5, Arrays.asList("j", "k", "l"));
        t9Values.put(6, Arrays.asList("m", "n", "o"));
        t9Values.put(7, Arrays.asList("p", "q", "r", "s"));
        t9Values.put(8, Arrays.asList("t", "u", "v"));
        t9Values.put(9, Arrays.asList("w", "x", "y", "z"));
    }
}
