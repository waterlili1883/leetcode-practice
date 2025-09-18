package strings;

import java.util.HashSet;

public class LC345_ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        // store all vowels (both lowercase and uppercase)
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add('a'); hashSet.add('e'); hashSet.add('i'); hashSet.add('o'); hashSet.add('u');
        hashSet.add('A'); hashSet.add('E'); hashSet.add('I'); hashSet.add('O'); hashSet.add('U');

        int left = 0;                   // left pointer
        int right = s.length() - 1;     // right pointer
        char[] charArray = s.toCharArray(); // convert string to char array for in-place modification

        while (left < right) {
            if (!hashSet.contains(charArray[left])) {       // skip non-vowel from left
                left++;
            } else if (!hashSet.contains(charArray[right])) { // skip non-vowel from right
                right--;
            } else {
                // both are vowels → swap
                char c = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = c;
                left++;   // move left pointer
                right--;  // move right pointer
            }
        }

        return new String(charArray);  // return modified string
    }

}
