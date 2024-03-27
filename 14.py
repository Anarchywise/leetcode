from ast import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix = strs[0]
        for s in strs[1:]:
            prefix = self.returnPrefix(prefix, s)
            if not prefix:
                return ""
        return prefix

    def returnPrefix(self, str1: str, str2: str) -> str:
        length = min(len(str1), len(str2))
        i = 0
        while i < length and str1[i] == str2[i]:
            i += 1
        return str1[:i]
