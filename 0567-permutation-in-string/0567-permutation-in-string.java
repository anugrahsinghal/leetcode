class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int ws = s1.length();
        
        var ms1 = freq(s1);//[a=1,b=1]
        var ms2 = freq(s2.substring(0, ws));//[]
        var matches = 0;
        for(int i = 0; i < 26; i++) { 
            if(ms1[i] == ms2[i]) {
                matches++;
            }
        }
        
        //
        // 012
        // ab
        // 01234567
        // eidboaoo
        //  ij   
        // ws = 3
        // 8-3 = 5
        // matches = 22
        int i = 0;
        int j = s1.length();
        while(j < s2.length()) {
            if(matches == 26) {
                return true;
            }
            
            int index = s2.charAt(j) - 'a';
            ms2[index]++;
            if(ms1[index] == ms2[index]) {
                matches++;
            } else if (ms1[index] == ms2[index] - 1) {
                // if due to ms2[]
                matches--;
            }
            
            index = s2.charAt(i) - 'a';
            ms2[index]--;
            if(ms1[index] == ms2[index]) {
                matches++;
            } else if (ms1[index] == ms2[index] + 1) {
                matches--;
            }
            
            j++;
            i++;
            // System.out.println(Arrays.toString(ms2));
        }

        return matches == 26;
        // 2 maps of 26 chars
        // 1 matches variable
        // when matches == 26 then we have a valid window
        // go by size of s1
    }
    int[] freq(String s1) {
        var freq = new int[26];
        int n = s1.length();
        for(int i = 0; i < n; i++) { 
            freq[s1.charAt(i) - 'a']++;
        }
        return freq;
    }
}