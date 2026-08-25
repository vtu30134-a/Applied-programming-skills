class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Current temperature is warmer
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            // Store current index
            stack.push(i);
        }

        return result;
    }
}
