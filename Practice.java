

//rubbish!!!!!
public class Practice {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5, 6, 7, 8, 9};      // 7, 8, 9, 1, 2, 3, 4, 5, 6
        int n = arr.length;
        int k = 3;
        k = k % n;
        int left = 0;
        int right = n-1;
        for (int el : arr){
            System.out.print(" "+ el);
        }
        System.out.println();
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for (int el : arr){
            System.out.print(" "+ el);
        }

    }
}