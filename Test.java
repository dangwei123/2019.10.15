1.
给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j++]=nums[i];
            }
        }
        return j;
    }
}

2.
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxProfit(int[] prices) {
        int price=0;
        int maxprice=0;
        int i=0;
        for( i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                break;
            }
        }
        if(i==(prices.length-1)){
            return 0;
        }
        for(int a=0;a<prices.length-1;a++){
            for(int b=a+1;b<prices.length;b++){
                price=prices[b]-prices[a];
                if(price>maxprice){
                    maxprice=price;
                }
            }
        }
        return maxprice;
    }
}

3.
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        if(nums.length<2){
            return nums.length;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                nums[++j]=nums[i];
            }
        }
        return ++j;
    }
}

4.
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]>=target){
                break;
            }
        }
        if(i==nums.length){
            return nums.length;
        }else{
            return i;
        }
        
    }
}