package LeetCode;

public class BestTimeToBuyAndSellStock {

    //URL:/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int overAllProfit = 0;
        int daysProfit = 0;
        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            }
            daysProfit = price - lowestPrice;
            if (daysProfit > overAllProfit) {
                overAllProfit = daysProfit;
            }
        }
        return overAllProfit;
    }
}
