//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
//
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2021 👎 0

package com.bright.leetcode.editor.cn;

import java.util.LinkedList;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解题思路一：
         * 判断括号的有效性可以使用「栈」这一数据结构来解决。
         * 我们对给定的字符串 s 进行遍历，当我们遇到一个左括号时，我们会期望在后续的遍历中，有一个相同类型的右括号将其闭合。由于后遇到的左括号要先闭合，因此我们可以将这个右括号放入栈顶。
         * @param s 符号字符串
         * @return 是否合法
         */
        public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }
            LinkedList<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '[') stack.push(']');
                else if (c == '(') stack.push(')');
                else if (c == '{') stack.push('}');
                else if (stack.isEmpty() || c != stack.pop()) return false;
            }
            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
