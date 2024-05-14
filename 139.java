import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDicts = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int x= 1;x<=s.length();x++){
            for(int i =0;i<wordDicts.size();i++){
                if(x-wordDict.get(i).length()>=0){
                    if(dp[x-wordDict.get(i).length()]&&wordDicts.contains(s.substring(x-wordDict.get(i).length(),x))){
                        dp[x] =true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];

    }
}