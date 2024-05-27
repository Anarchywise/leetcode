import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int totalNQueens(int n) {
        int[] ans = new int[1]; // 使用数组来存储计数器，以便在递归中传递和更新
        doit(new ArrayList<>(), n, ans);
        return ans[0];
    }

    /*
     * 因为在 Java 中，Integer 是不可变的，
     * 所以 count++ 只是创建了一个新的 Integer 对象，
     * 并将其分配给 count，并不会修改原始对象的值。
     */
    public void doit(List<Posi> prex,int n,int[] count){
        if(prex.size() == n){
            System.out.print("解: ");
            for(Posi i :prex){
                System.out.print("["+i.l+" "+i.r+"]");
            }
            System.out.println();
            count[0]++;
            return;
        }
        // 计算所有可能的位置
        boolean isOk[] = new boolean[n+1];
        Arrays.fill(isOk, true);
        for(Posi posi : prex){
            isOk[posi.r] = false;
            System.out.print(posi.r);
            if(posi.r-(prex.size()+1-posi.l)>0){
                System.out.print(posi.r-(prex.size()+1-posi.l));
                isOk[posi.r-(prex.size()+1-posi.l)] = false;
            }
            if(posi.r+(prex.size()+1-posi.l)<n+1){
                System.out.print(posi.r+(prex.size()+1-posi.l));
                isOk[posi.r+(prex.size()+1-posi.l)] = false;
            }
            
        }
        //遍历所有的可能
        System.out.print("前缀为");
        for(Posi posi:prex){
            System.out.print(posi.r+" ");
        }
        System.out.print("下一步可能为: ");
        for(int i=1;i<=n;i++){
            if(isOk[i]) System.out.print(i+" ");
        }
        System.out.println();
        for(int i=1;i<=n;i++){
            if(isOk[i]){
                prex.add(new Posi(prex.size()+1, i));
                doit(prex, n, count);
                prex.remove(prex.size()-1);
            }
        }
        System.out.println();
    }


    class Posi{
        int l; int r;
        public Posi(int l,int r){
            this.l = l;
            this.r = r;
        }
    }
}