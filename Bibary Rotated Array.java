public class RotatedBSDuplicate {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        System.out.println(PivotBS(arr,1));
    }

    //now, we have to write code for Binary search
    static int PivotBS(int[] arr, int target) {
        int pivot = FindPivotwithDuplicate(arr);
        //if you did not find a pivot, it means the given array is not rotated
        //in this case just do simple Binary Search
        if (pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }
        //if pivot is found, then you have found 2 ascending sorted array
        if (arr[pivot] == target) {
            return pivot;
        }
        if (arr[0] <= target) {
            return binarySearch(arr, target, 0, pivot - 1);
        } else {
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
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
    //This code is used when there are duplicates elements in the given arr
    static int FindPivotwithDuplicate(int[] arr) {
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
            //if element at middle, start and end are equal then just skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]) {
                //skip the duplicates
                //NOTE: Necessarily check that elements at start and end are the pivot or not?
                //check if start is pivot
                if(arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                //check if end is pivot
                if(arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
                //left side is sorted, so pivot should be in right
                if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}
