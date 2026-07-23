# LeetCode 58 - Length of Last Word

## Approach

Traverse the string from the end.

1. Skip any trailing spaces.
2. Count the characters of the last word until a space or the beginning of the string is reached.
3. Return the count.

This approach scans the string only once from the end and uses constant extra space.

## Algorithm

1. Initialize `length = 0`.
2. Start from the last character of the string.
3. Skip all trailing spaces.
4. Count characters until a space is encountered.
5. Return the length.

---

## Java Solution

```java
class Solution {
    public int lengthOfLastWord(String s) {

        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
```

---

## Example 1

### Input

```text
s = "Hello World"
```

### Output

```text
5
```

### Explanation

The last word is `"World"`, which contains **5** characters.

---

## Example 2

### Input

```text
s = "   fly me   to   the moon  "
```

### Output

```text
4
```

### Explanation

The last word is `"moon"`, which contains **4** characters.

---

## Example 3

### Input

```text
s = "luffy is still joyboy"
```

### Output

```text
6
```

### Explanation

The last word is `"joyboy"`, which contains **6** characters.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Key Concepts

- String Traversal
- Character Comparison
- Reverse Iteration
- String Manipulation
