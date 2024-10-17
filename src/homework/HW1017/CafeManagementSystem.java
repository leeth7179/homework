package homework.HW1017;

public class CafeManagementSystem {
    public static void main(String[] args) {
        System.out.println("Cafe Management System");

        //1.카테고리 데이터 생성
        Category[] categories = initializeCategoryData();

        //2. 상품 데이터 생성
        Product[] products = initializeProductData();

        //3. 특정 카테고리에 속한 상품들 출력, 카테고리 이름을 전달해서 해당 카테고리에 속한 상품들을 반환
        Product[] categoryProducts = getProductsByCategoryName("Coffee", categories, products);

        //4. 찾아진 카테고리에 소속된 상품들 출력하기. 메소드로 분리
        printProductListWithCategoryName(categoryProducts);

        //5. 상품의 이름으로 상품 1개 조회
        Product product = findProductByName("초코라떼", products);

        //6. 찾아진 상품 출력
        printProduct(product);

        //7. 특정상품 가격 변경
        updateProductPrice("초코라떼", 6000, products);

        //8. 빵종류의 상품 가격을 밀가루값 인상으로 15%인상
        increaseBakeryPrice(products);

        // 9. 사원 기초 데이터 생성
        Employee[] employees = initializeEmployeeData();

        // 10. 주문 기초 데이터 생성
        Order[] orders = initializeOrderData();

        // 11. 주문을 처리하는 메소드
        // Alice 사원이 2024-10-17 03:52에 1번 상품을 2개 주문하는 건을 처리함.
        // 주문 객체 생성
        //Order order1 = new Order(0, "2024-10-17 03:52", 1, 201, 2);
        // 주문 추가 메소드
        //addOrder(order1, orders);

        //12. 주문 데이터 출력
        showOrderData(categories, products, orders, employees);


        // 13. 주문 통계 출력 메소드
        //- 총주문금액
        //- 가장 큰 주문액
        showOrderStatistics(orders, products);

        // 14.사원별 주문 처리 건수
        showOrderEmployee(employees, orders);
    } //end of main

    private static void showOrderEmployee(Employee[] employees, Order[] orders) {
        System.out.println("=========================================");
        System.out.println("=============사원별 주문 처리 건수===========");
        for(Employee employee : employees){
            int count = 0;
            for(Order order: orders) {
                if(employee.getEmployeeId() == order.getEmployeeId()) {
                    count++;
                }
            }
            System.out.println(employee.getName()+" 판매량 : "+count);
        }
    }

    /**
     * 주문 통계 출력 메소드
     * - 총 주문 금액
     * - 최고 주문액
     * @param orders
     * @param products
     */
    private static void showOrderStatistics(Order[] orders, Product[] products) {
        System.out.println("==========================================");
        int amount = 0;
        int totalAmount = 0;
        int max = 0;
        for (Order order : orders) {
            // 상품 정보 출력
            Product product = findProductById(order.getProductId(), products);
            // 주문 가격 출력
            if(order.getQuantity() > 0) {
                amount = (product.getPrice() * order.getQuantity());
                totalAmount += amount;
            }
            if(amount > max){
                max = amount;
            }
        }
        System.out.println("총 주문금액: "+totalAmount);
        System.out.println("최고 주문금액: "+max);
    }

    /**
     * 주문 데이터 출력
     * @param categories
     * @param products
     * @param orders
     * @param employees
     */
    private static void showOrderData(Category[] categories, Product[] products,
                                      Order[] orders, Employee[] employees) {
        System.out.println("<< 주문 데이터 출력 >>");
        System.out.println("==================================================================================================");
        System.out.println(" OrderID OrderDate ProductID productName CategoryName EmployeeID EmployeeName Quantity TotalAmount ");
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (Order order : orders) {
            // 상품 정보 출력
            Product product = findProductById(order.getProductId(), products);

            // 카테고리 정보 출력
            Category category = findCategoryById(product.getCategoryId(), categories);

            // 사원 정보 출력
            Employee employee = findEmployeeById(order.getEmployeeId(), employees);

            // 주문 가격 출력
            int totalAmount = 0;
           totalAmount = product.getPrice() * order.getQuantity();



            // 주문 정보 출력
            System.out.println(order.getOrderId() + "\t" + order.getOrderDate() + "\t" +
                    order.getProductId() + "\t" + product.getName() + "\t" +
                    category.getName() + "\t" +
                    order.getEmployeeId() + "\t" + employee.getName() + "\t" +
                    order.getQuantity()+"\t"+totalAmount);
        }
    }

    /**
     * 사원 id로 사원 객체 찾기
     * @param employeeId
     * @param employees
     */
    private static Employee findEmployeeById(int employeeId, Employee[] employees) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    /**
     * 특정 카테고리 조회
     * - 전달된 카테고리id로 카테고리 배열에서 해당 객체 찾아서 반환
     */
    private static Category findCategoryById(int cagegoryId, Category[] categories) {
        for (Category category : categories) {
            if (category.getCategoryId() == cagegoryId) {
                return category;
            }
        }
        return null;
    }

    // 현재 주문이 갖고 있는 상품의id와 동일한 상품 객체를 찾아서 반환.
    private static Product findProductById(int productId, Product[] products) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product; // 함수종료
            }
        }
        return null;
    }





    private static Order[] initializeOrderData() {
        Order[] orders = new Order[74];
        orders[0] = new Order(38167668, "2017-09-13 10:15", 1, 201, 1);
        orders[1] = new Order(89217297, "2017-09-13 10:20", 2, 201, 1);
        orders[2] = new Order(39178816, "2017-09-13 10:40", 3, 201, 1);
        orders[3] = new Order(63105816, "2017-09-13 10:05", 4, 201, 1);
        orders[4] = new Order(47018158, "2017-09-13 11:15", 5, 201, 1);
        orders[5] = new Order(46078737, "2017-09-13 11:25", 6, 201, 1);
        orders[6] = new Order(32215456, "2017-09-13 11:35", 7, 201, 1);
        orders[7] = new Order(60728464, "2017-09-13 11:45", 8, 201, 1);
        orders[8] = new Order(99145980, "2017-09-13 11:50", 9, 201, 1);
        orders[9] = new Order(65700654, "2017-09-13 12:00", 8, 202, 1);
        orders[10] = new Order(65700654, "2017-09-13 12:00", 7, 202, 1);
        orders[11] = new Order(65700654, "2017-09-13 12:00", 6, 202, 1);
        orders[12] = new Order(65700654, "2017-09-13 12:00", 5, 202, 1);
        orders[13] = new Order(54449843, "2017-09-13 12:10", 4, 202, 1);
        orders[14] = new Order(66578200, "2017-09-13 12:15", 3, 202, 1);
        orders[15] = new Order(79287280, "2017-09-13 12:35", 3, 202, 1);
        orders[16] = new Order(56679560, "2017-09-13 12:50", 6, 203, 1);
        orders[17] = new Order(39865396, "2017-09-13 12:55", 4, 203, 1);
        orders[18] = new Order(49791945, "2017-09-13 13:15", 6, 203, 1);
        orders[19] = new Order(49791945, "2017-09-13 13:15", 8, 203, 1);
        orders[20] = new Order(49791945, "2017-09-13 13:15", 11, 203, 1);
        orders[21] = new Order(49791945, "2017-09-13 13:15", 12, 203, 1);
        orders[22] = new Order(73592627, "2017-09-13 13:30", 13, 203, 1);
        orders[23] = new Order(57111296, "2017-09-13 13:45", 14, 203, 1);
        orders[24] = new Order(57111296, "2017-09-13 13:45", 15, 203, 1);
        orders[25] = new Order(57111296, "2017-09-13 13:45", 16, 203, 1);
        orders[26] = new Order(57111296, "2017-09-13 13:45", 17, 203, 1);
        orders[27] = new Order(69598408, "2017-09-13 13:05", 18, 203, 1);
        orders[28] = new Order(69598408, "2017-09-13 13:05", 19, 203, 1);
        orders[29] = new Order(69598408, "2017-09-13 13:05", 20, 203, 1);
        orders[30] = new Order(69598408, "2017-09-13 13:05", 20, 205, 1);
        orders[31] = new Order(67173436, "2017-09-13 14:30", 20, 205, 1);
        orders[32] = new Order(67173436, "2017-09-13 14:30", 20, 205, 1);
        orders[33] = new Order(67173436, "2017-09-13 14:30", 20, 205, 1);
        orders[34] = new Order(67173436, "2017-09-13 14:30", 15, 205, 1);
        orders[35] = new Order(36320862, "2017-09-13 14:35", 15, 205, 1);
        orders[36] = new Order(71781108, "2017-09-13 14:05", 15, 205, 1);
        orders[37] = new Order(55756203, "2017-09-13 14:55", 15, 205, 1);
        orders[38] = new Order(55756203, "2017-09-13 14:55", 15, 205, 1);
        orders[39] = new Order(55756203, "2017-09-13 14:55", 15, 205, 1);
        orders[40] = new Order(55756203, "2017-09-13 14:55", 15, 205, 1);
        orders[41] = new Order(22817525, "2017-09-13 15:00", 20, 205, 1);
        orders[42] = new Order(55183914, "2017-09-13 15:15", 11, 205, 1);
        orders[43] = new Order(39118494, "2017-09-13 15:40", 12, 205, 1);
        orders[44] = new Order(56152549, "2017-09-13 15:45", 13, 204, 1);
        orders[45] = new Order(44004393, "2017-09-13 16:45", 14, 204, 1);
        orders[46] = new Order(57522351, "2017-09-13 16:55", 15, 204, 1);
        orders[47] = new Order(57522351, "2017-09-13 16:55", 17, 204, 1);
        orders[48] = new Order(57522351, "2017-09-13 16:55", 19, 204, 1);
        orders[49] = new Order(57522351, "2017-09-13 16:55", 20, 204, 1);
        orders[50] = new Order(97267860, "2017-09-13 17:40", 20, 204, 1);
        orders[51] = new Order(23534034, "2017-09-13 17:55", 20, 204, 1);
        orders[52] = new Order(91629257, "2017-09-13 18:20", 20, 204, 1);
        orders[53] = new Order(37776984, "2017-09-13 19:15", 20, 204, 1);
        orders[54] = new Order(46888645, "2017-09-13 19:20", 20, 204, 1);
        orders[55] = new Order(47293154, "2017-09-13 19:25", 13, 203, 1);
        orders[56] = new Order(34402591, "2017-09-13 20:25", 1, 203, 1);
        orders[57] = new Order(75967086, "2017-09-13 20:45", 2, 203, 1);
        orders[58] = new Order(41288267, "2017-09-13 20:55", 3, 203, 1);
        orders[59] = new Order(38559076, "2017-09-13 21:25", 4, 203, 1);
        orders[60] = new Order(16229001, "2017-09-13 21:40", 5, 203, 1);
        orders[61] = new Order(59480814, "2017-09-13 22:00", 14, 203, 1);
        orders[62] = new Order(96791246, "2017-09-13 22:10", 15, 203, 1);
        orders[63] = new Order(50021775, "2017-09-13 22:35", 16, 203, 1);
        orders[64] = new Order(55861805, "2017-09-13 22:40", 17, 203, 1);
        orders[65] = new Order(68585789, "2017-09-13 22:50", 18, 203, 1);
        orders[66] = new Order(92127744, "2017-09-13 22:55", 21, 203, 1);
        orders[67] = new Order(92127744, "2017-09-13 22:55", 20, 203, 1);
        orders[68] = new Order(92127744, "2017-09-13 22:55", 20, 203, 1);
        orders[69] = new Order(92127744, "2017-09-13 22:55", 20, 202, 1);
        orders[70] = new Order(94113278, "2017-09-13 23:15", 15, 202, 1);
        orders[71] = new Order(17708771, "2017-09-13 23:20", 16, 202, 1);
        orders[72] = new Order(71621027, "2017-09-13 23:25", 17, 202, 1);
        orders[73] = new Order(49305845, "2017-09-13 23:45", 12, 202, 1);
        return orders;

    }

    private static Employee[] initializeEmployeeData() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(201, "Alice", "사원", 3000);
        employees[1] = new Employee(202, "Bob", "대리", 4000);
        employees[2] = new Employee(203, "charlie", "과장", 5000);
        employees[3] = new Employee(204, "David", "사원", 3200);
        employees[4] = new Employee(205, "Eve", "대리", 4200);
        return employees;
    }

    /**
     * 빵 카테고리에속한 상품들의 가격을 밀가루값 인상으로 15%인상하는 메소드
     * - 빵 카테고리 : categoryId = 5
     *
     * @param products
     */
    private static void increaseBakeryPrice(Product[] products) {
        System.out.println("=================빵가격 인상===============");
        for (Product product : products) {
            if (product.getCategoryId() == 5) {
//                product.setPrice(product.getPrice() * 1.15);
//                System.out.println(product.getName()+" 상품의가격:"+product.getPrice());
                int beforePrice = product.getPrice();
                int afterPrice = (int) (beforePrice * 1.15);
                product.setPrice(afterPrice);
                System.out.println(product.getName() + " 상품의 가격이 " + beforePrice + "에서" + afterPrice + "로 변경되었습니다.");
            }
        }
    }

    // 특정상품 가격변경
    private static void updateProductPrice(String productName, int price, Product[] products) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                int beforePrice = product.getPrice();
                product.setPrice(price);
                System.out.println(product.getName() + "상품의 가격이 " + beforePrice + "에서" + price + "로 변경되었습니다.");
                break;
            }
        }
    }


    private static void printProduct(Product product) {
        System.out.println("============================");
        System.out.println(" Product ID Name CategoryId Price ");
        System.out.println("----------------------------");
        System.out.println(product.getProductId() + "\t" + product.getName() + "\t" + product.getCategoryId() + "\t" + product.getPrice());
        System.out.println("============================");
    }

    // 상품 이름으로 상품 조회
    private static Product findProductByName(String productName, Product[] products) {
        Product product = null;
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                product = p;
                break;
            }
        }
        return product;
    }

    private static void printProductListWithCategoryName(Product[] categoryProducts) {
        System.out.println("===========================");
        System.out.println(" Product ID Name CategoryId Price ");
        System.out.println("----------------------------");
        for (Product product : categoryProducts) {
            if (product == null) {
                break;
            }
            System.out.println(product.getProductId() + "\t" + product.getName() + "\t" + product.getCategoryId() + "\t" + product.getPrice());
        }
        System.out.println("============================");
    }

    //특정 카데고리에 속한 상품들을 반환하는 메소드
    public static Product[] getProductsByCategoryName(String categoryName, Category[] categories, Product[] products) {
        //1. 전달받은 카테고리 이름과 일치하는 상품 객체들을 저장할 배열 생성
        Product[] categoryProducts = new Product[products.length];
        //2. 전달받은 카테고리 이름에 해당하는 카테고리의 id를 찾아온다
        int categoryId = 0;
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                categoryId = category.getCategoryId();
                break;
            }
        }
        //3. 찾은 카테고리 id에 해당하는 상품 객체들을 찾아서 배열에 저장
        int count = 0;
        for (Product product : products) {
            if (product.getCategoryId() == categoryId) {
                categoryProducts[count++] = product;
            }
        }
        return categoryProducts;
    }

    //상품 데이터 초기화
    private static Product[] initializeProductData() {
        Product[] products = new Product[21];
        products[0] = new Product(1, "카라멜마끼아또", 1, 5000, 1);
        products[1] = new Product(2, "홍차라떼", 2, 5000, 2);
        products[2] = new Product(3, "초코라떼", 2, 5000, 3);  // 초코라떼 한 번만 남김
        products[3] = new Product(4, "오레오", 3, 5000, 4);
        products[4] = new Product(5, "초코라떼", 2, 4500, 5);  // 가격이 다른 경우는 중복으로 처리하지 않음
        products[5] = new Product(6, "복숭아스무디", 4, 5000, 6);
        products[6] = new Product(7, "커피콩빵", 5, 3000, 7);
        products[7] = new Product(8, "바니라라떼", 1, 5000, 8);
        products[8] = new Product(9, "매실차", 6, 4500, 9);
        products[9] = new Product(10, "깔라만시", 6, 4500, 10);
        products[10] = new Product(11, "카페라떼", 1, 4000, 10);
        products[11] = new Product(12, "헤이즐넛라떼", 1, 5000, 10);
        products[12] = new Product(13, "아메리카노", 1, 4000, 10);
        products[13] = new Product(14, "캐모마일", 6, 4500, 10);
        products[14] = new Product(15, "아포가또", 3, 5500, 10);
        products[15] = new Product(16, "비엔나커피", 1, 5000, 10);
        products[16] = new Product(17, "베이글", 5, 3500, 10);
        products[17] = new Product(18, "카푸치노", 1, 4000, 10);
        products[18] = new Product(19, "허니브레드", 5, 6000, 10);
        products[19] = new Product(20, "얼그레이", 6, 4500, 10);
        products[20] = new Product(21, "레몬에이드", 3, 5000, 10);
        return products;
    }


    //카테고리 데이터 초기화
    public static Category[] initializeCategoryData() {
        Category[] categories = new Category[6];
        categories[0] = new Category(1, "Coffee", "모든 종류의 커피");
        categories[1] = new Category(2, "Latte", "다양한 종류의 라떼");
        categories[2] = new Category(3, "Ade/Shake", "신선한 에이드와 쉐이크");
        categories[3] = new Category(4, "Smoothie/Juice", "건강한 스무디와 주스");
        categories[4] = new Category(5, "Bakery", "갓 구운 빵");
        categories[5] = new Category(6, "Tea", "전통 차와 허브차");
        return categories;
    }
}
