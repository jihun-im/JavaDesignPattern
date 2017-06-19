package algorithm.PalindromeNumber;

/**
 * Created by jihun.im on 2017-05-12.
 */
public class PalindromeNumberMain {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1100));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x!=0&&x%10==0)) return false;
        int rightSideReversed = 0;
        while (x > rightSideReversed) {
            rightSideReversed = rightSideReversed * 10 + x % 10;
            x = x / 10;
        }

        return rightSideReversed == x || rightSideReversed / 10 == x;
    }
}