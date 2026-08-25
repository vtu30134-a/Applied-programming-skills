class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        // Traverse twice because the array is circular
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;

            // Find the next greater element
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                result[stack.pop()] = nums[index];
            }

            // Only push during the first traversal
            if (i < n) {
                stack.push(index);
            }
        }

        return result;
    }
}
