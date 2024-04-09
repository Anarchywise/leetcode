class Solution:
    def convert(self, s: str, numRows: int) -> str:
        re = ["" for _ in numRows]
        i =0; flag = -1
        for m in s:
            re[i] += m
            if i==0 or i== numRows -1:flag = -flag
            else: i += flag
        
        return "".join(row for row in re) 