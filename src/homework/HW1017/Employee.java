package homework.HW1017;

/**
 * 사원 정보를 저장하는 클래스
 * - 사원정보는 사원 아이디, 이름 , 직급, 급여로 구성
 */

public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(int employeeId, String name, String position, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}


