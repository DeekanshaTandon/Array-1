//Time Complexity : O(n)
//Passed all Test Cases on Leet Code .
class Solution {
    //we are not allowed to use division operation.
    // can make use of the product of all the numbers to the left and all the numbers to the right of the index. Multiplying these two individual products
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        //we have initailly constructed two empty arrays
        int[] L = new int[length];
        int[] R = new int[length];
        //anpther array to store the final result .
        int[] answer = new int[length];
        // L[i] contains the product of all the elements to the left
        // For the element at index '0', there are no elements to the left,
        // so L[0] would be 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        //we do the same thing but in reverse
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
}