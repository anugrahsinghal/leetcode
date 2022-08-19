class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        
        Predicate<Character> isInvalidChar = a -> {
            return (a < 'a' || a > 'z') && (a < '0' || a > '9') ;
        };
        
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            char a = s.charAt(i);
            if(isInvalidChar.test(a)) {
                i++;
                continue;
            }
            char b = s.charAt(j);
            if(isInvalidChar.test(b)) {
                j--;
                continue;
            }
            System.out.println(a +" == " + b + " ? -> " + (a == b) );
            
            if(a != b) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}