class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1000000007;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int[] row : score)
            Arrays.fill(row, -1);

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                char ch = board.get(i).charAt(j);

                if (ch == 'X' || ch == 'S')
                    continue;

                int[][] dir = {{1,0},{0,1},{1,1}};

                for (int[] d : dir) {

                    int x = i + d[0];
                    int y = j + d[1];

                    if (x >= n || y >= n || score[x][y] == -1)
                        continue;

                    if (score[x][y] > score[i][j]) {
                        score[i][j] = score[x][y];
                        ways[i][j] = ways[x][y];
                    } else if (score[x][y] == score[i][j]) {
                        ways[i][j] = (ways[i][j] + ways[x][y]) % MOD;
                    }
                }

                if (score[i][j] != -1 && Character.isDigit(ch)) {
                    score[i][j] += ch - '0';
                }
            }
        }

        if (score[0][0] == -1)
            return new int[]{0,0};

        return new int[]{score[0][0], ways[0][0]};
    }
}
   