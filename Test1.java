1.
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        int i=0;
        for(i=0;i<n;i++){
              int flag=0;
            for(j=j;j<m+n;j++){
                if(nums2[i]<=nums1[j]){
                    flag=1;
                    for(int tmp=m+n-1;tmp>j;tmp--){
                        nums1[tmp]=nums1[tmp-1];
                    }
                    nums1[j]=nums2[i];
                    break;
                }
                
            }
            if(flag==0){
             for(i=i;i<n;i++){
            nums1[m+i]=nums2[i];
        }
            }
            }
    
    }
}

2.
给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。
要求算法时间复杂度必须是O(n)。
class Solution {
    public int thirdMax(int[] nums) {
       Arrays.sort(nums);
        int max1=nums[0];
        int max2=nums[0];
        int max3=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max1){
                max1=nums[i];
            }
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max1){
                count++;
            }
        }
        if(count==nums.length||nums.length<3){
            return max1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max2&&nums[i]<max1){
                max2=nums[i];
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max1||nums[i]==max2){
                count++;
            }
        }
        if(count==nums.length){
            return max1;
        }
         for(int i=0;i<nums.length;i++){
            if(nums[i]>max3&&nums[i]<max1&&nums[i]<max2){
                max3=nums[i];
            }
        }
        return max3;
    }
}

3.
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        while((k%len)!=0){
        int tmp=nums[len-1];
        for(int i=len-1;i>0;i--){
            nums[i]=nums[i-1];
        }
        nums[0]=tmp;
          k--;
        }
        
    }
}
