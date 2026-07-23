# LeetCode 14 - Longest Common Prefix

## Approach

The first string is considered as the initial prefix. Compare it with every other string in the array. If a string does not start with the current prefix, remove the last character from the prefix until it matches. If the prefix becomes empty, return an empty string.

### Algorithm

1. If the array is empty, return an empty string.
2. Initialize the prefix as the first string.
3. Traverse the remaining strings.
4. While the current string does not start with the prefix:
   - Remove the last character from the prefix.
   - If the prefix becomes empty, return `""`.
5. Return the final prefix.

## Java Solution

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
```

## Example

### Input

```text
strs = ["flower","flow","flight"]
```

### Output

```text
"fl"
```

### Explanation

- Initial Prefix = `"flower"`
- Compare with `"flow"` → Prefix becomes `"flow"`
- Compare with `"flight"` → Prefix becomes `"fl"`
- Final common prefix = `"fl"`

---

### Input

```text
strs = ["dog","racecar","car"]
```

### Output

```text
""
```

### Explanation

There is no common prefix among all strings.

---

## Complexity Analysis

- **Time Complexity:** `O(n × m)`
  - `n` = Number of strings
  - `m` = Length of the shortest string
- **Space Complexity:** `O(1)`

## Key Concepts

- String Manipulation
- Prefix Matching
- `startsWith()`
- `substring()`
- Iteration
