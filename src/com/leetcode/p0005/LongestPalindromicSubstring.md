### 分析

**动态规划**

P(i, j) = P(i + 1, j - 1) && S~i~ == S~j~

基线条件
* P(i, i) = true
* P(i, i + 1) = (S~i~ == S~i+1~)
