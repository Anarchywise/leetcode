class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        for i in range(len(haystack)):
            n = 0
            for s in needle:
                if(i+n<len(haystack)):
                    if s == haystack[i+n]: n+=1 
                    else: break
            if(n == len(needle)): return i
            n = 0
        return -1
