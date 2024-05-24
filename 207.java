import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //每个点的入度
        int[] inDegree = new int[numCourses];

        //每个点的边集
        List<Integer>[] edges = new List[numCourses];

        //初始化边集
        for(int i=0;i<numCourses;i++){
            edges[i] = new ArrayList<>();
        }

        //为边集赋值
        int edge_num = prerequisites.length;
        for(int i=0;i<edge_num;i++){
            int[] edge = prerequisites[i];// 1,0
            int ia = edge[0];//1
            int ib = edge[1];//0
            edges[ib].add(ia);// 0->1
            inDegree[ia]++;
        }

        //如果没有入度为0的点,存在环
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = getIndegreeIsZero(inDegree);
        if(list.isEmpty()){
            return false;
        }
        int count =0;
        for(int i : list){
            queue.add(i);
            System.out.print(i);
            System.out.println();
        }
        //queue 存储入度为0的点
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            // System.out.println("poll:"+node);
            count++;
            System.out.println("before");
            for(int i=0;i<inDegree.length;i++){
                System.out.print(i+"'s indegree is "+inDegree[i]+" ");
            }
            inDegree[node]++;
            System.out.println();
            for(int i:edges[node]){
                inDegree[i]--;
            }
            System.out.println("after");
            for(int i=0;i<inDegree.length;i++){
                System.out.print(i+"'s indegree is "+inDegree[i]+" ");
            }
            System.out.println();
            list = getIndegreeIsZero(inDegree);
            for(int i : list){
                if(!queue.contains(i))queue.add(i);
                System.out.print("queueAdd:"+i);
                System.out.println();
            }
        }

        if(count==numCourses){
            return true;
        }else{
            return false;
        }
        
    }

    public List<Integer> getIndegreeIsZero(int[] inDegree){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                list.add(i);
            }
        }
        return list;
    }
}