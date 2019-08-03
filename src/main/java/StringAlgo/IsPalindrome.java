package StringAlgo;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder buffer = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i)))
                buffer.append(s.charAt(i));
        }

        String formattedStr = buffer.toString().toLowerCase();

        for(int l = 0, r = formattedStr.length() - 1; l < r; l++, r--){
            if(formattedStr.charAt(l) != formattedStr.charAt(r))
                return false;
        }

        return true;
    }
}
