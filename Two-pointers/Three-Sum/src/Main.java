import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(threeSum2(numbers));
    }

    public static List < List < Integer >> threeSum2(int[] nums) {
        List < List < Integer >> result = new ArrayList < List < Integer >> ();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List < Integer > triplet = new ArrayList < Integer > ();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
        result = new ArrayList < List < Integer >> (new LinkedHashSet< List < Integer >>(result));
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<>();

        int a;
        for(int i=0; i < nums.length - 2 ; i++){
            a = nums[0];
            int[] newNums = remove_Element(nums,0);
            int[] twoSum = twoSum(newNums, a*-1);

            int[] newNumsCopy = newNums.clone();

            while((a + newNumsCopy[twoSum[0]] + newNumsCopy[twoSum[1]]) == 0 && twoSum[0] != twoSum[1]) {

                List<Integer> solution = new ArrayList<>();
                solution.add(a);
                solution.add(newNumsCopy[twoSum[0]]);
                solution.add(newNumsCopy[twoSum[1]]);

                if(!solutions.contains(solution))
                    solutions.add(solution);

                if(nums.length <= 3)
                    break;

                newNumsCopy = remove_Element(newNumsCopy, twoSum[0]);
                newNumsCopy = remove_Element(newNumsCopy, twoSum[1]);

                if(newNumsCopy.length <= 1)
                    break;
                twoSum = twoSum(newNumsCopy, a*-1);
            }

            if(nums != newNums)
                i = 0;

            nums = newNums;
        }
        return solutions;
    }

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
            else if(leftPointer != rightPointer && (numbers[leftPointer] + numbers[rightPointer] == target)){
                result[0] = leftPointer;
                result[1] = rightPointer;
                break;
            }
        }
        return result;
    }

    public static int[] remove_Element(int[] myArray,  int index)
    {
        if(myArray == null || index == myArray.length)
            return myArray;
        List<Integer> arrayList = IntStream.of(myArray) .boxed().collect(Collectors.toList());
        arrayList.remove(index);
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void printArray(int [] array){
        System.out.print("[ ");
        for(int i=0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.print("]");
        System.out.println();
    }
}