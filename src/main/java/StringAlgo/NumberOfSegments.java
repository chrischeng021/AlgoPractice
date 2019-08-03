package StringAlgo;

// This question is really fucking stupid.

public class NumberOfSegments {
    public int countSegments(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int segmentCount = s.charAt(0) != ' ' ? 1 : 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i-1) == ' ' && s.charAt(i) != ' ') {
                ++segmentCount;
            }
        }

        return segmentCount;
    }
}
