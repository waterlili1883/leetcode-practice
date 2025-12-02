package arrays;

public class LC1672_RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0; // global maximum wealth found so far

        // Iterate over each customer
        for (int i = 0; i < accounts.length; i++) {
            int currentWealth = 0; // wealth of the current customer

            // Sum all accounts for this customer
            for (int j = 0; j < accounts[i].length; j++) {
                currentWealth += accounts[i][j];
            }

            // Update the maximum wealth if current customer is richer
            maxWealth = Math.max(maxWealth, currentWealth);
        }

        return maxWealth;
    }
}
