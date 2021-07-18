package com.xubo.algorithm;

import java.util.Stack;

/**
 * @Author Druid_Xu
 * @Date 2020/11/5 下午 02:46
 * @Description
 */
public class GetMinInStack {

    private static Stack<Integer> mainStack = new Stack<Integer>();
    private static Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 进栈
     * @param element
     */
    public void push(int element) {
        mainStack.push(element);
//        如果辅助栈为空，或者栈顶元素小于新进元素
        if(minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop() {
//       如果辅助栈 跟 正式栈 栈顶元素相同，就说明 正式栈中出的是栈中的最小值
        if(mainStack.peek() == minStack.peek()) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * 获取栈的最小值
     * @return
     * @throws Exception
     */
    public Integer getMin() throws Exception {
        if(mainStack.empty()) {
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        GetMinInStack stack = new GetMinInStack();
        stack.push(4);
        stack.push(8);
        stack.push(9);
        stack.push(12);
        stack.push(1);
        stack.push(3);
        stack.push(21);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }
}
