package homework.HW1016;

public class ShoppingMain {
    /*1. 상품데이터 생성 : initializeProductData()*/
    public static void main(String[] args) {
        //1. 상품데이터 생성 및 초기화
        Product[] products = initializeProductData();
        //2. 회원데이터 생성 및 초기화
        Member[] members = initializeMemberData();
        //3. 주문데이터 생성
        Order ord1 = new Order(1,"user1",1,2,1000.00);
        Order ord2 = new Order(2,"user2",2,1,300.00);
        Order ord3 = new Order(3,"user3",3,3,2100.00);
        Order ord4 = new Order(4,"user4",4,4,600.00);
        Order ord5 = new Order(5,"user5",5,5,500.00);

        Order[] orders = {ord1,ord2,ord3,ord4,ord5};
        //멤버 목록 출력
        printMemberList(members);
        //상품 목록 출력
        printProductList(products);
        //주문 목록 출력
        printOrderList(orders);
        //총 주문 금액
        printTotalAmount(orders);


    }
    private static void printTotalAmount(Order[] orders){
        System.out.println("========== 총 주문 금액 ============");
        double sum = 0;
        for(Order order: orders){
            sum += order.getTotalAmount();
        }
        System.out.println("총 주문금액: $"+sum);
    }
    //주문 목록 출력 메소드
    private static void printOrderList(Order[] orders) {
        System.out.println("========== Order List =============");
       for(Order order : orders){
           order.displayOrderInfo();
       }
    }

    //상품 목록 출력 메소드
    private static void printProductList(Product[] products) {
        System.out.println("================ Product List ============");
        for(int i=0; i< products.length;i++){
            System.out.println("상품ID: "+products[i].getProductId()+"\t상품이름: "+products[i].getProductName()+"\t가격: "+products[i].getPrice()+"\t남은 수량: "+products[i].getStock());
        }
    }

    //멤버 목록 출력 메소드
    private static void printMemberList(Member[] members) {
        System.out.println("============= Member List ==============");
        for(int i=0; i< members.length;i++){
            System.out.println("ID: "+members[i].getId()+"\tPassword: "+members[i].getPassword()+"\tName: "+members[i].getName()+"\tEmail: "+members[i].getEmail());
        }
    }

    private static Member[] initializeMemberData() {
        Member[] members = new  Member[5];
            members[0] = new Member("user1", "1234", "홍길동", "hong@gmail.com");
            members[1] = new Member("user2", "1234", "이순신", "lee@gmail.com");
            members[2] = new Member("user3", "1234", "강감찬", "kang@gmail.com");
            members[3] = new Member("user4", "1234", "을지문덕", "eulji@gmail.com");
            members[4] = new Member("user5", "1234", "김유신", "kim@gmail.com");
            return members;
    }

    private static Product[] initializeProductData() {
        // 상품 객체 저장용 배열 10칸
        Product[] products = new Product[10];
        products[0] = new Product(1, "냉장고", 500.00, 10);
        products[1] =new Product(2, "세탁기", 300.00, 5);
        products[2] =new Product(3, "에어컨", 700.00, 7);
        products[3] =new Product(4, "공기청정기", 150.00, 12);
        products[4] =new Product(5, "가습기", 100.00, 20);
        products[5] =new Product(6, "청소기", 250.00, 8);
        products[6] =new Product(7, "TV", 900.00, 4);
        products[7] =new Product(8, "전자레인지", 120.00, 15);
        products[8] =new Product(9, "토스터", 60.00, 18);
        products[9] =new Product(10, "믹서기", 80.00, 10);
        return products;
    }

}
