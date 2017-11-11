package com.ect.leetCode.arrary;

import java.util.Comparator;
import java.util.Stack;

/**
 * 215. Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in
 * the sorted order, not the kth distinct element.
 *
 * 1思路1 取前k个树排序，最上面是第k个大的数，剩余的遍历，比k大，栈顶移除，重新排序，最后返回栈顶 o(nklogk)
 *
 * 2思路2 分制 快排
 *
 *
 * 最大堆:父节点大于等于左右两子节点
 *
 * Created by wangjunyu on 17-11-9.
 */
public class Title215 {

    public static void main(String[] args) {
        findKthLargest(null, 0);
    }

    /**
     * 思路1
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.size() < k) {
                stack.add(nums[i]);
                sortStack(stack);
            }

            else if(stack.peek() < nums[i]) {
                stack.pop();
                stack.push(nums[i]);
                sortStack(stack);
            }
            else{

            }
        }
        return stack.peek();
    }

    private static void sortStack(Stack<Integer> s) {
        s.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }



}
