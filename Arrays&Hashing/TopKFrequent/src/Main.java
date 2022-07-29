public class Main {
    public static void main(String[] args) {
        int[] nums = {5,5,5,4,4,4,4,1,1,1,2,2,3,3,3,3,3,3,3,3};
        int k=2;
        printArray(topKFrequent(nums,k));
    }

    public static void printArray(int [] array){
        System.out.print("[ ");
        for (int j : array) System.out.print(j + " ");
        System.out.print("]");
    }

    /**
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int[] solution = new int[k];
        for(int i=0; i < k; i++){
            for (int num : nums) {
                if (num == -9999)
                    continue;
                if (count(nums, num , solution[i]))
                    solution[i] = num;
            }

            replaceAll(nums, solution[i]);
        }
        return solution;
    }

    public static boolean count(int[] nums, int j , int k){
      int countj = 0;
      int countk = 0;
        for (int num : nums) {
            if (num == k)
                countk++;
            if(num == j)
                countj++;
        }
      return countj > countk;
    };

    public static int[] replaceAll(int[] nums, int k){
        for (int i=0; i < nums.length; i++) {
            if (nums[i] == k)
                nums[i] = -9999;
        }
        return nums;
    }
}