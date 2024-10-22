package homework.HW1022;

import java.util.ArrayList;

public class VehicleMain {
    public static void main(String[] args) {
        // 다형성 구현, Driver 클래스를 사용해야 함.
        // 1. Driver 객체 생성
        Driver driver = new Driver();
        // 2. Vehicle 구현 객체 생성
        Bus bus = new Bus();
        Taxi taxi = new Taxi();
        // 3. 매개값으로 구현 객체 대입(다형성: 실행 결과가 다름)
        driver.drive(bus);
        driver.drive(taxi);
        // 4. 트럭 추가
        Truck truck = new Truck();
        driver.drive(truck);
        // 5. Vehicle 구현 객체들을 ArrayList<T>에 담아서 출력하시오.
        ArrayList<Vehicle> a = new ArrayList<>();
        a.add(bus);
        a.add(taxi);
        a.add(truck);

        for(Vehicle b : a){
            b.run();
        }
    }
}
