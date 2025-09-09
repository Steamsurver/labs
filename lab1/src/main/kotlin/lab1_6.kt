import kotlin.math.sqrt

fun main(){
    //a = 1, b = 1, c = 1
    val a: Double = 1.0;
    val b: Double = 1.0;
    val c: Double = 1.0;

    println("Решение квадратного уравнения: $a * x^2 + $b * x + $c = 0 ");
    println("Дискриминант: ${discriminant(a, b, c)}");
    println("Количество корней: ${rootsNumber(a, b, c)}");
    quadraticRoot(a, b, c);
}

fun sqr(n: Double):Double{
    return n*n;
}

fun discriminant(a: Double, b: Double, c: Double):Double{
    return sqr(b) - 4 * a * c;
}

fun rootsNumber(a: Double, b: Double, c: Double):Double{
    val discriminant = discriminant(a, b, c);

    return when{
        discriminant == 0.0 -> 1.0;
        discriminant < 0.0 -> 0.0;
        else -> 2.0
    }
}

fun quadraticRoot(a: Double, b: Double, c: Double){
    when {
        rootsNumber(a, b, c) == 1.0 ->{
            println("Корень x = ${-b / (2* a)}");
        }

        rootsNumber(a, b, c) == 0.0 ->{
            println("Количество корней уравнения: 0");
        }

        rootsNumber(a, b, c) == 2.0 ->{
            val d = discriminant(a, b, c);
            println("Корни: x1 = ${(-b + sqrt(d))/2*a}," +
                    " x2 = ${(-b - sqrt(d))/2*a}");
        }
    }
}
/*
  Решение квадратного уравнения ax2 + bx + c = 0.

— Написать функцию sqr(n), которая в качестве параметра принимает число n
  и возвращает квадрат этого числа.

— Написать функцию discriminant(a, b, c), которая в качестве параметров
  принимает коэффициенты a, b и c заданного уравнения и возвращает
  рассчитанный дискриминант.

— Написать функцию rootsNumber(a, b, c), которая в качестве параметров принимает
  коэффициенты a, b и c заданного уравнения. Данная функция в зависимости
  от дискриминанта должна определить и вернуть количество корней заданного
  квадратного уравнения. Реализовать с помощью конструкции when().

— Написать функцию quadraticRoot(a, b, c), которая в качестве параметров
  принимает коэффициенты a, b и c заданного уравнения. Данная функция должна
  вывести на экран корни заданного квадратного уравнения. При реализации
  использовать ранее написанные функции.

*/