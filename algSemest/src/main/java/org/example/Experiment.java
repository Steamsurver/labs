package org.example;

import java.util.ArrayList;
import java.util.List;

public class Experiment {
    public static long measureSortingTime(List<Integer> list) {
        // Создаем копию, чтобы не изменять оригинальный список
        List<Integer> copy = new ArrayList<>(list);

        // Разогрев JVM
        for (int i = 0; i < 3; i++) {
            List<Integer> warmup = new ArrayList<>(copy);
            Sort.mergeSort(warmup);
        }

        // Основное измерение
        long startTime = System.nanoTime();
        Sort.mergeSort(copy);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000; // Возвращаем время в миллисекундах
    }

}
