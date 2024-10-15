package homework.HW1015;

public class Member {
    //필드
    private String id;
    private String password;
    private String name;
    private int age;

    //기본 생성자
    public Member(){}

    //오버로딩 생성자
    public Member(String id, String password, String name, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
    }


//    Getter/Setter
//    id
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    //password
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    //name
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //age
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }




    public void showMember(){
        System.out.println("ID: "+id+"\nPassword: "+password+"\nName: "+name+"\nAge: "+age);
        System.out.println("----------------");
    }
}



