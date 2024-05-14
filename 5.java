class Solution {
    public String longestPalindrome(String s) {
        int max =1;
        String ans = s.substring(0,1);
        int n = s.length();
        for(int i=0;i<n;i++){
            //奇数类
            int left = i-1;
            int right = i+1;
            int length =1;
            while(left>=0&&right<n&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                length +=2;
            }
            if(length>max){
                max = length;
                /*
                 * left 和 right 相当于 都超出了,left往左超出1,right往右超出1
                 * 判断子字符串的index时需要小心
                 */
                ans = s.substring(left + 1, right); // 更新最长回文子串的位置
            }
            //偶数类
            left = i;
            right = i+1;
            length =0;
            while(left>=0&&right<n&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                length +=2;
            }
            if(length>max){
                max = length;
                ans = s.substring(left + 1, right); // 更新最长回文子串的位置
            }
        }  
        return ans;   
    }
}



/*
 * 超时
 */
class Solution2 {
    public String longestPalindrome(String s) {
        int max = 0;
        String ans ="";
        int n = s.length();
        for(int x=0;x<n;x++){
            for(int xx=0;xx<=x-max;xx++){
                System.out.println(s.substring(xx,x+1));
                if(is_reverse(s.substring(xx,x+1))){
                    if(x-xx+1>max){
                        max = x-xx+1;
                        ans = s.substring(xx,x+1);
                    }
                }
            }
        }
        return ans;
    }
    boolean is_reverse(String s){
        if(s.length()==1){
            return true;
        }
        char[] ss =s.toCharArray();
        int n = ss.length;
        for(int x=0;x<n/2;x++){
            if(ss[x]!=ss[n-1-x]){
                return false;
            }
        }
        return true;
    }
}