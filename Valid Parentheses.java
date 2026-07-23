# LeetCode 20 - Valid Parentheses

## Approach

A stack is used to keep track of opening brackets. Whenever an opening bracket is encountered, push it onto the stack. When a closing bracket is encountered, check whether it matches the top element of the stack. If it does not match or the stack is empty, return `false`. After processing all characters, the stack should be empty for the string to be valid.

### Algorithm

1. Create an empty stack.
2. Traverse each character in the string.
3. If the character is an opening bracket (`(`, `{`, `[`), push it onto the stack.
4. If the character is a closing bracket:
   - If the stack is empty, return `false`.
   - Pop the top element from the stack.
   - Check if it matches the corresponding opening bracket.
   - If it does not match, return `false`.
5. After traversing the string, return `true` if the stack is empty; otherwise, return `false`.

## Java Solution

```java
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
```

## Example

### Input

```text
s = "()"
```

### Output

```text
true
```

### Explanation

- Push `'('` onto the stack.
- Encounter `')'`, pop `'('`.
- Stack becomes empty.
- Therefore, the string is valid.

---

### Input

```text
s = "()[]{}"
```

### Output

```text
true
```

### Explanation

All opening brackets are closed in the correct order with matching types.

---

### Input

```text
s = "(]"
```

### Output

```text
false
```

### Explanation

The opening bracket `'('` does not match the closing bracket `']'`.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
  - `n` = Length of the string
- **Space Complexity:** `O(n)`
  - In the worst case, all characters are opening brackets and are stored in the stack.

## Key Concepts

- Stack
- LIFO (Last In, First Out)
- String Traversal
- Bracket Matching
