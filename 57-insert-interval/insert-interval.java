class Solution {
    public int[][] insert(int[][] q, int[] ni) {
        List<int[]> ans=new ArrayList<>();
        int i=0,start=ni[0],end=ni[1];
        boolean inserted=false;
        if(ni.length<=0)
            return q;
        while(i<q.length){
            if((q[i][1]<ni[0])||(q[i][0]>ni[1])){
                ans.add(q[i]);
            }
            else{
                int []temp=new int[2];
                inserted=true;
                start=Math.min(q[i][0],start);
                while(i<q.length&&q[i][0]<=ni[1]){
                    i++;
                }
                i--;
                end=Math.max(end,q[i][1]);
                temp[0]=start;
                temp[1]=end;
                ans.add(temp);
            }
            i++;
        }
        if(!inserted){
            ans.add(ni);
            inserted=true;
        }
        int[][]res= ans.toArray(new int[ans.size()][]);
        Arrays.sort(res,(a,b)->Integer.compare(a[0],b[0]));
        return res;
    }
}