package homework.HW1015;

public class MemberMain {
    public static void main(String[] args) {
       //오버로딩 생성자로 생성
        Member mem1 = new Member("jerry1","p123","Jerry",29);
        Member mem2 = new Member("jerry2","p111","Jon",19);
        Member mem3 = new Member("jerry3","p222","Tom",20);

        // 빈 생성자로 2명의 멤버 생성
        Member mem4 = new Member();
        Member mem5 = new Member();

        // 세터 메소드로 필드 값 설정
        mem4.setId("jerry4");
        mem4.setPassword("p1415");
        mem4.setName("Spike");
        mem4.setAge(27);

        mem5.setId("jerry5");
        mem5.setPassword("p1617");
        mem5.setName("Tyke");
        mem5.setAge(23);



        System.out.println("=== Member List ===");
        mem1.showMember();
        mem2.showMember();
        mem3.showMember();
        mem4.showMember();
        mem5.showMember();

    }
}
