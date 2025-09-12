package strings;

public class LC58_LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int length = 0;                  // length of the last word
        int i = s.length() - 1;          // start from the last index

        while (i >= 0 && s.charAt(i) == ' ') { // skip trailing spaces
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') { // count characters of last word
            length++;
            i--;
        }

        return length;
    }
}
