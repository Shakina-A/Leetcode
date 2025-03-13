class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char [][] board){
        for(int i=0; i<=8; i++){
            for(int j=0; j<=8; j++){
                if(board[i][j] == '.'){
                    for(char k = '1' ; k<='9'; k++){
                        if(possible(board, k, i,j ) ){
                            board[i][j] = k;
                            if( solve(board) ) {
                                return true;
                            };
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean possible(char [][] board, char ch, int r, int c){
        // row check
        for(int j=0; j<9; j++){
            if(board[r][j] == ch){
                return false;
            }
        }
        // colunm check
        for(int i=0; i<9; i++){
            if(board[i][c] == ch){
                return false;
            }
        }
        //block check
        int blockRow = r/3 * 3 ;
        int blockCol = c/3 * 3 ;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[blockRow+i][blockCol+j] == ch){
                    return false;
                }
            }
        }
        return true;
    }
    
}