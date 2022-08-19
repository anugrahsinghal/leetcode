class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        
        Predicate<Character> isInvalidChar = a -> {
            return (a < 'a' || a > 'z') && (a < '0' || a > '9') ;
        };
        
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while(i <= j) {
            char a = arr[i];//s.charAt(i);
            if(isInvalidChar.test(a)) {
                i++;
                continue;
            }
            char b = arr[j];//s.charAt(j);
            if(isInvalidChar.test(b)) {
                j--;
                continue;
            }
            
            if(a != b) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}