package org.sorel.leetcode.p0125;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(charArray[i])) {
                i++;
            } else if (!Character.isLetterOrDigit(charArray[j])) {
                j--;
            } else if (Character.toLowerCase(charArray[i++]) != Character.toLowerCase(charArray[j--])) {
                return false;
            }
        }
        return true;
    }
}
