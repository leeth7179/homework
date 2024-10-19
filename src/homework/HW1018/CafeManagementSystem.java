package homework.HW1018;



import java.util.ArrayList;

public class CafeManagementSystem {
    public static void main(String[] args) {
        //1.카테고리 기본 데이터 생성 메소드
        ArrayList<Category> categories = initializeCategoryData();

        //2.카테고리 id가 3인 카테고리의 description을 조회 및 출력
        Category category = null; // 카테고리id가 3인 카테고리 객체를 저장할 변수
        for(Category c : categories){
            if(c.getCategoryId() == 3){
                category = c;
                break;
            }
        }
        System.out.println("카테고리 id가 3인 카테고리의 설명: "+category.getDescription());

        //3. 카테고리id가 짝수인 카테고리 객체만 조회, 별도의 ArrayList에 저장해서 출력
        ArrayList<Category> evenCategoryList = new ArrayList<Category>();
        for(Category c : categories){
            if(c.getCategoryId() % 2 == 0){
                evenCategoryList.add(c);
            }
        }
        for(Category c : evenCategoryList){
            System.out.println(c.getCategoryId()+" "+c.getName()+" "+c.getDescription());
        }

        //4. 카테고리id가 5인 카테고리의 이름을 "Bread"로 변경, description을 "고소한 빵"으로 변경
        for(Category c : categories){
            if(c.getCategoryId() == 5){
                c.setName("Bread");
                c.setDescription("고소한 빵");
            }
        }
        //5. 변경된 카테고리 정보 출력
        System.out.println("---------------------");
        for(Category c : categories){
            System.out.println(c.getCategoryId()+" "+c.getName()+" "+c.getDescription());
        }
        //6. 상품데이터 생성 메소드 호출
        ArrayList<Product> products = initializeProductData();
        //7. "초코라떼"라는 이름을 가진 상품 객체를 조회하되 별도의 ArrayList에 저장해서 출력
        ArrayList<Product> chocoLatteList = new ArrayList<Product>();
        for(Product p : products){
            if(p.getName().equals("초코라떼")){
                chocoLatteList.add(p);
            }
        }
        System.out.println("상품 이름이 초코라떼인 상품 출력");
        for(Product p : chocoLatteList){
            System.out.println(p.getProductId()+" "+p.getName()+" "+p.getCategoryId()+" "+p.getPrice()+" "+p.getStock());
        }

        //Employee
        ArrayList<Employee> employees = initializeEmployeeData();

        //Order
        ArrayList<Order> orders = initializeOrderData();

        //새로운 사원 추가
        System.out.println("=======새로운 사원 추가========");
        Employee eList = new Employee(206,"Scott","차장",6000);

        employees.add(5,eList);

        //두 건의 주문 추가
        System.out.println("========추가 주문=========");
        Order ord1 = new Order(87134873,"2024-10-18 13:00",10,206,2);
        Order ord2 = new Order(87137137,"2024-10-18 15:00",11,203,3);
        orders.add(74,ord1);
        orders.add(75,ord2);

        //전체 주문목록 조회
        System.out.println("===================================================================");
        System.out.println("주문번호 주문일자 상품번호 상품명 카테고리명 사원번호 사원명 주문수량 총주문금액");
        System.out.println("-------------------------------------------------------------------");
        printTotalOrderList(orders, products, employees,categories);
        System.out.println("===================================================================");

        //5000원 이상 주문 조회
        System.out.println("===========5000원 이상 주문 조회=================");
        System.out.println("주문번호 주문일자 상품번호 사원번호 주문수량 총주문금액");
        printOrderPriceList(orders,products,5000);
        System.out.println("==============================================");

        //다음 사원이 처리한 주문 조회(Charlie)
        System.out.println("================Charlie가 처리한 주문===============");
        printEmployeeOrder(orders,employees,"charlie");

        //커피 카테고리 주문만 조회 ( 별도 ArrayList )
        System.out.println("================커피 카테고리 주문===============");
        printCategoryOrder(orders, categories,products,"Coffee");


        //카테고리별 주문합계 금액 조회
        System.out.println("=================카테고리별 주문금액==============");
        printCategoryPrice(orders,categories,products);

    } //end of main
    //카테고리별 금액
    private static void printCategoryPrice(ArrayList<Order> orders, ArrayList<Category> categories, ArrayList<Product> products) {
        for(Category c:categories){
            int categoryPrice = 0;
            for(Order order: orders){
                Product product = findProduct(order.getProductId(), products);
                Category category = findCategory(product.getCategoryId(), categories);
                if(product.getCategoryId() == category.getCategoryId()){
                    int aMount = 0;
                    aMount = product.getPrice() * order.getQuantity();
                    categoryPrice += aMount;
                }
            }
            System.out.println(c.getName()+"카테고리 주문 금액: "+categoryPrice);

            }
        }


    //카테고리별 주문조회
    private static void printCategoryOrder(ArrayList<Order> orders, ArrayList<Category> categories, ArrayList<Product> products, String name) {
        ArrayList<Order> categoryOrder = new ArrayList<Order>();
        for(Order a:orders){
            Product product = findProduct(a.getProductId(), products);
            Category category = findCategory(product.getCategoryId(), categories);
            if(product.getCategoryId() == category.getCategoryId()){
                if(category.getName().equals(name)){
                    categoryOrder.add(a);
                    System.out.println(name+"카테고리 주문번호: "+a.getOrderId());
                }
            }
        }
    }


    //특정사원 주문조회
    private static void printEmployeeOrder(ArrayList<Order> orders, ArrayList<Employee> employees, String name) {
        for(Employee employee:employees){
            if(employee.getName().equals(name)){
                for(Order order:orders){
                    if(employee.getEmployeeId() == order.getEmployeeId()){
                        System.out.println(name +"가 처리한 주문번호: "+order.getOrderId());
                    }
                }
            }
        }
    }

    //특정 가격 이상 주문조회 메소드
    private static void printOrderPriceList(ArrayList<Order> orders, ArrayList<Product> products, int sPrice) {
        for(Order order:orders){
            Product product = findProduct(order.getProductId(), products);
            int totalAmount = 0;
            totalAmount = product.getPrice() * order.getQuantity();
            if(totalAmount >= sPrice){
                System.out.println(order.getOrderId()+" "+order.getOrderDate()+" "+order.getProductId()+" "+order.getEmployeeId()+" "+order.getQuantity()+" "+totalAmount);
            }
        }
    }

    //전체 주문목록 출력 메소드
    private static void printTotalOrderList(ArrayList<Order> orders, ArrayList<Product> products, ArrayList<Employee> employees, ArrayList<Category> categories) {
        for(Order order:orders){
            Product product = findProduct(order.getProductId(), products);
            Employee employee = findEmployee(order.getEmployeeId(), employees);
            Category category = findCategory(product.getCategoryId(), categories);

            int totalAmount = 0;
            totalAmount = product.getPrice() * order.getQuantity();

            System.out.println(order.getOrderId()+" "+order.getOrderDate()+" "+order.getProductId()+" "+
                    product.getName()+" "+category.getName()+" "+ employee.getEmployeeId()+" "+employee.getName()+" "+
                    order.getQuantity()+" "+totalAmount);

        }
    }
    //order 상품정보에 있는 카테고리 정보 담기
    private static Category findCategory(int categoryId, ArrayList<Category> categories) {
        for(Category category : categories){
            if(category.getCategoryId() == categoryId){
                return category;
            }
        }return null;
    }


    //order에 있는 사원번호와 일치하는 사원정보 담기
    private static Employee findEmployee(int employeeId, ArrayList<Employee> employees) {
        for(Employee employee:employees){
            if(employee.getEmployeeId() == employeeId){
                return employee;
            }
        }
        return null;
    }

    //order에 있는 상품번호와 일치하는 상품정보 담기
    private static Product findProduct(int productId, ArrayList<Product> products) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }


    public static ArrayList<Employee> initializeEmployeeData(){
        ArrayList<Employee> eList = new ArrayList<Employee>();
        eList.add(new Employee(201, "Alice", "사원", 3000));
        eList.add(new Employee(202, "Bob", "대리", 4000));
        eList.add(new Employee(203, "charlie", "과장", 5000));
        eList.add(new Employee(204, "David", "사원", 3200));
        eList.add(new Employee(205, "Eve", "대리", 4200));
        return eList;
    }
    public static ArrayList<Order> initializeOrderData(){
        ArrayList<Order> oList = new ArrayList<Order>();
        oList.add(new Order(38167668, "2017-09-13 10:15", 1, 201, 1));
        oList.add(new Order(89217297, "2017-09-13 10:20", 2, 201, 1));
        oList.add(new Order(39178816, "2017-09-13 10:40", 3, 201, 1));
        oList.add(new Order(63105816, "2017-09-13 10:05", 4, 201, 1));
        oList.add(new Order(47018158, "2017-09-13 11:15", 5, 201, 1));
        oList.add(new Order(46078737, "2017-09-13 11:25", 6, 201, 1));
        oList.add(new Order(32215456, "2017-09-13 11:35", 7, 201, 1));
        oList.add(new Order(60728464, "2017-09-13 11:45", 8, 201, 1));
        oList.add(new Order(99145980, "2017-09-13 11:50", 9, 201, 1));
        oList.add(new Order(65700654, "2017-09-13 12:00", 8, 202, 1));
        oList.add(new Order(65700654, "2017-09-13 12:00", 7, 202, 1));
        oList.add(new Order(65700654, "2017-09-13 12:00", 6, 202, 1));
        oList.add(new Order(65700654, "2017-09-13 12:00", 5, 202, 1));
        oList.add(new Order(54449843, "2017-09-13 12:10", 4, 202, 1));
        oList.add(new Order(66578200, "2017-09-13 12:15", 3, 202, 1));
        oList.add(new Order(79287280, "2017-09-13 12:35", 3, 202, 1));
        oList.add(new Order(56679560, "2017-09-13 12:50", 6, 203, 1));
        oList.add(new Order(39865396, "2017-09-13 12:55", 4, 203, 1));
        oList.add(new Order(49791945, "2017-09-13 13:15", 6, 203, 1));
        oList.add(new Order(49791945, "2017-09-13 13:15", 8, 203, 1));
        oList.add(new Order(49791945, "2017-09-13 13:15", 11, 203, 1));
        oList.add(new Order(49791945, "2017-09-13 13:15", 12, 203, 1));
        oList.add(new Order(73592627, "2017-09-13 13:30", 13, 203, 1));
        oList.add(new Order(57111296, "2017-09-13 13:45", 14, 203, 1));
        oList.add(new Order(57111296, "2017-09-13 13:45", 15, 203, 1));
        oList.add(new Order(57111296, "2017-09-13 13:45", 16, 203, 1));
        oList.add(new Order(57111296, "2017-09-13 13:45", 17, 203, 1));
        oList.add(new Order(69598408, "2017-09-13 13:05", 18, 203, 1));
        oList.add(new Order(69598408, "2017-09-13 13:05", 19, 203, 1));
        oList.add(new Order(69598408, "2017-09-13 13:05", 20, 203, 1));
        oList.add(new Order(69598408, "2017-09-13 13:05", 20, 205, 1));
        oList.add(new Order(67173436, "2017-09-13 14:30", 20, 205, 1));
        oList.add(new Order(67173436, "2017-09-13 14:30", 20, 205, 1));
        oList.add(new Order(67173436, "2017-09-13 14:30", 20, 205, 1));
        oList.add(new Order(67173436, "2017-09-13 14:30", 15, 205, 1));
        oList.add(new Order(36320862, "2017-09-13 14:35", 15, 205, 1));
        oList.add(new Order(71781108, "2017-09-13 14:05", 15, 205, 1));
        oList.add(new Order(55756203, "2017-09-13 14:55", 15, 205, 1));
        oList.add(new Order(55756203, "2017-09-13 14:55", 15, 205, 1));
        oList.add(new Order(55756203, "2017-09-13 14:55", 15, 205, 1));
        oList.add(new Order(55756203, "2017-09-13 14:55", 15, 205, 1));
        oList.add(new Order(22817525, "2017-09-13 15:00", 20, 205, 1));
        oList.add(new Order(55183914, "2017-09-13 15:15", 11, 205, 1));
        oList.add(new Order(39118494, "2017-09-13 15:40", 12, 205, 1));
        oList.add(new Order(56152549, "2017-09-13 15:45", 13, 204, 1));
        oList.add(new Order(44004393, "2017-09-13 16:45", 14, 204, 1));
        oList.add(new Order(57522351, "2017-09-13 16:55", 15, 204, 1));
        oList.add(new Order(57522351, "2017-09-13 16:55", 17, 204, 1));
        oList.add(new Order(57522351, "2017-09-13 16:55", 19, 204, 1));
        oList.add(new Order(57522351, "2017-09-13 16:55", 20, 204, 1));
        oList.add(new Order(97267860, "2017-09-13 17:40", 20, 204, 1));
        oList.add(new Order(23534034, "2017-09-13 17:55", 20, 204, 1));
        oList.add(new Order(91629257, "2017-09-13 18:20", 20, 204, 1));
        oList.add(new Order(37776984, "2017-09-13 19:15", 20, 204, 1));
        oList.add(new Order(46888645, "2017-09-13 19:20", 20, 204, 1));
        oList.add(new Order(47293154, "2017-09-13 19:25", 13, 203, 1));
        oList.add(new Order(34402591, "2017-09-13 20:25", 1, 203, 1));
        oList.add(new Order(75967086, "2017-09-13 20:45", 2, 203, 1));
        oList.add(new Order(41288267, "2017-09-13 20:55", 3, 203, 1));
        oList.add(new Order(38559076, "2017-09-13 21:25", 4, 203, 1));
        oList.add(new Order(16229001, "2017-09-13 21:40", 5, 203, 1));
        oList.add(new Order(59480814, "2017-09-13 22:00", 14, 203, 1));
        oList.add(new Order(96791246, "2017-09-13 22:10", 15, 203, 1));
        oList.add(new Order(50021775, "2017-09-13 22:35", 16, 203, 1));
        oList.add(new Order(55861805, "2017-09-13 22:40", 17, 203, 1));
        oList.add(new Order(68585789, "2017-09-13 22:50", 18, 203, 1));
        oList.add(new Order(92127744, "2017-09-13 22:55", 21, 203, 1));
        oList.add(new Order(92127744, "2017-09-13 22:55", 20, 203, 1));
        oList.add(new Order(92127744, "2017-09-13 22:55", 20, 203, 1));
        oList.add(new Order(92127744, "2017-09-13 22:55", 20, 202, 1));
        oList.add(new Order(94113278, "2017-09-13 23:15", 15, 202, 1));
        oList.add(new Order(17708771, "2017-09-13 23:20", 16, 202, 1));
        oList.add(new Order(71621027, "2017-09-13 23:25", 17, 202, 1));
        oList.add(new Order(49305845, "2017-09-13 23:45", 12, 202, 1));
        return oList;
    }

    /**
     * 상품 기본 데이터를 생성하여 ArrayList에 추가하고 반환해주는 메소드     
     */
    public static ArrayList<Product> initializeProductData(){
        ArrayList<Product> pList = new ArrayList<Product>();

       pList.add(new Product(1, "카라멜마끼아또", 1, 5000, 1));
        pList.add(new Product(2, "홍차라떼", 2, 5000, 2));
        pList.add(new Product(3, "초코라떼", 2, 5000, 3));  // 초코라떼 한 번만 남김
        pList.add(new Product(4, "오레오", 3, 5000, 4));
        pList.add(new Product(5, "초코라떼", 2, 4500, 5));  // 가격이 다른 경우는 중복으로 처리하지 않음
        pList.add(new Product(6, "복숭아스무디", 4, 5000, 6));
        pList.add(new Product(7, "커피콩빵", 5, 3000, 7));
        pList.add(new Product(8, "바니라라떼", 1, 5000, 8));
        pList.add(new Product(9, "매실차", 6, 4500, 9));
        pList.add(new Product(10, "깔라만시", 6, 4500, 10));
        pList.add(new Product(11, "카페라떼", 1, 4000, 10));
        pList.add(new Product(12, "헤이즐넛라떼", 1, 5000, 10));
        pList.add(new Product(13, "아메리카노", 1, 4000, 10));
        pList.add(new Product(14, "캐모마일", 6, 4500, 10));
        pList.add(new Product(15, "아포가또", 3, 5500, 10));
        pList.add(new Product(16, "비엔나커피", 1, 5000, 10));
        pList.add(new Product(17, "베이글", 5, 3500, 10));
        pList.add(new Product(18, "카푸치노", 1, 4000, 10));
        pList.add(new Product(19, "허니브레드", 5, 6000, 10));
        pList.add(new Product(20, "얼그레이", 6, 4500, 10));
        pList.add(new Product(21, "레몬에이드", 3, 5000, 10));
        return pList;
    }


    public static ArrayList<Category> initializeCategoryData() {
        //1. Category 객체를 저장할 수 있는 ArrayList 객체 생성
        ArrayList<Category> categoryArrayList = new ArrayList<Category>();
        //2. ArrayList에 추가할 Category 객체 생성
        Category c1 = new Category(1, "Coffee", "모든 종류의 커피");
        Category c2 = new Category(2, "Latte", "다양한 종류의 라떼");
        Category c3 = new Category(3, "Ade/Shake", "신선한 에이드와 쉐이크");
        Category c4 = new Category(4, "Smoothie/Juice", "건강한 스무디와 주스");
        Category c5 = new Category(5, "Bakery", "갓 구운 빵");
        Category c6 = new Category(6, "Tea", "전통 차와 허브차");

        categoryArrayList.add(c1);
        categoryArrayList.add(c2);
        categoryArrayList.add(c3);
        categoryArrayList.add(c4);
        categoryArrayList.add(c5);
        categoryArrayList.add(c6);

        return categoryArrayList;
    }
    
    
}

