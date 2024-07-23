import random

class SmartRecommendationSystem:
    def __init__(self):
        self.recommendations = [
            "增加产品种类",
            "改善用户界面",
            "提高系统响应速度",
            "增加个性化推荐",
            "优化搜索功能"
        ]
        self.user_feedback = {}
        self.recommendation_scores = {rec: 0 for rec in self.recommendations}

    def get_recommendation(self):
        return random.choice(self.recommendations)

    def collect_feedback(self, recommendation, score):
        if recommendation not in self.user_feedback:
            self.user_feedback[recommendation] = []
        self.user_feedback[recommendation].append(score)
        self.update_scores()

    def update_scores(self):
        for rec, scores in self.user_feedback.items():
            self.recommendation_scores[rec] = sum(scores) / len(scores)

    def analyze_feedback(self):
        sorted_scores = sorted(self.recommendation_scores.items(), key=lambda x: x[1], reverse=True)
        print("\n分析结果:")
        print("最受欢迎的建议:")
        for rec, score in sorted_scores[:2]:
            print(f"- {rec} (评分: {score:.2f})")

    def generate_new_recommendation(self):
        base_rec = random.choice(self.recommendations)
        new_rec = f"优化并拓展'{base_rec}'"
        self.recommendations.append(new_rec)
        self.recommendation_scores[new_rec] = 0
        print(f"\n生成新建议: {new_rec}")

def run_demo():
    system = SmartRecommendationSystem()
    for _ in range(10):
        recommendation = system.get_recommendation()
        print(f"\n系统建议: {recommendation}")
        user_score = random.randint(1, 5)
        print(f"用户评分: {user_score}")
        system.collect_feedback(recommendation, user_score)
        if random.random() < 0.2:
            system.generate_new_recommendation()
    system.analyze_feedback()

if __name__ == "__main__":
    run_demo()