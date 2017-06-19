package algorithm.LongestPalindromicSubstring;

/**
 * Created by jihun.im on 2017-05-12.
 */
public class LongestPalindromicSubstringMain {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("abcbaa"));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        for (int i = 1; i < s.length()-1; i++) {
            for (int j = 1; j < s.length(); j++) {
                isPalindrome(s.substring(i-j,i+j));
            }
        }
        return "";
    }

    public boolean isPalindrome(String s) {
        String temp = s;
        while (temp.length() >= 2) {
            if (temp.charAt(temp.length() - 1) == temp.charAt(0)) {
                temp = temp.substring(1, temp.length() - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}