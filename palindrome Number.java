# LeetCode 9 - Palindrome Number

## Approach

A palindrome number reads the same from left to right and right to left.

### Algorithm

1. If the number is negative, return `false` because negative numbers are not palindromes.
2. Store the original number.
3. Reverse the digits of the number.
4. Compare the reversed number with the original number.
5. If both are equal, return `true`; otherwise, return `false`.

## Java Solution

```java
class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int original = x;
        int reverse = 0;

        while (x != 0) {
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x = x / 10;
        }

        return original == reverse;
    }
}
```

## Example

### Input

```text
121
```

### Output

```text
true
```

### Explanation

- Original Number = 121
- Reversed Number = 121
- Since both are equal, the number is a palindrome.

---

### Input

```text
-121
```

### Output

```text
false
```

### Explanation

Negative numbers are not palindromes because of the '-' sign.

---

### Input

```text
10
```

### Output

```text
false
```

### Explanation

Reverse of 10 is 1, which is not equal to 10.

---

## Complexity Analysis

- **Time Complexity:** `O(log₁₀ n)`
- **Space Complexity:** `O(1)`

## Key Concepts

- Modulus Operator (`%`)
- Integer Division (`/`)
- Reverse Number
- Number Comparison
