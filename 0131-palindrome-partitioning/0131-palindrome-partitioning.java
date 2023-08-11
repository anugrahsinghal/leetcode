class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    void partition(String s, int startIndex, List<String> ds, List<List<String>> ans) {
        if(0 == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // i is partition index
        for(int i = startIndex; i < s.length(); i++) { 
            var prefix = s.substring(startIndex, i+1);
            if(isPalindrome(prefix)) {
                ds.add(prefix);
                partition(s.substring(i+1), 0, ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
    }

    boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while(start <= end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start += 1;
            end   -= 1;
        }
        return true;
    }

    void swap(char[] arr, int i1, int i2) {
        char temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}