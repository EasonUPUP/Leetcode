// just dfs or bfs the boundry, then change. Limited area search is the key point
// https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/

/* 
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

*/

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if ( i == 0 || i == board.length-1 || j == 0 || j == board[0].length -1){
                    if (board[i][j] == 'O')
                        findBoundry(board, i, j);
                }
                    
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
        
    }

    private void findBoundry(char[][] board, int row, int col){
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return;
        if (board[row][col] == 'X' || board[row][col] == '#')
            return;
        board[row][col] = '#';
        
        findBoundry(board, row-1, col);
        findBoundry(board, row+1, col);
        findBoundry(board, row, col-1);
        findBoundry(board, row, col+1);
    }
}
