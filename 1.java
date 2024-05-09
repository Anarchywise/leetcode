import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x=0;x<nums.length;x++){
            if(map.containsKey(target-nums[x])){
                return new int[]{map.get(target-nums[x]),x};
            }
            map.put(nums[x], x);
        }
        return new int[0];
    }
}