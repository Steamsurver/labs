package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.Experiment.measureSortingTime;


public class Main extends JFrame {

    private JPanel createChartPanel() {
        // Набор данных для графика
        XYSeriesCollection dataset = new XYSeriesCollection();

        // Массив размеров для тестирования
        int[] sizes = {100000, 200000, 500000, 1000000, 2000000, 3000000, 4000000};

        // Создаем серии для каждого типа данных
        XYSeries randomSeries = new XYSeries("a. Случайные числа");
        XYSeries almostSortedSeries = new XYSeries("b. Почти отсортированный");
        XYSeries almostReverseSeries = new XYSeries("c. Почти обратно отсортированный");
        XYSeries halfZeroHalfOneSeries = new XYSeries("d. 50% нулей, 50% единиц");
        XYSeries percent95SortedSeries = new XYSeries("e. 95% отсортировано, 5% случайны");
        XYSeries nearlySortedSeries = new XYSeries("f. Элементы в пределах 10 позиций");

        // Проводим эксперименты для каждого размера
        for (int n : sizes) {
            System.out.println("Тестирование для n = " + n);

            // a. Случайные числа
            List<Integer> randomList = ListGenerator.generateRandomList(n);
            long randomTime = measureSortingTime(randomList);
            randomSeries.add(n, randomTime);

            // b. Почти отсортированный
            List<Integer> almostSortedList = ListGenerator.generateAlmostSortedList(n);
            long almostSortedTime = measureSortingTime(almostSortedList);
            almostSortedSeries.add(n, almostSortedTime);

            // c. Почти обратно отсортированный
            List<Integer> almostReverseList = ListGenerator.generateAlmostReverseSortedList(n);
            long almostReverseTime = measureSortingTime(almostReverseList);
            almostReverseSeries.add(n, almostReverseTime);

            // d. 50% нулей, 50% единиц
            List<Integer> halfZeroHalfOneList = ListGenerator.generateHalfZeroHalfOneList(n);
            long halfZeroHalfOneTime = measureSortingTime(halfZeroHalfOneList);
            halfZeroHalfOneSeries.add(n, halfZeroHalfOneTime);

            // e. 95% отсортировано, 5% случайны
            List<Integer> percent95SortedList = ListGenerator.generate95PercentSortedList(n);
            long percent95SortedTime = measureSortingTime(percent95SortedList);
            percent95SortedSeries.add(n, percent95SortedTime);

            // f. Элементы в пределах 10 позиций
            List<Integer> nearlySortedList = ListGenerator.generateNearlySortedList(n);
            long nearlySortedTime = measureSortingTime(nearlySortedList);
            nearlySortedSeries.add(n, nearlySortedTime);

            System.out.printf("  Время: %d мс%n", randomTime);
        }

        // Добавляем все серии в dataset
        dataset.addSeries(randomSeries);
        dataset.addSeries(almostSortedSeries);
        dataset.addSeries(almostReverseSeries);
        dataset.addSeries(halfZeroHalfOneSeries);
        dataset.addSeries(percent95SortedSeries);
        dataset.addSeries(nearlySortedSeries);

        // Создаем график[citation:1][citation:7]
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Зависимость времени выполнения сортировки слиянием от размера данных",
                "Размер данных (n)",
                "Время выполнения (мс)",
                dataset,
                PlotOrientation.VERTICAL,
                true,    // включаем легенду
                true,    // tooltips
                false    // URLs
        );


        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // Задаем цвета для разных серий
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.ORANGE);
        renderer.setSeriesPaint(4, Color.MAGENTA);
        renderer.setSeriesPaint(5, Color.CYAN);

        // Задаем толщину линий
        for (int i = 0; i < 6; i++) {
            renderer.setSeriesStroke(i, new BasicStroke(2.0f));
            renderer.setSeriesShapesVisible(i, true);
        }

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);

        return new ChartPanel(chart);
    }

    public Main() {
        super("Эксперимент: Сортировка слиянием");

        JPanel chartPanel = createChartPanel();
        chartPanel.setPreferredSize(new Dimension(1000, 700));

        setContentPane(chartPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        /*List<Integer> list1 = new ArrayList<>(Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1));
        System.out.println("Исходный список: " + list1);
        Sort.mergeSort(list1);
        System.out.println("Отсортированный: " + list1);
        */

        SwingUtilities.invokeLater(() -> {
            Main experiment = new Main();
            experiment.setVisible(true);
        });


    }
}