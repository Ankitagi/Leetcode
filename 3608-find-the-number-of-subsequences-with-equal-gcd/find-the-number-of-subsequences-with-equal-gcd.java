class Solution {
         private static final int MOD = 1000000007;
         private int[][][] memo;
          public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        memo = new int[n][201][201];

        for (int i = 0; i < n; i++)
            for (int g1 = 0; g1 <= 200; g1++)
                java.util.Arrays.fill(memo[i][g1], -1);

        return dfs(nums, 0, 0, 0);
    }

    private int dfs(int[] nums, int idx, int g1, int g2) {
        if (idx == nums.length) {
            return (g1 != 0 && g1 == g2) ? 1 : 0;
        }

        if (memo[idx][g1][g2] != -1)
            return memo[idx][g1][g2];

        long ans = dfs(nums, idx + 1, g1, g2);

        ans += dfs(nums, idx + 1,
                g1 == 0 ? nums[idx] : gcd(g1, nums[idx]),
                g2);

        ans += dfs(nums, idx + 1,
                g1,
                g2 == 0 ? nums[idx] : gcd(g2, nums[idx]));

        return memo[idx][g1][g2] = (int)(ans % MOD);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
