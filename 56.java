/*
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
/*
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->{
            return a[0]-b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int x=1;x<intervals.length;x++){
            System.out.print("leftI:"+left);
            System.out.print("rightI:"+right);
            if(intervals[x][0]>right){
                ans.add(new int[]{left,right});
                left = intervals[x][0];
                right = intervals[x][1];
            }else{
                right = Integer.max(right, intervals[x][1]);
            }
            System.out.print("leftO:"+left);
            System.out.println("rightO:"+right);
        }
        ans.add(new int[]{left,right});
        return ans.toArray(new int[ans.size()][]);
    }
}