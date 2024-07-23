package com.aixcoder.java;

public class SharpeRatioCalculator {
    public static double calculateSharpeRatio(double[] returns, double riskFreeRate) {
        // 计算平均收益率
        double avgReturn = 0;
        for (double returnVal : returns) {
            avgReturn += returnVal;
        }
        avgReturn /= returns.length;

        // 计算标准差
        double squaredDiffSum = 0;
        for (double returnVal : returns) {
            double diff = returnVal - avgReturn;
            squaredDiffSum += diff * diff;
        }
        double stdDev = Math.sqrt(squaredDiffSum / returns.length);

        // 计算夏普比率
        double sharpe = (avgReturn - riskFreeRate) / stdDev;

        return sharpe;
    }
    public static void main(String[] args) {
        double[] returns = {0.05, 0.03, 0.08, -0.01, 0.12};  // 历史收益率
        double riskFreeRate = 0.02;  // 无风险利率

        SharpeRatioCalculator calculator = new SharpeRatioCalculator();
        double sharpeRatio = calculator.calculateSharpeRatio(returns, riskFreeRate);

        System.out.println("夏普比率：" + sharpeRatio);
    }
}