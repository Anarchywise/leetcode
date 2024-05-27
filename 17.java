import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0 || digits ==null){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuilder combination = new StringBuilder();
        doit(combination, 0, digits, ans,phoneMap);
        return ans;
    }
    
    public void doit(StringBuilder prex,int index,String digits,List<String> ans,Map<Character, String> map){
        if(index ==digits.length()){
            ans.add(prex.toString());
            return;
        }
        String characters = map.get(digits.charAt(index));
        for(char c : characters.toCharArray()){
            prex.append(c);
            doit(prex, index+1, digits, ans,map);
            prex.deleteCharAt(prex.length()-1); //前缀删除
        }
    }
}