class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row=-1;
        int maxCount=-1;
        for(int i=0;i<mat.length;i++){
            int currentCount=0;
            for(int num:mat[i]){
                currentCount+=num;
            }
            if(currentCount>maxCount){
                maxCount=currentCount;
                row=i;
            }
        }
        return new int[]{row,maxCount};
    }
}