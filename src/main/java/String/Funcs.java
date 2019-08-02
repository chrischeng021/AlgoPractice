package String;

public class Funcs {
    public static void swap(char[] arr, int l, int r){
        char ch = arr[l];
        arr[l] = arr[r];
        arr[r] = ch;
    }

    public static void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while(l < r){
            swap(s, l++, r--);
        }
    }

    public static int firstUniqChar(String s) {
        s = s.toLowerCase();
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(arr[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
