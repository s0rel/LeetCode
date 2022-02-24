package com.leetcode.p0151;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        char[] charArray = s.toCharArray();
        int len = charArray.length;
        reverse(charArray, 0, len - 1);
        reverseWords(charArray, len);
        return cleanSpaces(charArray, len);
    }

    private void reverseWords(char[] arr, int len) {
        int i = 0, j = 0;
        while (i < len) {
            while (i < j || i < len && arr[i] == ' ') {
                i++;
            }
            while (j < i || j < len && arr[j] != ' ') {
                j++;
            }
            reverse(arr, i, j - 1);
        }
    }

    private String cleanSpaces(char[] arr, int len) {
        int i = 0, j = 0;
        while (j < len) {
            while (j < len && arr[j] == ' ') {
                j++;
            }
            while (j < len && arr[j] != ' ') {
                arr[i++] = arr[j++];
            }
            while (j < len && arr[j] == ' ') {
                j++;
            }
            if (j < len) {
                arr[i++] = ' ';
            }
        }
        return new String(arr).substring(0, i);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
