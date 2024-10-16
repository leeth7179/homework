package homework.HW1016;

/**
 * 상품 도메인 클래스
 * - 상품의 정보를 저장하는 클래스
 * - 상품id, 상품명, 단가(가격), 재고량을 갖는다.
 */
public class Product {
    //필드 선언
    private int productId;
    private String productName;
    private double price;
    private int stock;

    public Product() {
    }

    public Product(int productId, String productName, double price, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //상품정보 출력 메소드
    public void displayProductInfo(){
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stock);
        System.out.println("---------------------------");
    }
}
