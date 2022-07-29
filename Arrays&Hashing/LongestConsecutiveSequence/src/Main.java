import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }

    public static void printArray(int [] array){
        System.out.print("[ ");
        for(int i=0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.print("]");

        System.out.println();
    }

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        TreeSet<Integer> seqSet = new TreeSet<>();
        int seq = 0;
        Arrays.sort(nums);
        for(int i=nums.length-1; i > 0; i--){
            if (nums[i] == nums[i-1])
                continue;
            if (nums[i] == (nums[i-1] + 1))
                seq ++;

            else{
                seqSet.add(seq +1);
                seq = 0;
            }
        }
        seqSet.add(seq + 1);

        return seqSet.last();
    }
}