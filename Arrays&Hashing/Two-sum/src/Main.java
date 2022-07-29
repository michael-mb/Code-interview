public class Main {
    public static void main(String[] args) {
        int[] array = {3,2,4};
        int target = 6;

        printArray(twoSum(array,target));
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        boolean find = false;
        for(int i=0; i< nums.length; i++){
            for(int j=0; j< nums.length; j++){
                if (nums[i] + nums[j] == target && i != j) {
                    result[0] = i;
                    result[1] = j;
                    find = true;
                }
            }
            if(find){
                break;
            }
        }

        return result;
    }

    public static void printArray(int [] array){
        System.out.print("[ ");
        for(int i=0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.print("]");
    }
}
