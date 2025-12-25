package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListGenerator {
    //Список случайных чисел
    public static List<Integer> generateRandomList(int n) {
        List<Integer> list = new ArrayList<>(n);
        Random rand = new Random(42);
        for (int i = 0; i < n; i++) {
            list.add(rand.nextInt(n));
        }
        return list;
    }

    //Почти отсортированный список (один элемент в середине не на своем месте)
    public static List<Integer> generateAlmostSortedList(int n) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int mid = n / 2;
        if (mid != 0) {
            Collections.swap(list, mid, list.size()-1);
        }
        return list;
    }

    //Почти отсортированный в обратную сторону список
    public static List<Integer> generateAlmostReverseSortedList(int n) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = n - 1; i >= 0; i--) {
            list.add(i);
        }

        int mid = n / 2;
        if (mid != 0) {
            Collections.swap(list, mid, 0);
        }
        return list;
    }

    //Половина данных равна 0, другая половина 1
    public static List<Integer> generateHalfZeroHalfOneList(int n) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i < n / 2 ? 0 : 1);
        }
        Collections.shuffle(list, new Random(42));
        return list;
    }

    //Первые 95% списка упорядочены, последние 5% - случайные значения
    public static List<Integer> generate95PercentSortedList(int n) {
        List<Integer> list = new ArrayList<>(n);
        // Упорядоченная часть
        for (int i = 0; i < (int) (n * 0.95); i++) {
            list.add(i);
        }
        // Случайная часть
        Random rand = new Random(42);
        for (int i = (int) (n * 0.95); i < n; i++) {
            list.add(rand.nextInt(n));
        }
        return list;
    }

    //Все элементы находятся в пределах 10 позиций от окончательного места
    public static List<Integer> generateNearlySortedList(int n) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // Делаем ограниченные перестановки
        Random rand = new Random(42);
        for (int i = 0; i < n; i++) {
            int swapWith = i + rand.nextInt(21) - 10; // +/- 10 позиций
            if (swapWith >= 0 && swapWith < n) {
                Collections.swap(list, i, swapWith);
            }
        }
        return list;
    }
}
