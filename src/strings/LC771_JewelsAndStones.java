package strings;

import java.util.HashSet;

public class LC771_JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> hashSet = new HashSet<>(); // store jewel characters
        int count = 0;                                // count jewels in stones

        for (int i = 0; i < jewels.length(); i++) {
            hashSet.add(jewels.charAt(i));            // add each jewel to set
        }

        for (int i = 0; i < stones.length(); i++) {
            if (hashSet.contains(stones.charAt(i))) { // check if stone is a jewel
                count++;                              // increase count
            }
        }

        return count;                                 // return total jewels
    }

}
