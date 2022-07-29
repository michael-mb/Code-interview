public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(numbers));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;

        int maxArea = 0;
        for(int i=0; i < height.length; i++) {
            maxArea = Math.max(maxArea, (right - left) * (Math.min(height[left], height[right])));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}