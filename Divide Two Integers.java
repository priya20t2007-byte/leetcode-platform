# LeetCode 29 - Divide Two Integers

## Approach

Since multiplication (`*`), division (`/`), and modulus (`%`) operators are not allowed, we use **Bit Manipulation**.

The idea is to repeatedly subtract the largest possible multiple of the divisor from the dividend. This multiple is found by left-shifting (`<<`) the divisor until it is just smaller than or equal to the remaining dividend.

### Algorithm

1. Handle the overflow case:
   - If `dividend == Integer.MIN_VALUE` and `divisor == -1`, return `Integer.MAX_VALUE`.
2. Determine the sign of the result.
3. Convert both numbers to `long` and take their absolute values.
4. While the dividend is greater than or equal to the divisor:
   - Find the largest shifted divisor.
   - Subtract it from the dividend.
   - Add the corresponding multiple to the quotient.
5. Apply the correct sign and return the quotient.

---

## Java Solution

```java
class Solution {

    public int divide(int dividend, int divisor) {

        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        while (dvd >= dvs) {

            long temp = dvs;
            int multiple = 1;

            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}
```

---

## Example 1

### Input

```text
dividend = 10
divisor = 3
```

### Output

```text
3
```

### Explanation

```text
10 - 6 = 4
4 - 3 = 1

Quotient = 3
```

The fractional part is discarded.

---

## Example 2

### Input

```text
dividend = 7
divisor = -3
```

### Output

```text
-2
```

### Explanation

```text
7 / -3 = -2.333...

After truncating toward zero:

Answer = -2
```

---

## Example 3

### Input

```text
dividend = -2147483648
divisor = -1
```

### Output

```text
2147483647
```

### Explanation

The actual result exceeds the 32-bit signed integer range, so return `Integer.MAX_VALUE`.

---

## Complexity Analysis

- **Time Complexity:** `O(log² n)`
- **Space Complexity:** `O(1)`

---

## Key Concepts

- Bit Manipulation (`<<`)
- Repeated Subtraction
- Overflow Handling
- Sign Management
- Integer Arithmetic
