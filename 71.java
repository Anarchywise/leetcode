import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> queue = new ArrayDeque<>();
        for(String s : paths){
            if(s.equals(".")||s.equals("")){
            }else if(s.equals("..")){
                queue.pollLast();
            }else{
                queue.add(s);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(@SuppressWarnings("unused") String s : queue.toArray(new String[]{})){
            stringBuilder.append("/"+queue.poll());
        }
        if(stringBuilder.isEmpty()){
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }
}