class Solution {

    public int minPairSum(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, result = Integer.MIN_VALUE;

        int[] freq = new int[100001];
        for (int i = 0; i < n ; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
            freq[nums[i]]++;
        }

        while (min <= max) {
            if (freq[min] == 0) min++;
            else if (freq[max] == 0) max--;
            else {
                result = Math.max(min + max, result);
                freq[min]--;
                freq[max]--;
            }
        }
        
        return result;
    }

}