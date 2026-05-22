class Solution {
    public boolean isHappy(int n) {
        int num=n;
        while(num>9)
        {
            int temp=num,sum=0;
            while(temp!=0){
                int digit=temp%10;
                sum+=digit*digit;
                temp/=10;
            }
            num=sum;
            }
            if(num==1||num==7){
                return true;
            }
            return false;
    }
}