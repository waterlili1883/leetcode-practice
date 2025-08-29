package arrays;

public class LC415_AddStrings {
    /**
     * Adds two non-negative integers represented as strings.
     * Cannot use built-in BigInteger or convert directly to int.
     * This method simulates the addition digit by digit.
     */
    public String addStrings(String num1, String num2) {
        // Start from the last digit of both strings
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        // Variable to store carry during addition
        int carry = 0;
        // Use StringBuilder to build the result in reverse order
        StringBuilder sb = new StringBuilder();

        // Loop until both strings are fully traversed and no carry remains
        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            // Take current digit from num1 if available, otherwise 0
            int digitA = n1 >= 0 ? num1.charAt(n1--) - '0' : 0;
            // Take current digit from num2 if available, otherwise 0
            int digitB = n2 >= 0 ? num2.charAt(n2--) - '0' : 0;

            // Sum of current digits plus carry
            int sum = digitA + digitB + carry;

            // Append the last digit of sum to result
            sb.append(sum % 10);

            // Update carry (either 0 or 1)
            carry = sum / 10;
        }

        // Reverse the result to get the correct order
        return sb.reverse().toString();
    }
}
