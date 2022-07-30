public class Main {
    public static void main(String[] args) {
        int[] heights = {4,2,0,3,2,5};

        System.out.println("SOLUTION: "+trap(heights));
    }

    public static int trap(int[] height) {
        int rain = 0, left = 0, right = height.length -1 ;

        int[] maxLeft = new int[height.length], maxRight= new int[height.length];
        int[] minLR = new int[height.length];

        maxLeft[0] = 0;
        maxRight[height.length -1] = 0;
        for(int i=1; i < height.length; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }

        for (int i= height.length - 2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }

        for (int i= 0; i < height.length; i++){
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
        }

        for(int i=0; i < height.length; i++){
            int currentRain = minLR[i] - height[i];
            if(currentRain < 0)
                currentRain = 0;
            rain += currentRain ;
        }
        return rain;
    }

    public static void printArray(int [] array){
        System.out.print("[ ");
        for(int i=0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.print("]");
        System.out.println();
    }
}