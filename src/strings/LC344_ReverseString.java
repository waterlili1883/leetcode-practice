package strings;

public class LC344_ReverseString {

    public void reverseString(char[] s) {
        int i = 0;                   // left pointer
        int j = s.length - 1;        // right pointer

        while (i < j) {              // loop until pointers meet
            char temp = s[i];             // swap characters
            s[i] = s[j];
            s[j] = temp;
            i++;                     // move left pointer forward
            j--;                     // move right pointer backward
        }
    }
}
