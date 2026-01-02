

package DAY2;

import java.util.HashSet;

public class RepeatedNtimes {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 3};
        System.out.println(repeatedNTimes(arr));
    }

    public static int repeatedNTimes(int[] nums) {
        HashSet<Integer> HS = new HashSet();

        for(int i = 0; i < nums.length; ++i) {
            if (HS.contains(nums[i])) {
                return nums[i];
            }

            HS.add(nums[i]);
        }

        return -1;
    }
}
