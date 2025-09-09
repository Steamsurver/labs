import kotlin.io.readln
import kotlin.random.Random

fun main() {
    val randomNumber = Random.nextInt(0, 11);
    println(randomNumber);
    var tempNumber: String;

    while (true){
        print("Введите число от 0 до 10: ");
        tempNumber = readln();
        when{
            tempNumber.toIntOrNull() == null -> println("Введено не число");

            tempNumber.toIntOrNull() != null ->{
                if(tempNumber.toInt() !in 0 until 10)
                    println("Введено число вне диапазона от 0 до 10");
                else if(tempNumber.toInt() > randomNumber)
                    println("Введенное число больше");
                else if(tempNumber.toInt() < randomNumber)
                    println("Введенное число меньше");
                else {
                    println("Угадал");
                    break;
                }
            }
        }
    }

}

/*3)    Программа “Угадай число”. Программа “загадывает” рандомное число A
 (используем (0..10).random() ), пользователь вводит свой вариант
  – число B. Если число В > A, вывести сообщение “Много” и повторить ввод;
  если В < А вывести сообщение “Мало” и повторить ввод; иначе – “Угадал”.*/