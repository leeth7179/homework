package homework;

import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num1 = scan.nextDouble(); //입력값
        char a = scan.next().charAt(0); // 연산자
        double num2 = scan.nextDouble(); //입력값

        double result = 0; //결과값

        switch (a){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if(num2 != 0){
                    result = num1 / num2;
            }else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                System.out.println("계산식을 제대로 입력해주세요.");

        }

        System.out.printf("결과 : %10.2f", result);



    }
}
