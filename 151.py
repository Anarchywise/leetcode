class Solution:
    def reverseWords(self, s: str) -> str:
        # 使用空格将字符串分割成单词列表，并过滤掉空字符串
        words = s.split()

        # 将单词列表逆序排列，并用空格连接成字符串
        return " ".join(words[::-1])
