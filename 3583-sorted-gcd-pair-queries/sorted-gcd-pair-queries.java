 class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }
        long[] cnt = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                cnt[i] += freq[j];
            }
        }
        long[] pairs = new long[max + 1];

        for (int i = max; i >= 1; i--) {
            long total = cnt[i] * (cnt[i] - 1) / 2;
            for (int j = 2 * i; j <= max; j += i) {
                total -= pairs[j];
            }
            pairs[i] = total;
        }
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + pairs[i];
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            long target = queries[k] + 1;

            int left = 1;
            int right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target)
                    right = mid;
                else
                    left = mid + 1;
            }

            ans[k] = left;
        }

        return ans;
    }
} 
   