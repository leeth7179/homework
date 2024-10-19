package homework.HW1018;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private int orderId;
    private LocalDateTime orderDate;
    private int productId; //상품아이디 , product 테이블의 productId 참조
    private int employeeId; //사원아이디, employee 테이블의 employeeId 참조
    private int quantity;

    public Order() {
    }

    public Order(int orderId, String orderDateString, int productId, int employeeId, int quantity) {
        //DataTimeFormatter 클래스의 ofPattern 메소드를 사용하여 날짜 형식을 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.orderId = orderId;
        // LocalDateTime 클래스의 parse메소드를 사용하여 문자열을 LocalDateTime 객체로 변환합니다
        this.orderDate = LocalDateTime.parse(orderDateString, formatter);
        this.productId = productId;
        this.employeeId = employeeId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", productId=" + productId +
                ", employeeId=" + employeeId +
                ", quantity=" + quantity +
                '}';
    }
}
