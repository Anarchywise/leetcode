import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b)->{
                return  Math.abs(a[0]-a[1]) - Math.abs(b[0]-b[1]);
            }
        );
        for(int i=0;i<nums.length-1;i++){
            queue.offer(new int[]{nums[i],nums[i+1],i});
        }
        int ans =0;
        while (!queue.isEmpty()&&k>0) {
            int[] item = queue.poll();
            ans = Math.abs(item[0]-item[1]);
            if(item[2]>0){
                queue.offer(new int[]{nums[item[2]-1],item[1],item[2]-1});
            }
            k--;
        }
        return ans;
    }
}