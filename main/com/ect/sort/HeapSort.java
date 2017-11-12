package com.ect.sort;

/**
 * 堆排序
 * 思想：构建最大堆，每次根和最后一个未排序的交换，最大的移到尾部，再构建最大堆，,直到最后一个
 *
 * 完全二叉树：二叉树的左边都是满的，父节点和子节点的关系，heap[parent*2+1] = heap[left],
 * heap[parent*2+2] = heap[right]
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] nums = new int[]{-3,-2,1,3,2,-4};
        heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

    private static void heapSort(int[] nums){

        int size = nums.length-1;

        while (size>=0){
            buildMaxHeap(nums,size);
            int temp = nums[0];
            nums[0] = nums[size];
            nums[size] = temp;
            size--;
        }
    }

    /**
     * 从最后一个有子节点的节点开始比较他和两个子节点
     * @param nums
     * @param end 未排序的最后一个位置
     */
    private static void buildMaxHeap(int[] nums,int end){

        if(nums==null||nums.length<=1||end<1){
            return;
        }

        // 最后一个有子节点的位置
       int i = (end-1)/2;

       // 从最后一个节点开始调用，到第一个
        while(i>=0){
            int j = 2*i;

            if(j+2<=end){
                if(nums[j+1]>nums[j+2]){
                    swap(nums,i,j+1);
                }
                else{
                    swap(nums,i,j+2);
                }
            }
            else{
                swap(nums,i,j+1);
            }

            i--;
        }

    }

    private static void swap(int[] nums,int p ,int q){

        if(nums[p]<nums[q])
        {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
        }
    }
}
