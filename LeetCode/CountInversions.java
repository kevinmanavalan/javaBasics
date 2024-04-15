package LeetCode;


//URL:https://www.naukri.com/code360/problems/count-inversions_615

public class CountInversions {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        return (long) sort(arr, 0, n - 1);
    }

    public static int sort(long arr[], int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) / 2;
        count += sort(arr, low, mid);
        count += sort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    public static int merge(long arr[], int low, int mid, int high) {
        int count = 0;
        long[] temp = new long[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                count += (mid - left + 1);
            }
        }
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
        return count;
    }

    public static void main(String args[]) {
        System.out.println(getInversions(new long[]{52244275, 123047899, 493394237, 922363607, 378906890, 188674257, 222477309, 902683641, 860884025, 339100162}, 10));
    }
}