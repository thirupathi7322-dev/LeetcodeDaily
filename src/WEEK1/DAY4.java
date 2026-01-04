class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int count = 0;
            int divisorSum = 0;
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    count++;
                    divisorSum += i;
                    if (i * i != num) {
                        count++;
                        divisorSum += num / i;
                    }
                }
                if (count > 4) break;
            }
            if (count == 4) sum += divisorSum;
        }
        return sum;
    }
}