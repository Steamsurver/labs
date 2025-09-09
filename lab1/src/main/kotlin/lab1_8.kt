import kotlin.math.sqrt

fun main(){
    val testVector = Vector(1.0, 2.0, 3.0);
    println("x:${testVector.x}   y:${testVector.y}   z:${testVector.z}");
    println("Длина вектора: ${testVector.length()}");
    println("Скалярное произведение векторов: ${testVector scalarOfVectors Vector(3.0, 3.0, 3.0)}");
    println("Скалярное произведение векторов через * :" +
            " ${Vector(1.0, 2.0, 3.0) * Vector(3.0, 3.0, 3.0)}");
    println("Скалярное произведение векторов через стороннюю функцию:" +
            " ${scalarOfVectors(Vector(1.0, 2.0, 3.0), Vector(3.0, 3.0, 3.0))}");
}


class Vector(private var _x: Double,
             private var _y: Double,
             private var _z: Double) {
    var x: Double
        get() = _x
        set(value) {_x = value}
    var y: Double
        get() = _y
        set(value) {_y = value}
    var z: Double
        get() = _z
        set(value) {_z = value}


    fun length(): Double{
        return sqrt(_x*_x + _y*_y + _z*_z);
    }

    infix fun scalarOfVectors(vector2: Vector): Double{
        return _x*vector2.x + _y*vector2.y + _z*vector2.z;
    }

    operator fun times(vector2: Vector): Double{ // Перегрузка *
        return _x*vector2.x + _y*vector2.y + _z*vector2.z;
    }
}

fun scalarOfVectors(vector1: Vector, vector2: Vector): Double{
    return vector1.x*vector2.x + vector1.y*vector2.y + vector1.z*vector2.z;
}

/*
Создать класс Vector, который описывает вектор в трехмерном пространстве.
Конструктор в качестве параметров принимает координаты x, y, z.
В классе создать методы:
- для вычисления длины вектора (sqrt(x^2 + y^2 + z^2));

- для вычисления скалярного произведения векторов 𝑥1∗𝑥2 + 𝑦1∗𝑦2 + 𝑧1∗𝑧2.
    В качестве параметра метод принимает объект класса Vector;

- добавить инфиксную запись между двумя векторами в предыдущий пункт.
    Используйте ключевое слово infix;

- описать функцию скалярного произведения векторов, чтобы выражение
    приняло вид: Vector(1.0,2.0,3.0) * Vector(3.0,2.0,1.0);

- вне класса создать функцию скалярного произведения, которая в качестве
    параметров принимает два объекта типа Vector.

*/