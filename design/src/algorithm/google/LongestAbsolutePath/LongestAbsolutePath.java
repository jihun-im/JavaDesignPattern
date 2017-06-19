package algorithm.google.LongestAbsolutePath;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by jihun.im on 2017-06-19.
 */
public class LongestAbsolutePath {
    public static String testString = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

    public static void main(String[] args) {
        System.out.println("Result: " + getLongestAbsolutePath(testString));
    }

    public static int getLongestAbsolutePath(String path) {
        Stack<String> stringStack = new Stack<String>();
        int tabs = 0;
        int tabsOld = 0;
        int diff = 0;
        int maxLength = 0;
        int currentLength = 0;
        for (String leafString : path.split("\n")) {

            // get how many tabs are in the current string
            tabs = getTheNumberOfTabs(leafString);
            // remove tabs
            leafString = leafString.substring(tabs, leafString.length());

            diff = tabs - tabsOld;
            if (diff == 0) {  // first item or sibling item
                if (!stringStack.empty()) { //if it is sibling item
                    stringStack.pop();  //then, pop one
                }
                stringStack.push(leafString);
            } else if (diff > 0) { // child item
                stringStack.push(leafString);
            } else { // parent item or parent's parent item or ...
                for (int i = diff; i < 0; i++) { // pop as many
                    stringStack.pop();
                }
                stringStack.pop();
                stringStack.push(leafString);
            }

            // get current length from stack
            currentLength = getStringLengthInStack(stringStack);

            // update max length value
            if (maxLength < currentLength) {
                maxLength = currentLength;
            }

            // save tabs for later use on stack
            tabsOld = tabs;
        }
        return maxLength;
    }

    public static int getStringLengthInStack(Stack<String> stack) {
        int lengthSum = 0;
        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            lengthSum += it.next().length();
        }
        lengthSum = lengthSum + stack.size() - 1; // add slash count
        return lengthSum;
    }


    public static int getTheNumberOfTabs(String string) {
        int count = 0;
        while (true) {
            if (string.startsWith("\t")) {
                string = string.substring(1, string.length());
                count++;
            } else {
                break;
            }
        }
        return count;
    }


}
