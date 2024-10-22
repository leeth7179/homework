package homework.HW1022;

/**
 * 매개변수의 다형성이 구현되어야 한다.
 */
public class Driver {
    void drive(Vehicle vehicle) {
        vehicle.run(); // Vehicle 인터페이스의 run() 메소드 호출, 실제로는 Bus 또는 Taxi의 run() 메소드 호출
    }
}
