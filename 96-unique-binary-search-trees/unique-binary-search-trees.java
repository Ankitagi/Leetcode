class Solution {
    public int numTrees(int n) {
        int [] tree=new int[n+1];
        for(int i=0;i<=n;i++){
            tree[i]=1;
        }
        for(int i=2;i<=n;i++){
            int total=0;
            for(int j=1;j<=i;j++){
                total+=tree[j-1]*tree[i-j];
            }
            tree[i]=total;
        }
        return tree[n];
    }
}