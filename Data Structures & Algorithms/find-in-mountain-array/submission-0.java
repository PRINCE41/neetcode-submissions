/**
 * // This is MountainArray's API interface.
 * // You should not implement it.
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int peak = findPeak(mountainArr, n);

        int leftIndex = binarySearchIncreasing(mountainArr, target, 0, peak);

        if (leftIndex != -1) {
            return leftIndex;
        }

        return binarySearchDecreasing(mountainArr, target, peak + 1, n - 1);
    }

    private int findPeak(MountainArray mountainArr, int n) {
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int binarySearchIncreasing(MountainArray mountainArr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchDecreasing(MountainArray mountainArr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            } else if (value < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}