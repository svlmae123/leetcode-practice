class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxlength=0;
        HashSet<Character> set= new HashSet<>();

        for(int right=0; right<s.length(); right++) {

            Character current = s.charAt(right);

            while(set.contains(current)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(current);
            maxlength = Math.max(maxlength, right - left + 1);
        }
        return maxlength;
        
    }
}