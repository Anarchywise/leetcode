import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        // 异或运算 ^   一个为1一个为0的时候为1 
        //异或运算支持 交换律
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            Integer value = map.getOrDefault(num, 0);
            value++;
            map.put(num, value);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}