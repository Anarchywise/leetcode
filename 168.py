from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left = 0
        right = len(numbers)-1
        while True:
            total = numbers[left]+numbers[right]
            if  total == target:
                return[left+1,right+1]
            # left->  right o
            if total<target: left+=1
            # left o right<-
            if total>target: right-=1
           