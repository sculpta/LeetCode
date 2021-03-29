package com.yuanhaoji.leetcode.bit_manipulation.reverse_bits;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2021/3/29
 * @desp: 190简单题——颠倒二进制位，https://leetcode-cn.com/problems/reverse-bits/
 */

public class Solution {

    public int reverseBits(int n) {
        int res = 0;

        // for (int i = 0; i < 32 && n != 0; ++i) {
        //     res |= (n & 1) << (31 - i);
        //     n >>>= 1;
        // }

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    /**
     * 分治
     */
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    // public int reverseBits(int n) {
    //     n = n >>> 1 & M1 | (n & M1) << 1;
    //     n = n >>> 2 & M2 | (n & M2) << 2;
    //     n = n >>> 4 & M4 | (n & M4) << 4;
    //     n = n >>> 8 & M8 | (n & M8) << 8;
    //     return n >>> 16 | n << 16;
    // }

}
