

fun main(){
    var tempNumber: String;
    val numbers: MutableList<Double> = mutableListOf();

    while (true){

        print("Введите число: ")
        tempNumber = readln();
        when{
            tempNumber.toDoubleOrNull() != null -> {
                if(tempNumber == "0")
                    break;

                numbers.add(tempNumber.toDouble());
            }

            tempNumber.toDoubleOrNull() == null ->{
                println("Введено не число")
            }
        }
    }

    println("Числа:  $numbers");
    println("Количество чисел:  ${numbers.size}");
    println("Сумма всех чисел:  ${numbers.sum()}");
    println("Среднее арифметическое всех чисел:  ${numbers.average()}");
}


/*
         Пользователь поочередно вводит с клавиатуры любые числа (подтверждая ввод каждого нажатием “Enter”)
    до тех пор, пока не будет введено число “0”. После ввода нуля необходимо вывести на экран количество
    введенных чисел, их общую сумму и среднее арифметическое. Использовать ввод с клавиатуры readln().
*/