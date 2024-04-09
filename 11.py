from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        l = 0
        r = len(height)-1
        max_are = 0
        while(l<r):
            max_are = max(max_are,min(height[l],height[r])*(r-l))
            if(height[r]>=height[l]): l+=1
            if(height[r]<height[l]): r-=1
        return max_are