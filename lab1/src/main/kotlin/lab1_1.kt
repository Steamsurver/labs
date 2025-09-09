
fun main() {
    println("Введите число:")
    var testNumber = readln();

    when {
        //проверка введено число или нет
        testNumber.toIntOrNull() != null && testNumber.toInt() < 10 && testNumber.toInt() > -1 ->{
            println("Введено не число.");
        }

        testNumber.toIntOrNull() == null -> println("Введена строковая переменная.");

        testNumber.toIntOrNull() != null ->{
            println("Число: '${testNumber}'");
            if(testNumber.first() != '-') {
                println(
                    "Первая и последняя цифра: ${testNumber.first()} " +
                            " ${testNumber.last()}\nСумма первой и последней цифры: " +
                            " ${testNumber.first().digitToInt() + testNumber.last().digitToInt()}"
                );
            }
            else{//проверка на отрицательное число
                println(
                    "Первая и последняя цифра: ${testNumber[1]} " +
                            " ${testNumber.last()}\nСумма первой и последней цифры: " +
                            " ${testNumber[1].digitToInt() + testNumber.last().digitToInt()}"
                );
            }
        }
    }

}

/*

 */
