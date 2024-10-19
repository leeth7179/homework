package homework.HW1018;

import java.util.ArrayList;

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * ArrayList 클래스를 사용하는 예제
 * -ArrayList 클래스는 배열을 이용해서 데이터를 저장하는 클래스
 * - 배열과 달리 크기가 가변적이며, 객체만 저장 가능
 * - ArrayList 클래스는 제네릭 클래스로서 저장할 객체의 타입을 객체 생성시에 지정해야 함
 * - 해당하는 타입의 객체만 저장할 수 있다. 컴파일 타임에 타입 체크가 가능
 * - add() : 객체를 저장
 * - add(index, element) : index 위치에 저장된 객체를 element 로 대체, 기존 객체는 뒤로 밀림
 * - get(index) : index 위치에 저장된 객체를 반환
 * - size() : 저장된 객체의 개수를 반환
 * - remove(index) : index 위치에 저장된 객체를 제거, 제거하면 뒤에 있는 객체들이 앞으로 한칸씩 이동
 * - set(index, element) : index 위치에 저장된 객체를 element 로 대체, 기존 객체는 삭제
 */
public class ArrayList01 {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 20);
        Person p2 = new Person("김철수", 30);
        Person p3 = new Person("이영희", 40);
        Person[] persons = new Person[3];
        persons[0] = p1;
        persons[1] = p2;
        persons[2] = p3;

        for (Person p : persons) {
//            System.out.println(p.getName() + " \t " + p.getAge());
            System.out.println(p.toString()); //주로 디버깅용도
        }

        //ArrayList 형태로 변환
        ArrayList<Person> personList = new ArrayList<Person>(); //Person 객체만 저장 가능
        personList.add(p1); //p1객체가 ArrayList에 저장됨
        personList.add(p2);
        personList.add(p3);
        //반복해서 출력
        System.out.println("ArrayList 출력");
        for (Person p : personList) {
            System.out.println(p.toString());
        }
        // get(index) 메소드를 통한 Person 객체 가져오기
        Person p5 = personList.get(0);
        Person p6 = personList.get(1);
        Person p7 = personList.get(2);
        //출력
        //일반 for 문을 통한 출력
        System.out.println("일반 for 문을 통한 출력");
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).getName() + "\t" + personList.get(i).getAge());
        }

        //Employee ArrayList 생성,출력
        System.out.println("Employee ArrayList");
        Employee e1 = new Employee(100,"홍길동","사원",1000);
        Employee e2 = new Employee(200,"김철수","대리",2000);
        Employee e3 = new Employee(300,"이영희","과장",3000);

        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        for(Employee e : employeeList){
            System.out.println(e.getEmployeeId()+"\t"+e.getName()+"\t"+e.getPosition()+"\t"+e.getSalary());
        }
        //Product 객채 생성, 출력
        Product prod1 = new Product(100,"노트북",1,1000000);
        Product prod2 = new Product(200,"모니터",2,300000);
        Product prod3 = new Product(300,"키보드",3,50000);
        Product prod4 = new Product(400,"SSD",2,50000);
        ArrayList<Product> productList = new ArrayList<Product>();
        productList.add(prod1);
        productList.add(prod2);
        productList.add(prod3);
        productList.add(prod4);

        //일반 for 문과 get(index)를 통한 출력
        System.out.println("Product ArrayList 출력");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).getProductId()+"\t"+productList.get(i).getName()+"\t"+productList.get(i).getCategoryId()+"\t"+productList.get(i).getPrice());

        }
        // setter 메소드를 통해서 SSD가격을 60000으로 변경
        productList.get(3).setPrice(60000);
        //for-each 문을 통한 출력
        for(Product p: productList){
            System.out.println(p.getProductId()+"\t"+p.getName()+"\t"+p.getCategoryId()+"\t"+p.getPrice());
        }

        // 상품 ArrayList에 상품 추가, 2번째 상품의 위치에 추가
        Product prod5 = new Product(500,"마우스",3,20000);
        productList.add(1,prod5); //2번째 인덱스에 prod5 추가
        System.out.println("-----------------------------------");
        for(Product p: productList){
            System.out.println(p.getProductId()+"\t"+p.getName()+"\t"+p.getCategoryId()+"\t"+p.getPrice());
        }

        //ArrayList 모니터 상품 제거
        productList.remove(2);// 2번쨰 인덱스 상품 제거

        System.out.println("-----------------------------------");
        for(Product p: productList){
            System.out.println(p.getProductId()+"\t"+p.getName()+"\t"+p.getCategoryId()+"\t"+p.getPrice());
        }

        // 마우스 상품을 다른 상품으로 대체, set(index, element)
        Product prod6 = new Product(600,"키트",3,30000);
        productList.set(1, prod6); //1번째 인덱스 상품을 prod6로 대체
        System.out.println("-----------------------------------");
        for(Product p: productList){
            System.out.println(p.getProductId()+"\t"+p.getName()+"\t"+p.getCategoryId()+"\t"+p.getPrice());
        }

        //1~10까지 저장하고 그 값을 출력
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            intList.add(i); //1~10까지 -> Integer 객체로 변환해서 저장(오토박싱)
        }
        System.out.println("1~10까지 출력");
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }

    }
}
