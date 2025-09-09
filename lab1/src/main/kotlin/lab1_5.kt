
fun main() {
    val array = intArrayOf(1, 3, 2, 5, 4, 6, 3, 2);

    println("Изначальный массив: ${array.contentToString()}");

    println("Цикл for:");
    printFilterFor(array);

    println("Цикл while:");
    printFilterWhile(array);

    println("Оператор forEach:");
    printFilterForEach(array);

    println("Цикл for для произведения элементов:");
    multipleFor(array);

    println("Цикл while для произведения элементов:");
    multipleWhile(array);

    println("Оператор forEach для произведения элементов:");
    multipleForEach(array)

    println("Функция reduce() для произведения элементов и использование min() и max():");
    multipleReduceFunc(array)
}

//---------------------------------------------------------------------
fun printFilterFor(array: IntArray){

    for (i in 1 until array.size - 1) {
        if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
            print("${array[i]} ");
        }
    }
    println();
}
//---------------------------------------------------------------------
fun printFilterWhile(array: IntArray) {
    var iter: Int = 1;
    while (iter < array.size) {
        if (array[iter] > array[iter - 1] && array[iter] > array[iter + 1]) {
            print("${array[iter]} ");
        }
        iter++;
    }
    println();
}
//---------------------------------------------------------------------
fun printFilterForEach(array: IntArray) {
    array.forEachIndexed { index, value ->
        if (index > 0 && index < array.size - 1
            && array[index] > array[index - 1] && array[index] > array[index + 1])
            print("$value ");
    }
    println();
}
//---------------------------------------------------------------------
fun multipleFor(array: IntArray){
    var multipleNum: Int = 1;
    var min :Int = array[0];
    var max :Int = array[0];


    for(i in 0 until array.size){
        if (array[i] < min) min = array[i];
        if (array[i] > max) max = array[i];
        multipleNum *= array[i];
    }

    println("Максимум:$max    Минимум:$min    Произведение:$multipleNum");
}
//---------------------------------------------------------------------
fun multipleWhile(array: IntArray){
    var multipleNum: Int = 1;
    var min :Int = array[0];
    var max :Int = array[0];
    var iter: Int = 0;

    while (iter < array.size) {
        if (array[iter] < min) min = array[iter];
        if (array[iter] > max) max = array[iter];
        multipleNum *= array[iter];

        iter++;
    }

    println("Максимум:$max    Минимум:$min    Произведение:$multipleNum");
}
//---------------------------------------------------------------------
fun multipleForEach(array: IntArray){
    var multipleNum: Int = 1;
    var min :Int = array[0];
    var max :Int = array[0];

    array.forEach { value ->
        if (value < min) min = value;
        if (value > max) max = value;
        multipleNum *= value;
    }
    println("Максимум:$max    Минимум:$min    Произведение:$multipleNum");
}
//---------------------------------------------------------------------
fun multipleReduceFunc(array: IntArray){
    var multipleNum: Int = 1;
    val min = array.minOrNull();
    val max = array.maxOrNull();
    multipleNum = array.reduce { acc, num-> acc * num}
    println("Максимум:$max    Минимум:$min    Произведение:$multipleNum");
}
//---------------------------------------------------------------------

/*
Дан массив из целых чисел. Вывести на экран элементы массива, которые
больше соседних (предыдущего и следующего) элементов массива.
Если элемент первый или последний, то его не выводить. Выполнить с использованием:
— цикла for;
— цикла while;
— оператора forEach.
Дан массив с элементами. Найдите произведение элементов этого массива,
а также min и max элемент. Выполнить с использованием:
— цикла for;
— цикла while;
— оператора forEach;
— функции reduce();
— функций min() max().
*/