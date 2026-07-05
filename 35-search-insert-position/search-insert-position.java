class Solution {
    public int searchInsert(int[] nums, int target) {
        int a=0;
        int b=nums.length-1;
        while(a<=b){
            int c=a+(b-a)/2;
            if(nums[c]==target)return c;
            else if(nums[c]>target)b=c-1;
            else a=c+1;
        }
        return a;
    }
}