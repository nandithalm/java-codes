//leetcode
//graph
class Solution {

    private void dfs(int row, int col, int[][] image, int originalColor, int color) {

        image[row][col] = color;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {

            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < image.length &&
                ncol >= 0 && ncol < image[0].length &&
                image[nrow][ncol] == originalColor) {

                dfs(nrow, ncol, image, originalColor, color);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        dfs(sr, sc, image, originalColor, color);

        return image;
    }
}
