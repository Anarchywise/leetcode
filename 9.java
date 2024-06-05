import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        List<Integer> list = new ArrayList<>();
        while(x>0){
            int m =x&1;
            list.add(m);
            System.out.println(m);
            x>>>=1;
        }
        for(int i=0;i<list.size()/2;i++){
            if(list.get(i)!=list.get(list.size()-1-i)){
                return false;
            }
        }
        return true;
    }
}