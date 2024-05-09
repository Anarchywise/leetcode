// 使用快慢指针来判断是否存在环
class Solution {
    public boolean isHappy(int n) {
        int tortoise = n;
        int rabbit = getNext(n);
        //当快慢相遇时或者快到达终点时退出
        //=> 当快慢未相遇 并且 快没有到达终点时
        //=> P^Q  <=> ~Pv~Q 
        while(rabbit!=1&&tortoise!=rabbit){
            tortoise = getNext(tortoise);
            rabbit = getNext(getNext(rabbit));
        }
        return rabbit ==1;
    }
    int getNext(int x){
        int sum =0;
        while(x>0){
            int d = x%10;
            x = x/10;
            sum +=d*d;
        }
        return sum;
    }
}