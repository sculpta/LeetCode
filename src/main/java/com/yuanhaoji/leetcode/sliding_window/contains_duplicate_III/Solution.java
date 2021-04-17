package com.yuanhaoji.leetcode.sliding_window.contains_duplicate_III;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/4/17
 * @desp: 220中等题——存在重复元素 III，https://leetcode-cn.com/problems/contains-duplicate-iii/
 */
public class Solution {

    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     int n = nums.length;
    //     TreeSet<Long> set = new TreeSet<>();
    //     for (int i = 0; i < n; i++) {
    //         Long ceiling = set.ceiling((long) nums[i] - (long) t);
    //         if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
    //             return true;
    //         }
    //         set.add((long) nums[i]);
    //         if (i >= k) {
    //             set.remove((long) nums[i - k]);
    //         }
    //     }
    //     return false;
    // }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }

}
