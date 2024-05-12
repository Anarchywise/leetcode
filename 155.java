import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Integer> list = new ArrayList<>();
    int size = 0;
    int min_value = Integer.MAX_VALUE;
    int min_position = -1;

    public MinStack() {
        
    }
    public void push(int val) {
        list.add(val);
        size++;
        if(min_value>val){
            min_value = val;
            min_position = size-1;
        }
        System.out.println("size"+size);
        System.out.println("min_position:"+min_position+"val:"+min_value);
    }
    
    public void pop() {
        list.remove(size-1);
        size--;
        if(size<=0) return;
        min_value = list.get(0);
        min_position = 0;
        for(int x=0;x<size;x++){
            if(list.get(x)<min_value){
                min_value = list.get(x);
                min_position = x;
            }
        }
        System.out.println("size"+size);
        System.out.println("min_position:"+min_position+"val:"+min_value);
    }
    
    public int top() {
        return list.get(size-1);
    }
    
    public int getMin() {
        return list.get(min_position);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */