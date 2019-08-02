package ByteDance;

public class StringArrangement {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;

        boolean isContains = false;

        for(int start = 0; (start + s1.length()) <= s2.length(); start++){
            isContains = isContains(s1, s2.substring(start, start + s1.length()));
            if(isContains)
                return isContains;
        }

        return isContains;
    }

    private boolean isContains(String source, String target){
        int []arr  = new int[26];
        if(target.length() < source.length())
            return false;
        for(int i = 0; i < source.length(); i++)
            arr[source.charAt(i) - 'a']++;

        for(int i = 0; i < target.length(); i++)
            arr[target.charAt(i) - 'a']--;

        boolean isContains = true;

        for(int i : arr){
            if(i != 0){
                isContains = false;
                break;
            }
        }
        return isContains;
    }
}
