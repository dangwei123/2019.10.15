1.
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int left=0;
        int right=nums.length-1;
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
            while(left<nums.length&&arr[left]==nums[left]){
                left++;
            }
            while(right>=0&&arr[right]==nums[right]){
                right--;
            }
          if(left<right){
              return right-left+1;
          }else{
              return 0;
          }

      
    }
}

2.
给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

你可以返回满足此条件的任何数组作为答案。

 
 class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left=0;
        int right=A.length-1;
        while(left<right){
            while(left<right&&A[left]%2==0){
                left++;
            }
            while(left<right&&A[right]%2!=0){
                right--;
            }
            if(left<right){
                int tmp=A[left];
                A[left]=A[right];
                A[right]=tmp;
            }
        }
        return A;
    }
}

3.
给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。

让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

A.length >= 3
在 0 < i < A.length - 1 条件下，存在 i 使得：
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[B.length - 1]
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-mountain-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length<3){
            return false;
        }
        int left=0;
        int right=A.length-1;
        while(left<A.length-1&&A[left]<A[left+1]){
                left++;
        }
        if(left==A.length-1){
            return false;
        }
         while(right>0&&A[right]<A[right-1]){
                right--;
        }
         if(right==0){
            return false;
        }
        return left==right;
    }
}

