import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // log n 你妈
        int a =0;
        int b = 0;
        int n = nums1.length;
        int n2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        while(a<n&&b<n2){
            if(nums1[a]>nums2[b]){
                list.add(nums2[b]);
                b++;
            }else{
                list.add(nums1[a]);
                a++;
            }
        }
        while(a<n){
            list.add(nums1[a]);
            a++;
        }
        while (b<n2) {
            list.add(nums2[b]);
            b++;
        }
        int total = n + n2;
        if(total%2==0){
            //偶数
            return (double)(list.get(total/2)+list.get(total/2-1))/(2.0);
        }else{
            return (double)list.get(total/2);
        }
    }
}