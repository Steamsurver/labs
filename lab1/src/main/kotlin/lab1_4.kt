import kotlin.math.sqrt

fun main() {
    var tempNumber: String;

    print("Введите количество простых чисел: ")
    while(true) {
        tempNumber = readln();
        when {
            tempNumber.toIntOrNull() == null -> println("Введено не число");
            tempNumber.toIntOrNull() != null -> {
                if(tempNumber.toInt() < 1)
                    println("Число меньше 1");
                else {
                    printPrimes(tempNumber.toInt());
                    break;
                }
            }
        }
    }
}



fun isPrime(number: Int): Boolean {
    if (number < 2) return false        //числа < 2
    if (number == 2) return true
    if (number % 2 == 0) return false   //четные

    for (i in 3..sqrt(number.toDouble()).toInt() step 2) {
        if (number % i == 0) return false
    }
    return true
}

fun printPrimes(n: Int) {
    var count = 0
    var number = 2

    while (count < n) {
        if (isPrime(number)) {
            print("$number ")
            count++
        }
        number++
    }
}

/*
    Задается количество простых чисел n (1n). Необходимо вывести на экран
  простые числа, начиная с 2.
  Пример вывода для n-ного количества простых чисел:
    1-ое число: 2
    2-ое число: 3
    3-е число: 5
    …
    n-ное число: x
*/