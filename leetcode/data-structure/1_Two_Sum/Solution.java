// https://leetcode.com/problems/two-sum/
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> index = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            int needed = target - nums[i];

            if (index.containsKey(needed)){
                return new int[]{index.get(needed), i};
            }

            index.put(nums[i], i);
        }

        return new int[2];
    }
}
