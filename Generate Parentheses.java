# LeetCode 22 - Generate Parentheses

## Approach

This problem can be solved using **Backtracking**.

At each step:

- Add an opening parenthesis `'('` if the number of opening brackets used is less than `n`.
- Add a closing parenthesis `')'` only if the number of closing brackets used is less than the number of opening brackets.
- When the length of the current string becomes `2 × n`, add it to the result.

Backtracking explores all possible valid combinations while avoiding invalid ones.

## Algorithm

1. Create an empty list to store the answer.
2. Start with an empty string.
3. If the number of `'('` used is less than `n`, add `'('` and continue.
4. If the number of `')'` used is less than the number of `'('`, add `')'` and continue.
5. When the string length becomes `2 × n`, store it in the answer list.
6. Return the list.

## Java Solution

```java
import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result, String current,
                           int open, int close, int n) {

        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}
```

## Example

### Input

```text
n = 3
```

### Output

```text
["((()))","(()())","(())()","()(())","()()()"]
```

### Explanation

The algorithm generates every valid combination of 3 pairs of parentheses without producing invalid sequences.

---

### Input

```text
n = 1
```

### Output

```text
["()"]
```

---

## Complexity Analysis

- **Time Complexity:** `O(4ⁿ / √n)` (Catalan Number)
- **Space Complexity:** `O(n)` (Recursion Stack)

## Key Concepts

- Backtracking
- Recursion
- String Construction
- Decision Tree
- Depth-First Search (DFS)
