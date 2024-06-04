class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = lenA - 1, j = lenB - 1;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            carry = sum / 2;
            result.append(sum % 2);
        }
        
        if (carry != 0) {
            result.append(carry);
        }
        
        return result.reverse().toString();
    }
}
