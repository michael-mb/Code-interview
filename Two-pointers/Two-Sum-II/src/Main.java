import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,3,4,5,7,10,11,15};
        int target = 9;
        printArray(twoSum(numbers , target));
    }

    public static void printArray(int [] array){
        System.out.print("[ ");
        for(int i=0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.print("]");
    }

    /**
     *
     * Example 1:
     *
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
     * Example 2:
     *
     * Input: numbers = [2,3,4], target = 6
     * Output: [1,3]
     * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
     * Example 3:
     *
     * Input: numbers = [-1,0], target = -1
     * Output: [1,2]
     * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Arrays.sort(numbers);
        int leftPointer = 0;
        int rightPointer = numbers.length -1;
        for(int i=0; i< numbers.length; i++){
            if(numbers[leftPointer] + numbers[rightPointer] > target){
                rightPointer --;
            }
            else if(numbers[leftPointer] + numbers[rightPointer] < target){
                leftPointer ++;
            }
            else{
                result[0] = leftPointer +1;
                result[1] = rightPointer +1;
                break;
            }
        }
        return result;
    }
}