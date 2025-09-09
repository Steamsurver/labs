fun main(){
    val boat = Boat(10, "Riva");
    val tank = Tank(45, "Leopard");
    val airplane = Airplane(800, "Boeing");

    boat.start();
    boat.stop();
    println();

    tank.start();
    tank.stop();
    println();

    airplane.start();
    airplane.stop();
    println();
}


open class Vehicle(){
    open var speed: Int = 0;
    open var name: String = "Default";


    constructor(speed: Int, name: String) : this() {
        this.speed = speed;
        this.name = name;
    }

    open fun start(){
        println("Default transport start. ");
    }

    open fun stop(){
        println("Default transport stop.");
    }
}

class Boat(speed: Int, name: String): Vehicle(speed, name){
    override fun start() {
        println("Лодка модели: ${this.name} - начала движение со скоростью: ${this.speed}км/ч. ");
    }

    override fun stop() {
        println("Лодка закончила свое движение.");
    }
}

class Tank(speed: Int, name: String): Vehicle(speed, name){
    override fun start() {
        println("Танк модели: ${this.name} - начал движение со скоростью: ${this.speed}км/ч. ");
    }

    override fun stop() {
        println("Танк закончил свое движение.");
    }
}

class Airplane(speed: Int, name: String): Vehicle(speed, name){
    override fun start() {
        println("Самолет модели: ${this.name} - начал движение со скоростью: ${this.speed}км/ч. ");
    }

    override fun stop() {
        println("Самолет закончил свое движение.");
    }
}

/*
    Создать суперкласс Vehicle, описывающий поведение любого транспортного средства.
В классе Vehicle создать два свойства с инициализацией значений по умолчанию,
которые будут переопределены в классах наследниках: скорость и название.

В классе Vehicle создать два метода start() и stop() с действием по умолчанию,
которые будут переопределены в классах наследниках.

Методы должны выводить на экран начало движения и остановку.
Пример: “Автомобиль начал движение со скоростью 50 км/ч”.

Создать три класса-наследника от Vehicle, описывающих три типа
транспортных средств: лодка, самолет и танк.
*/