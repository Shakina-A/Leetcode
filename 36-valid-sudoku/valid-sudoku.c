bool isValidSudoku(char** board, int boardSize, int* boardColSize) {
    bool rowCheck[9][9] = {false};  // rowCheck[i][digit-1] is true if digit seen in row i+1
    bool colCheck[9][9] = {false};  // colCheck[j][digit-1] is true if digit seen in col j+1
    bool boxCheck[9][9] = {false};  // boxCheck[boxIndex][digit-1] is true if digit seen in box with index boxIndex

    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < 9; ++j) {
            if (board[i][j] != '.') {
                int digit = board[i][j] - '0';
                int boxIndex = (i / 3) * 3 + (j / 3);

                // Check row
                if (rowCheck[i][digit - 1]) {
                    return false;
                } else {
                    rowCheck[i][digit - 1] = true;
                }

                // Check column
                if (colCheck[j][digit - 1]) {
                    return false;
                } else {
                    colCheck[j][digit - 1] = true;
                }

                // Check sub-box
                if (boxCheck[boxIndex][digit - 1]) {
                    return false;
                } else {
                    boxCheck[boxIndex][digit - 1] = true;
                }
            }
        }
    }

    return true;
}
