# LeetCode 8 - String to Integer (atoi)

## Approach

1. Skip all leading whitespace characters.
2. Check for an optional '+' or '-' sign to determine the number's sign.
3. Read consecutive digit characters and build the integer.
4. Before adding each digit, check for overflow.
5. If the value exceeds the 32-bit signed integer range, return:
   - `Integer.MAX_VALUE` for positive overflow.
   - `Integer.MIN_VALUE` for negative overflow.
6. Return the final integer with the correct sign.

## Java Solution

```java
class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Determine sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        int num = 0;

        // Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (num > Integer.MAX_VALUE / 10 ||
               (num == Integer.MAX_VALUE / 10 && digit > 7)) {

                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }
}
```

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

## Key Concepts

- String Traversal
- Character Handling
- Overflow Detection
- Simulation
