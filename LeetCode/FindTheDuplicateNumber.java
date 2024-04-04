package LeetCode;

//URL:/problems/find-the-duplicate-number/
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {                                     // Concept behind this loop is "FLOYD'S CYCLE DETECTION ALGO"
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {                  //👇 Concept behind this loop 👇
            slow = nums[slow];                  // 2 * slow = fast
            fast = nums[fast];                  //  2(P + C - x) = P + C - x + nC
        }                                       //  P = x
        return slow;
    }
}
