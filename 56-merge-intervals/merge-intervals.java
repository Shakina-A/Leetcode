class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<List<Integer>>list=new ArrayList<>();
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        for(int i=0;i<n;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(!list.isEmpty()&& end<=list.get(list.size()-1).get(1)){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(intervals[j][0]<=end){
                    end=Math.max(end,intervals[j][1]);
                }
                else{
                    break;
                }
            }
            list.add(Arrays.asList(start,end));

            
        }
          int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        
        return result;
    }
}