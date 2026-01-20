class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            int x = nums.get(i);

            // Check x is even or not
            if((x & 1) == 0) {
                ans[i] = -1;
            } else {          // Find the rightmost 0th bit
                int mask = 1;   
                while((x & mask) != 0) {
                    mask <<= 1;
                }
                ans[i] = x - (mask >> 1);
            }
        }

        return ans;
    }
} 