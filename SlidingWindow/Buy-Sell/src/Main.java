public class Main {
    public static void main(String[] args) {
        //int[] prices = {7,1,5,3,6,4};
        //int[] prices = {1,2};
        int[] prices = {3,2,6,5,0,3};
        //int[] prices = {1,2,4,2,5,7,2,4,9,0,9};
        System.out.println(maxProfit(prices));
    }

    public  static int maxProfit(int[] prices) {
        int leftCursor = 0;
        int rightCursor = 1;
        int max = 0;

        while (rightCursor < prices.length){
            if (prices[rightCursor] - prices[leftCursor] <= 0){
                leftCursor ++;
                if(leftCursor == rightCursor)
                    rightCursor ++;
            }
            else if(prices[rightCursor] - prices[leftCursor] > 0){
                max = Math.max(max, prices[rightCursor] - prices[leftCursor]);
                rightCursor ++;
            }
        }
        return max;
    }
}