package ua.ithillel.jcf.algo;

public class StringCustomUtils {
    public static String reverse(String s) {
        // base case ""
        if (s.length() == 0) {
            return "";
        }

        // recursive case
        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }
}
