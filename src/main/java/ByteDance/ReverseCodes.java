package ByteDance;

public class ReverseCodes {
    // 使用了原地交换的解法，空间复杂度O(1)
    // 如果牺牲空间直接Split后再reverse，可继续提高性能
    // 就懒得写了
    public String reverseWords(String s) {
        char[] arr = toTrimCharArray(s);
        int start = 0;
        int end = 0;
        while (start < arr.length && (end - 1) < arr.length) {
            if (end < arr.length && arr[end] != ' ') {
                end++;
            } else {
                reverseArray(arr, start, end - 1);
                start = ++end;
            }
        }
        reverseArray(arr, 0, arr.length - 1);
        return String.valueOf(arr);
    }

    private void reverseArray(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] arr, int left, int end) {
        char ch = arr[left];
        arr[left] = arr[end];
        arr[end] = ch;
    }

    private char[] toTrimCharArray(String str) {
        StringBuilder buffer = new StringBuilder();
        char pre = '\0';
        char cur = '\0';
        for (int i = 0; i < str.length(); i++) {
            cur = str.charAt(i);
            if (cur == ' ' && (pre == ' ' || pre == '\0'))
                continue;
            else {
                pre = cur;
            }
            buffer.append(cur);
        }
        return buffer.toString().trim().toCharArray();
    }
}
