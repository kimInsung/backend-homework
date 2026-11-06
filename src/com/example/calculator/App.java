package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();

            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // 연산 후 저장된 결과 목록 조회 및 가장 먼저 저장된 결과 삭제 흐름
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제, inquiry 입력 시 조회)");
            String command = scanner.next();

            if (command.equals("remove")) {
                calculator.removeResult();
                System.out.println("현재 저장된 연산 결과 목록: " + calculator.getResults());
            } else if (command.equals("inquiry")) {
                calculator.inquiryResults();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitInput = scanner.next();

            if (exitInput.equals("exit")) {
                break;
            }
        }

        scanner.close();
    }
}
