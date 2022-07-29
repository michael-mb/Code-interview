public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,5,3};
        System.out.println(containsDuplicate(array));
    }

    public static boolean containsDuplicate(int [] nums){
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            i++;

            for(int j=i;  j < nums.length; j++){
                if (x == nums[j]) {
                    return true;
                }
            }

            i--;
        }

        return false;
    }
}
