package StringAlgo;

import java.util.HashSet;
import java.util.Set;

public class StringFuncs {
    private final static String[] MORSE_MAP = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
            ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    private static void swap(char[] arr, int l, int r){
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

    private static String translateWordIntoMorse(String word){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < word.length(); i++)
            builder.append(MORSE_MAP[word.charAt(i) - 'a']);
        return builder.toString();
    }

    public static int uniqueMorseRepresentations(String[] words){
        Set<String> calculateSet = new HashSet<>();

        for(String word: words)
            calculateSet.add(translateWordIntoMorse(word));

        return calculateSet.size();
    }

    public static String toLowerCase(String str){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z')
                ch -= 'A' - 'a';
        builder.append(ch);
    }
        return builder.toString();
    }

    public static int compareVersion(String version1, String version2) {
        String[] preVersionArr = version1.split("\\.");
        String[] nxtVersionArr = version2.split("\\.");

        for(int i = 0, j = 0; i <Math.min(preVersionArr.length, nxtVersionArr.length); i++, j++){
            if(i < preVersionArr.length && j < nxtVersionArr.length){
                int pre = Integer.parseInt(preVersionArr[i]);
                int nxt = Integer.parseInt(nxtVersionArr[j]);

                if(pre > nxt)
                    return 1;

                if(pre < nxt)
                    return -1;
            }
        }

        if(preVersionArr.length == nxtVersionArr.length)
            return 0;
        else{
            if(preVersionArr.length > nxtVersionArr.length){
                for(int i = nxtVersionArr.length; i < preVersionArr.length; i++){
                    if(Integer.parseInt(preVersionArr[i]) != 0)
                        return 1;
                }
                return 0;
            }
            else{
                for(int i = preVersionArr.length; i < nxtVersionArr.length; i++){
                    if(Integer.parseInt(nxtVersionArr[i]) != 0)
                        return -1;
                }
                return 0;
            }
        }
    }
}
