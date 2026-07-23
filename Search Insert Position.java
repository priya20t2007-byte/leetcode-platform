# LeetCode 35 - Search Insert Position

## Approach

Since the array is **sorted** and the required time complexity is **O(log n)**, we use **Binary Search**.

Binary Search repeatedly divides the search space into two halves:

- If the middle element equals the target, return its index.
- If the target is smaller than the middle element, search the left half.
- Otherwise, search the right half.
- If the target is not found, the `left` pointer will indicate the correct insertion position.

## Algorithm

1. Initialize two pointers:
   - `left = 0`
   - `right = nums.length - 1`
2. While `left <= right`:
   - Find the middle index.
   - If `nums[mid] == target`, return `mid`.
   - If `nums[mid] < target`, search the right half.
   - Otherwise, search the left half.
3. If the loop ends without finding the target, return `left`.

---

## Java Solution

```java
class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return left;
    }
}
```

---

## Example 1

### Input

```text
nums = [1,3,5,6]
target = 5
```

### Output

```text
2
```

### Explanation

The target `5` is found at index `2`.

---

## Example 2

### Input

```text
nums = [1,3,5,6]
target = 2
```

### Output

```text
1
```

### Explanation

The target `2` is not present. It should be inserted at index `1` to maintain the sorted order.

---

## Example 3

### Input

```text
nums = [1,3,5,6]
target = 7
```

### Output

```text
4
```

### Explanation

The target is greater than all elements, so it should be inserted at the end of the array.

---

## Complexity Analysis

- **Time Complexity:** `O(log n)`
- **Space Complexity:** `O(1)`

---

## Key Concepts

- Binary Search
- Sorted Array
- Divide and Conquer
- Search Algorithm
- Logarithmic Time Complexity
