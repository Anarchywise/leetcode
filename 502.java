import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        // 小根堆, 按项目所需资本排序
        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        // 大根堆, 按项目利润排序
        PriorityQueue<Project> maxProfitHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        for (int i = 0; i < n; i++) {
            minCapitalHeap.add(new Project(profits[i], capital[i]));
        }
        for (int i = 0; i < k; i++) {
            // 将当前资本能投资的所有项目放入利润大根堆
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= w) {
                maxProfitHeap.add(minCapitalHeap.poll());
            }
            // 如果没有可投资项目，提前退出
            if (maxProfitHeap.isEmpty()) break;
            // 选择利润最高的项目投资
            w += maxProfitHeap.poll().profit;
        }
        
        return w;
    }
    
    class Project {
        int profit;
        int capital;
        
        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
