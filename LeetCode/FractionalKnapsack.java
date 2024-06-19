package LeetCode;

//URL:https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

import java.util.Arrays;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack {
    double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, (item1, item2)-> {
            double item1Val = (double) item1.value /(double)item1.weight;
            double item2Val = (double) item2.value /(double)item2.weight;
            return Double.compare(item2Val, item1Val);
        });
        int currentWeight = 0;
        double maxVal = 0.0;
        for(Item item : arr){
            if(item.weight + currentWeight <= w){
                currentWeight += item.weight;
                maxVal += item.value;
            }
            else{
                int remainingWeight = w - currentWeight;
                maxVal += ((double) item.value /item.weight) * (double)remainingWeight;
                break;
            }
        }
        return maxVal;
    }
}
