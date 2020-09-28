/*  Flood Fill templete : 
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
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0)
            return null;
        int[][] visited = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++){
            for (int j = 0; j < image[0].length; j++){
                visited[i][j] = image[i][j];
            }
        }
        fill(image, visited,sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void fill(int[][] image, int[][] visited, int sr, int sc, int origColor,int newColor){
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)  // these if can not change order
            return;
        
        if (image[sr][sc] != origColor || visited[sr][sc] == -1) 
            return;
        
        image[sr][sc] = newColor;
        visited[sr][sc] = -1;
        fill(image, visited, sr-1, sc, origColor, newColor); // get the information from child node, DFS is four branches bst
        fill(image, visited, sr+1, sc, origColor, newColor);
        fill(image, visited, sr, sc-1, origColor, newColor);
        fill(image, visited, sr, sc+1, origColor, newColor);
    }
}
