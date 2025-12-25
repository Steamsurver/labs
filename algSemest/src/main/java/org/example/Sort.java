package org.example;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Sort {
    public static void mergeSort(List<Integer> someList) {
        if (someList == null || someList.size() <= 1) {
            return;
        }

        // Преобразуем List в массив для более эффективной работы
        int[] array = new int[someList.size()];
        for (int i = 0; i < someList.size(); i++) {
            array[i] = someList.get(i);
        }

        // Сортируем массив
        mergeSort(array, 0, array.length - 1);

        // Копируем отсортированный массив обратно в список
        for (int i = 0; i < array.length; i++) {
            someList.set(i, array[i]);
        }
    }


    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Безопасное вычисление середины

            // Рекурсивно сортируем левую и правую половины
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Сливаем отсортированные половины
            merge(array, left, mid, right);
        }
    }


    //Слияние двух отсортированных подмассивов
    private static void merge(int[] array, int left, int mid, int right) {
        // Размеры временных массивов
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Создаем временные массивы
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Копируем данные во временные массивы
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Индексы для слияния
        int i = 0, j = 0, k = left;

        // Сливаем временные массивы обратно в основной массив
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Копируем оставшиеся элементы левого массива
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Копируем оставшиеся элементы правого массива
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
