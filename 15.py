class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        ans = list()
        
        # 枚举 a
        for i in range(n):
            # 需要和上一次枚举的数不相同
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            # c 对应的指针初始指向数组的最右端
            r = n - 1
            target = -nums[i]
            # 枚举 b
            for l in range(i + 1, n):
                # 需要和上一次枚举的数不相同
                if l > i + 1 and nums[l] == nums[l - 1]:
                    continue
                # 需要保证 b 的指针在 c 的指针的左侧
                while l < r and nums[l] + nums[r] > target:
                    r -= 1
                # 如果指针重合，随着 b 后续的增加
                # 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if l == r:
                    break
                if nums[l] + nums[r] == target:
                    ans.append([nums[i], nums[l], nums[r]])
        
        return ans