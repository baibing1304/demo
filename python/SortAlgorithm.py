class SortAlgorithm:
    @staticmethod
    def selection_sort(arr):
        """
        对整型列表进行选择排序

        :param arr: 需要排序的整型列表
        """
        n = len(arr)
        for i in range(n):
            min_idx = i
            for j in range(i + 1, n):
                if arr[j] < arr[min_idx]:
                    min_idx = j
            arr[i], arr[min_idx] = arr[min_idx], arr[i]

    @staticmethod
    def insertion_sort(arr):
        """
        使用插入排序算法对列表进行排序。

        :param arr: 要排序的列表
        """
        n = len(arr)
        for i in range(1, n):
            temp = arr[i]
            j = i - 1
            while j >= 0 and temp < arr[j]:
                arr[j + 1] = arr[j]
                j -= 1
            arr[j + 1] = temp

    @staticmethod
    def quick_sort(arr, left, right):
        """
        实现快速排序算法。

        :param arr: 要排序的列表
        :param left: 要排序的列表段的左索引
        :param right: 要排序的列表段的右索引
        """
        def partition(arr, left, right):
            i = left
            j = right
            pivot = arr[left]
            while i < j:
                while i < j and arr[j] >= pivot:
                    j -= 1
                arr[i] = arr[j]
                while i < j and arr[i] <= pivot:
                    i += 1
                arr[j] = arr[i]
            arr[i] = pivot
            return i

        if left < right:
            p = partition(arr, left, right)
            SortAlgorithm.quick_sort(arr, left, p - 1)
            SortAlgorithm.quick_sort(arr, p + 1, right)