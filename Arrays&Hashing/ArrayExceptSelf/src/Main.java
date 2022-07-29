public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        printArray(productExceptSelfEasy(nums));
    }

    /**
     * Example 1:
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     *
     * Example 2:
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        for (int i=0; i < nums.length; i++){
            int mul = 1;
            for(int j=0; j < nums.length; j++){
                if(j==i || nums[j] == 1)
                    continue;
                if(nums[j] == 0)
                    mul = 0;
                else
                    mul *= nums[j];
            }
            solution[i] = mul;
        }
        return solution;
    }

    public static int[] productExceptSelfEasy(int[] nums) {
        int[] solution = nums.clone();
        int prefix = 1 , postfix = 1;
        for (int i=0; i < nums.length; i++){
            solution[i] = prefix;
            prefix *= nums[i];
        }

        for (int i= nums.length -1; i >= 0; i--){
            solution[i] = postfix * solution[i];
            postfix *= nums[i];
        }

        return solution;
    }

    public static void printArray(int [] array){
        System.out.print("[ ");
        for (int j : array) System.out.print(j + " ");
        System.out.print("]");
    }
}