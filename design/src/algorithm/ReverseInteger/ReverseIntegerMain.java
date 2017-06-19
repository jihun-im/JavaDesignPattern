package algorithm.ReverseInteger;

/**
 * Created by jihun.im on 2017-05-12.
 */
public class ReverseIntegerMain {
    public static void main(String[] args) {
        //System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse2(1234));
    }
}

class Solution {
    //char recognition
    public int reverse(int x) {
        //System.out.println(String.valueOf(x).toCharArray());
        char[] inputCharArray = String.valueOf(x).toCharArray();
        char[] outputCharArray = new char[inputCharArray.length];

        if (inputCharArray[0] == '-') {
            outputCharArray[0] = '-';
            for (int i = 1; i < inputCharArray.length; i++) {
                outputCharArray[inputCharArray.length - i] = inputCharArray[i];
            }
        } else {
            for (int i = 0; i < inputCharArray.length; i++) {
                outputCharArray[inputCharArray.length - i - 1] = inputCharArray[i];
            }
        }
        try {
            int reversedInt = Integer.parseInt(String.valueOf(outputCharArray));

            return reversedInt;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    //using int only
    public int reverse2(int x) {
        int result = 0;
        int formerResult;
        while (x != 0) {
            formerResult = result;
            result = result*10 + x%10;
            x = x/10;
            if(result/10 != formerResult) {
                return 0;
            }
        }
        return result;
    }
}