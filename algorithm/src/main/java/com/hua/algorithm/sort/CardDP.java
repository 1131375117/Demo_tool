package com.hua.algorithm.sort;

/**
 * 动态规划
 *
 * 最基本的背包问题就是01背包问题（01 knapsack problem）：一共有N件物品，第i（i从1开始）件物品的重量为w[i]，价值为v[i]。在总重量不超过背包承载上限W的情况下，能够装入背包的最大价值是多少？
 */
public class CardDP {
    public static void main(String[] args) {
        int value[]={60,100,120};
        int weigh[]={10,20,30};
        int n=3;
        int m=50;
        int dp[][]=new int[n+1][m+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(weigh[i-1]<=j){
                    dp[i][j]=Math.max(
                            value[i-1]+dp[i-1][j-weigh[i-1]],dp[i-1][j]
                    );
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);

    }

}
