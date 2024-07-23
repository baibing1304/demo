import math

def calculate_sharpe_ratio(returns, risk_free_rate):
    """
    计算夏普比率

    参数:
    returns (list): 历史收益率列表
    risk_free_rate (float): 无风险利率

    返回:
    float: 夏普比率
    """
    # 计算平均收益率
    avg_return = sum(returns) / len(returns)

    # 计算标准差
    squared_diff_sum = sum((r - avg_return) ** 2 for r in returns)
    std_dev = math.sqrt(squared_diff_sum / len(returns))

    # 计算夏普比率
    sharpe = (avg_return - risk_free_rate) / std_dev

    return sharpe

# 示例使用
returns = [0.05, 0.03, 0.08, -0.01, 0.12]  # 历史收益率
risk_free_rate = 0.02  # 无风险利率

sharpe_ratio = calculate_sharpe_ratio(returns, risk_free_rate)
print(f"夏普比率: {sharpe_ratio:.4f}")