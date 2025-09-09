fun main(){
    val mathArray = MathArray(intArrayOf(1, -2, 3, 1, 6, 7, 8));
    println(mathArray.array.contentToString());
    println("Сумма позитивных элементов массива: ${mathArray.sumPositiveElements()}");
    println("Произведение элементов массива: ${mathArray.multiplicationElements()}");
    println("Среднее арифметическое массива: ${mathArray.arithmeticMean()}");
}


class MathArray(private var _array: IntArray){
    var array: IntArray
        get() = _array
        set(value){
            _array = value
        }

    fun sumElements():Int{
        var sum = 0;
        _array.forEach { value -> sum += value;}
        return sum;
    }

    fun sumPositiveElements():Int{
        var sum = 0;
        _array.forEach { value ->
            if(value > 0) sum += value;
        }
        return sum;
    }

    fun multiplicationElements():Int{
        var mult = 1;
        _array.forEach { value -> mult *= value;}
        return mult;
    }

    fun arithmeticMean():Double{
        val temp = this.sumElements()/_array.size.toDouble();
        return temp;
    }

}


/*
Создать класс, который содержит одномерный массив чисел (массив передается в конструктор).
  В классе создать методы:
— для вычисления суммы положительных элементов;
— для вычисления произведения элементов массива;
— для вычисления среднего арифметического значения элементов массива.
Создать объект класса и вывести на экран результаты работы методов.
*/