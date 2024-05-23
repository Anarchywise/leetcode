import java.util.Stack;

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double pre = -Double.MAX_VALUE;
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            if(root.val<=pre) return false;
            pre = root.val;
            root = root.right;
        }
        boolean test = 0>Double.MAX_VALUE;
        System.out.println(test);
        return true;
    }
}
/*
 * 浮点数
 * (-1)^s*M*2^N
 * 0<Double.MIN_VALUE    true
 * 0>Double.MIN_VALUE-1  true
 * 0==(int)(Double.MIN_VALUE) true
 * 
 * 
 * Double.MIN_VALUE 是 Java 中 double 类型的最小正数值，
 * 而不是负的最小值。Java 中的 Double.MIN_VALUE 代表的是正数最接近 0 的数值，而不是负数。
 * 为了更清楚地理解，以下是一些详细的信息：
 * Double.MIN_VALUE 的定义：Double.MIN_VALUE 是双精度浮点数的最小正正数（即正数中最接近零的值），
 * 其值约为 4.9×10−3244.9×10−324。
 * 范围：double 类型的范围是从 -Double.MAX_VALUE 到 Double.MAX_VALUE。
 * Double.MIN_VALUE 是一个非常小的正数，不是负数。
 */