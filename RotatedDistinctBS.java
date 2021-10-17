public class RotatedBS {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(search(arr, 6));
    }
    //now, we have to write code for Binary search
    static int search(int[] nums, int target) {
        int pivot = Findpivot(nums);
        //if you did not find a pivot, it means the given array is not rotated
        //in this case just do simple Binary Search
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
            //if pivot is found, then you have found 2 ascending sorted array
            if (nums[pivot] == target) {
                return pivot;
            }
            if (nums[0] <= target) {
                return binarySearch(nums, target, 0, pivot - 1);
            } else {
                return binarySearch(nums, target, pivot + 1, nums.length - 1);
            }
        }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(target < arr[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
    //firstly we have to find pivot of the given rotated Sorted Array
    static int Findpivot(int[] arr) {
        int start = 0;  // start stand for start
        int end = arr.length - 1;  // end stands for end
        while (start <= end) {
            int mid = start + (end - start) / 2;  // mid stands for mid

            // 4 cases to find pivot as we discussed
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}



