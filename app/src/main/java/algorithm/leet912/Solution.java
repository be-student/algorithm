package algorithm.leet912;

class Solution {


    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int midIndex = (leftIndex + rightIndex) / 2;
        mergeSort(nums, leftIndex, midIndex);
        mergeSort(nums, midIndex + 1, rightIndex);
        merge(nums, leftIndex, rightIndex, midIndex);
    }

    private void merge(int[] nums, int leftIndex, int rightIndex, int midIndex) {
        int lIndex = leftIndex;
        int rIndex = midIndex + 1;
        int[] tmp = new int[rightIndex - leftIndex + 1];
        int tIndex = 0;
        while (lIndex <= midIndex && rIndex <= rightIndex) {
            if (nums[lIndex] < nums[rIndex]) {
                tmp[tIndex++] = nums[lIndex++];
            } else {
                tmp[tIndex++] = nums[rIndex++];
            }
        }
        while (lIndex <= midIndex) {
            tmp[tIndex++] = nums[lIndex++];
        }
        while (rIndex <= rightIndex) {
            tmp[tIndex++] = nums[rIndex++];
        }
        System.arraycopy(tmp, 0, nums, leftIndex, tmp.length);
    }
}
