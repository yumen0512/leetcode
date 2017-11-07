package java.com.ect.leetCode.list;

/**
 * Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each
 * represents a point at coordinate (i, ai). n vertical lines are drawn
 * such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.Note:
 * You may not slant the container and n is at least 2.
 *
 * 两挡板和x轴围成的容器能装最多水
 * 思路：装水容量取决于最短板
 * 1 容器的盛水的容器为（j-i）*min(a[i],a[j])
 * 2 从两边开始，算出tempmax,如果height[i]比较小，这时把右边的j向左移动，会使（j-i）变小，
 * 但是height[i]决定了min(a[i],a[j])的上限，面积只会比算出tempmax更小，所以只能i右移
 * 3 同理height[j]小的时候，j左移动
 *
 * Created by wangjunyu on 17-11-7.
 */
public class Title11 {

    public int maxArea(int[] height) {

        int maxArea = 0;

        int j = height.length-1,i=0;

        while(i<j){
            int tempMax = (j-i)*Math.min(height[i],height[j]);

            if(tempMax>maxArea){
                maxArea = tempMax;
            }

            if(height[i]>height[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return maxArea;
    }
}
