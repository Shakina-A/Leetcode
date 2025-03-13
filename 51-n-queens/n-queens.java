class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char mat[][] = new char[n][n];
        //initializing all the values as "."
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = '.';
            }
        }
        solve(mat, 0, ans);
        return ans;
    }
    void solve(char mat[][] , int r ,  List<List<String>> ans ){
        if(r == mat.length){
            ArrayList<String> al = new ArrayList<>();
            for(int i=0; i<mat.length; i++){
                String s = "";
                for(int j=0; j<mat.length; j++){
                    s+= mat[i][j];
                }
                al.add(s);
            }
            ans.add(al);
            return;
        }
        for(int c = 0; c<mat.length; c++){
            if(possible( mat, r,c ) ){
                mat[r][c] = 'Q';
                solve(mat, r+1, ans);
                mat[r][c] = '.'; // backtracking
            }
        }
    }
    boolean possible(char mat[][], int r, int c ){
        int j= c;
        int i = r;
        //to check top of the column
        while(i>=0){
            if(mat[i][j] == 'Q'){
                return false;
            }
            i--;
        }
        j=c;//reinitialize
        i =r;
        //to check diagonal left
        while(i>=0 && j>= 0 ){
            if(mat[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        j = c;
        i = r;
         //to check diagonal right
        while(i>=0 && j<mat.length ){
            if(mat[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}