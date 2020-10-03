class Solution {
    /*
    * @para{int[]} arr
    * @return{int} res
    */
    private int[][] memoization;
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        memoization = new int[n][n];
        return getMinSum(arr, 0, arr.length - 1);
    }

    private int getMinSum(int[] arr, int left, int right) {
        if (left == right) 
            return 0;
        if (memoization[left][right] != 0)
            return memoization[left][right];

        int minSum = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            int leftStart = left, leftEnd = i, rightStart = i + 1, rightEnd = right;
            int temp = getMinSum(arr, leftStart, leftEnd) + getMinSum(arr, rightStart, rightEnd) +
                    getMaxNum(arr, leftStart, leftEnd) * getMaxNum(arr, rightStart, rightEnd);
            minSum = Math.min(temp, minSum);
        }
        memoization[left][right] = minSum;
        return minSum;
    }

    private int getMaxNum(int[] arr, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
