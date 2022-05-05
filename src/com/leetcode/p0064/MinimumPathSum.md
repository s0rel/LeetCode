### 分析

基线条件

dp[0][0] = grid[0][0]，

dp[i][0] = dp[i - 1][0] + grid[i][0]

dp[0][i] = dp[0][i - 1] + grid[0][i]

递推式

dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]