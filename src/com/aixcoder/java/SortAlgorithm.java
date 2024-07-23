package com.aixcoder.java;

public class SortAlgorithm {

/**
* 对整型数组进行选择排序
*
* @param arr 需要排序的整型数组
*/
    public static void selectionSort(int[] arr) {
       // 获取数组的长度
        int n = arr.length;
       // 外层循环，控制循环次数，从0到n-1
        for (int i = 0; i < n; i++) {
           // 假设当前位置是最小值的位置
            int min_idx = i;
           // 内层循环，从i+1开始，比较当前位置的值和剩余部分的最小值
            for (int j = i + 1; j < n; j++) {
               // 如果剩余部分的值小于当前位置的值，则更新最小值的位置
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

           // 交换当前位置的值和最小值的位置的值
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

    /**
     * This method sorts an array using the insertion sort algorithm.
     * @param arr The array to be sorted.
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * This method implements the Quick Sort algorithm.
     * @param arr The array to be sorted.
     * @param left The left index of the array segment to be sorted.
     * @param right The right index of the array segment to be sorted.
     */
    public static void quickSort(int[] arr, int left, int right) {
        // If the left index is less than the right index,
        if (left < right) {
            // Partition the array segment and get the partitioning index.
            int p = partition(arr, left, right);
            // Recursively sort the array segment to the left of the partitioning index.
            quickSort(arr, left, p - 1);
            // Recursively sort the array segment to the right of the partitioning index.
            quickSort(arr, p + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int pivot = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        return i;
    }
}