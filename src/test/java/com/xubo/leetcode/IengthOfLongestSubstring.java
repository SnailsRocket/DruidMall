package com.xubo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Druid_Xu
 * @Date 2020/12/14 上午 11:33
 * @Description   无重复字符的最长子串
 *
 */
public class IengthOfLongestSubstring {
    public static void main(String[] args) {
        int maxLength = lengthOfLongestSubstring("bkbwacb");
        System.out.println(maxLength);

    }

    /**
     * 滑动窗口法：
     *  设置 start end 两个指针(定位用) ，一旦遇见重复的就将 start移动到重复的地方
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
     * map 集合 字符存成key 索引值存成value
     * 开始时 start 和 end 都是在 0 位置，然后 end向后位移，知道遇见重复的，将start移至重复位置，并判断要不要覆盖最大长度
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int end = 0,start = 0; end < n; end++) {
            char c = s.charAt(end);
            // 如果遇见重复的key 就将start移动到重复key 的那个地方
            if(map.containsKey(c)) {
                start = Math.max(map.get(c),start);
            }
            ans = Math.max(end-start +1,ans);
            map.put(s.charAt(end),end+1);
        }
        return ans;
    }
}
