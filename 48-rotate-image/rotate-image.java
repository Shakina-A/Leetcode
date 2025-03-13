class Solution {
    public void rotate(int[][] arr) {
        int n=arr.length;
       // System.out.print(n);
       for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            int t=arr[i][j];
            arr[i][j]=arr[j][i];
            arr[j][i]=t;
        }
       }
        for(int i=0;i<n;i++){
            int s=0;int e=n-1;
            while(s<e){

            int t=arr[i][s];
            arr[i][s]=arr[i][e];
            arr[i][e]=t;
            s++;
        e--;
        }
        
        }
       
    }
}