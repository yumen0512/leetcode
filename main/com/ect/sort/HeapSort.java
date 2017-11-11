package com.ect.sort;

/**
 * 堆排序:分治思想
 *
 * 完全二叉树：除最后一层外，每一层上的结点数均达到最大值；在最后一层上只缺少右边的若干结点。
 *
 * 完全二叉树特点：heap[father * 2+1] = heap[leftChild];  heap[father * 2 + 2] = heap[rightChild];
 *
 * 构建最大堆思路：从最后一个有子节点的开始，和他的节点进行比较，如果小于子节点，父节点和子节点交换位置，一直到根
 *
 * Created by wangjunyu on 17-11-11.
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] nums = new int[]{-3, -2, 1, 3, 2, -4};
        heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

    private static void heapSort(int[] nums) {

        int size = nums.length - 1;

        while (size >= 0) {
            buildMaxHeap(nums, size);
            int temp = nums[0];
            nums[0] = nums[size];
            nums[size] = temp;
            size--;
        }
    }

    /**
     * 从最后一个有子节点的节点开始比较他和两个子节点
     *
     * @param end 未排序的最后一个位置
     */
    private static void buildMaxHeap(int[] nums, int end) {

        if (nums == null || nums.length <= 1 || end < 1) {
            return;
        }

        // 最后一个有子节点的位置
        int i = (end - 1) / 2;

        // 从最后一个节点开始调用，到第一个
        while (i >= 0) {
            int j = 2 * i;

            if (j + 2 <= end) {
                if (nums[j + 1] > nums[j + 2]) {
                    swap(nums, i, j + 1);
                } else {
                    swap(nums, i, j + 2);
                }
            } else {
                swap(nums, i, j + 1);
            }

            i--;
        }

    }

    private static void swap(int[] nums, int p, int q) {

        if (nums[p] < nums[q]) {
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
        }
    }
}