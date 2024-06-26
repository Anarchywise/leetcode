import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int n = bank.length;
        Map<Integer,String> map = new HashMap<>();
        int end =0;
        int start = 0;
        for(int i=0;i<n;i++){
            map.put(i+1,bank[i]);
            if(bank[i].equals(endGene)){
                end = i+1;
            }
            if(bank[i].equals(startGene)){
                start = i+1;
            }
        }
        if(!map.containsValue(startGene)) map.put(start, startGene);
        if(!map.containsValue(endGene)) return -1;

        List<Integer>[] edges = new List[n+1];
        for(int i=0;i<=n;i++){
            edges[i] = new ArrayList<>();
        }
        //得到边
        for(int i=0;i<=n;i++){
            for(int j =i+1;j<=n;j++){
                if(isChangeOne(map.get(i), map.get(j))){
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        
        //bfs
        boolean[] visited = new boolean[n+1];
        visited[start] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        int count =0;
        while(!queue.isEmpty()&&!visited[end]){
            List<Integer> level = new ArrayList<>();
            while(!queue.isEmpty()){
                level.add(queue.poll());
            }
            for(int top : level){
                System.out.print("now is :"+top);
                for(int i :edges[top]){
                    System.out.print("edges:"+i);
                    if(visited[i]){
                        continue;
                    }
                    if(i==end){
                        visited[end] = true;
                        break;
                    }
                    visited[i] =true;
                    queue.offer(i);
                }
                System.out.println();
            }
            count++;
        }
        if(visited[end]){
            return count;
        }else{
            return -1;
        }
            

    }
    public boolean isChangeOne(String str1, String str2){
        int count=0;
        if(str1 == null||str2==null||str1.length()!=8||str1.length()!=str2.length()){
            return false;
        }
        for(int i=0;i<8;i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }
}