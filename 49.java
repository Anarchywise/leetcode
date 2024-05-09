import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] tokens = str.toCharArray();
            Arrays.sort(tokens);
            String key = new String(tokens);
            List<String> gro = map.getOrDefault(key,new ArrayList<String>());
            gro.add(str);
            map.put(key,gro);
        }
        return new ArrayList<List<String>>(map.values());
    }
}