package strings;

public class LC125_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0;                    // left pointer
        int right = s.length() - 1;      // right pointer

        while (left < right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);

            if (!isAlphaNumeric(c1)) {   // skip non-alphanumeric from left
                left++;
                continue;
            }
            if (!isAlphaNumeric(c2)) {   // skip non-alphanumeric from right
                right--;
                continue;
            }

            if (normalizeChar(c1) != normalizeChar(c2)) { // compare normalized chars
                return false;
            }

            left++;                      // move left pointer
            right--;                     // move right pointer
        }

        return true;                     // all checks passed → palindrome
    }

    public static boolean isAlphaNumeric(char c) {
        return (c >= '0' && c <= '9') || // digit
                (c >= 'a' && c <= 'z') || // lowercase letter
                (c >= 'A' && c <= 'Z');   // uppercase letter
    }

    public static char normalizeChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 32);       // convert uppercase to lowercase
        }
        return c;                        // return as is
    }

}
