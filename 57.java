import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int x=0;x<intervals.length;x++){
            if(newInterval[0]<=right){
                if(right>newInterval[1]){
                    ans.add(new int[]{left,right});
                }
                right = newInterval[1];
            }else{
                if(intervals[x][0]>right){
                    ans.add(new int[]{left,right});
                    left = intervals[x][0];
                    right = intervals[x][1];
                }
                if(intervals[x][0]<=right&&intervals[x][1]>right){
                    right = intervals[x][1];
                }
            }
            System.out.print("left:"+left);
            System.out.println("right:"+right);
        }
        ans.add(new int[]{left,right});
        return ans.toArray(new int[ans.size()][]);
    }
}