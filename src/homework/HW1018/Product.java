package homework.HW1018;

public class Product {
    private int productId;
    private String name;
    private int categoryId;
    private int price;
    private int stock;

    public Product() {
    }

    public Product(int productId, String name, int categoryId, int price) {
        this.productId = productId;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;

    }
    //재고량이 추가된 생성자
    public Product(int productId, String name, int categoryId, int price, int stock) {
        this.productId = productId;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
