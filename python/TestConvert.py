"""
选中以下代码后，提问：将代码转换成python
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

    提问2：将以上排序算法改为冒泡排序
    提问3：将以上排序算法改为更高效的算法

"""

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[0]
    less = [x for x in arr[1:] if x <= pivot]
    greater = [x for x in arr[1:] if x > pivot]
    return quick_sort(less) + [pivot] + quick_sort(greater)
"""""
def main():
    # 定义一个待排序的数组
    arr = [5, 2, 8, 3, 1, 6, 4]

    # 调用快速排序算法
    arr = quick_sort(arr)

    # 打印排序后的数组
    print("排序后的数组：", arr)

if __name__ == "__main__":
    main()
"""""