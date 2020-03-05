package top.felixu.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author felixu
 * @since 2020.03.03
 */
public class TwoSum {
    /**
     * 方法一：暴力方法
     * 两遍 for
     * 每个 for 时间复杂度为 O(n)
     * 整体时间复杂度为 O(n^2)
     * 空间复杂度 O(1)
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length < 2)
            return result;
        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for(int j = 0; j < nums.length; j++) {
                if(j == i)
                    continue;
                if(target == a + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    /**
     * 方法二：使用 hash 表
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length < 2)
            return result;
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (temp.containsKey(target - a)){
                result[0] = temp.get(target - a);
                result[1] = i;
            }
            temp.put(a, i);
        }
        return result;
    }
}
