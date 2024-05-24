import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int count_node =0;
            //将所有点存入map中,Stirng对应点,Integer对应索引
            Map<String,Integer> map = new HashMap<>();
            for(int i=0;i<equations.size();i++){
                if(!map.containsKey(equations.get(i).get(0))){
                    map.put(equations.get(i).get(0), count_node);
                    count_node++;
                }
                if(!map.containsKey(equations.get(i).get(1))){
                    map.put(equations.get(i).get(1), count_node);
                    count_node++;
                }
            }
            //存入边,应该有和点数一样的List<Edge>
            List<Edge>[] edges = new List[count_node];
            //每个edges需要初始化
            for(int i=0;i<count_node;i++){
                edges[i] = new ArrayList<>();
            }

            int n = values.length;
            for(int i=0;i<n;i++){
                int ia = map.get(equations.get(i).get(0));
                int ib = map.get(equations.get(i).get(1));
                double val = values[i];
                edges[ia].add(new Edge(ib, val));
                edges[ib].add(new Edge(ia, 1.0/val));
            }
            //dfs 得到问题的答案
            int queries_num = queries.size();
            double[] ans = new double[queries_num];

            for(int i=0;i<queries_num;i++){
                List<String> query = queries.get(i);
                double res = -1.0;
                if(map.containsKey(query.get(0)) && map.containsKey(query.get(1))){
                    int va = map.get(queries.get(i).get(0));
                    int vb = map.get(queries.get(i).get(1));

                    if(va == vb){
                        res =1.0;
                    }else{
                        Queue<Integer> queue  =new ArrayDeque<>();
                        queue.add(va);
                        double[] everynode = new double[count_node];
                        Arrays.fill(everynode, -1.0);
                        everynode[va] =1.0;
                        while(!queue.isEmpty()&&everynode[vb]==-1.0){
                            int node_now = queue.poll();
                            for(Edge edge : edges[node_now]){
                                int index_next = edge.index;
                                double val = edge.val;
                                //如果该点还没有遍历到
                                if(everynode[index_next]<0){
                                    everynode[index_next] = everynode[node_now]*val;
                                    queue.add(index_next);
                                }
                            }
                        }
                        res = everynode[vb];
                    }
                }
                ans[i] = res;
                
            }
            return ans;
    }
    class Edge{
        int index; //下一个点
        double val; //这条表的值
        public Edge(int index,double val){
            this.index =index;
            this.val = val;
        }
    }
}