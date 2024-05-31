import java.util.Random;

class Solution {
    private final Random random = new Random();
    //快速排序, 某次划分 基准为k-1即找到了
    public int findKthLargest(int[] nums, int k) {
        int index = fastSort(nums, 0, nums.length-1, k);
        return nums[index];
    }

    public int fastSort(int[] nums,int l,int r,int k){
        if (l == r) {
            return l;
        }
        int[] partitionIndexes = partition(nums, l, r);
        int low = partitionIndexes[0];
        int high = partitionIndexes[1];

        if (k - 1 >= low && k - 1 <= high) {
            return k - 1;
        } else if (k - 1 < low) {
            return fastSort(nums, l, low - 1, k);
        } else {
            return fastSort(nums, high + 1, r, k);
        }
    }
    /*
     * 在遇到一串超级长的 1 的时候，快速排序的最坏情况（时间复杂度为 O(n^2)）
     * 会变得非常明显，因为每次划分都非常不均匀。为了解决这个问题，
     * 可以采用三路快速排序的方法进行优化。三路快速排序可以将数组划分为三部分：
     * 小于、等于和大于基准值的部分，从而提高效率qa。
     */
    public int[] partition(int[] nums,int l,int r){
        //随机化
        int pivotIndex = l + random.nextInt(r - l + 1);
        int base = nums[pivotIndex];
        //将基准放在最前面或者最后面,不遍历这个数
        //最后将index 和 基准调换
        //放在后面就是直接和index 调换 ,放在前面和index-1调换
        int lowBound = l;     // nums[left..lt-1] > pivot
        int highBound = r;    // nums[gt+1..right] < pivot
        int i = l;      // nums[lt..i-1] == pivot

        //当 i 大于 hightBound时 就排好序了
        while (i <= highBound) {
            if (nums[i] > base) {
                // 如果 i> lowBound i到lowBound 范围内的数都等于base 
                swap(nums, lowBound++, i++);
            } else if (nums[i] < base) {
                //小于 不断与右边的交换直到 i 上的数字大于等于 base
                swap(nums, i, highBound--);
            } else {
                i++;
            }
        }

        return new int[]{lowBound, highBound};
    }
    public void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}