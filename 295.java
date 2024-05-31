import java.util.List;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Double> priorityQueue;
    int size;
    public MedianFinder() {
        priorityQueue = new PriorityQueue<>();
        size =0;
    }
    
    public void addNum(int num) {
        size++;
        priorityQueue.offer((double)num);
    }
    
    public double findMedian() {
        Double[] list = new Double[size];
        list = priorityQueue.toArray(list);
        // for(int i:list){
        //     System.out.print(i+" ");
        // }
        for(double i:priorityQueue){
            System.out.print(i+" ");
        }
        System.out.println();
        if(size%2 ==0){
            //偶数
            return (list[size/2]+(double)list[(size/2)-1])/2.0;
        }else{
            //奇数
            return list[size/2];
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */