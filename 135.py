from ast import List


# 暴力解法 超时
"""
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        candy = [0] * n
        if n == 1:
            return 1
        r1 = ratings[0]
        r2 = ratings[1]
        if r1 < r2:
            candy[0] = 1
            candy[1] = 2
        elif r1 == r2:
            candy[0] = 1
            candy[1] = 1
        else:
            candy[0] = 2
            candy[1] = 1

        for i in range(2, n):
            if ratings[i] > ratings[i - 1]:
                candy[i] = candy[i - 1] + 1
            elif ratings[i] == ratings[i - 1]:
                candy[i] = 1
            else:
                if candy[i - 1] > 1:
                    candy[i] = 1
                else:
                    candy[i] = 1
                    candy[i - 1] = 2
                    for m in range(i - 1, -1, -1):
                        if ratings[m - 1] > ratings[m] and candy[m - 1] <= candy[m]:
                            candy[m - 1] = candy[m] + 1
                        else:
                            break
        return sum(candy)
"""


class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        candy_num = [0] * n
        if n == 1:
            return 1
        r1 = ratings[0]
        r2 = ratings[1]
        if r1 < r2:
            candy_num[0] = 1
            candy_num[1] = 2
        elif r1 == r2:
            candy_num[0] = 1
            candy_num[1] = 1
        else:
            candy_num[0] = 2
            candy_num[1] = 1
        max_candy = max(candy_num[0], candy_num[1])
        max_candy_position = candy_num.index(max_candy)
        for i in range(2, n):
            if ratings[i] > ratings[i - 1]:
                candy_num[i] = candy_num[i - 1] + 1
            elif ratings[i] == ratings[i - 1]:
                candy_num[i] = 1
            else:
                if candy_num[i - 1] == 1:
                    shoud_max = i - max_candy_position
                    candy_num[max_candy_position + 1, i] + 1
                    candy_num[max_candy_position] = max(shoud_max, max_candy)
            if candy_num[i] > max_candy:
                max_candy = candy_num[i]
                max_candy_position = i
        print(candy_num)
        return sum(candy_num)

    # ratings   123456321
    # candy     123456210
