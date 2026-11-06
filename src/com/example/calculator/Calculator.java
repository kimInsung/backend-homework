package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 순서대로 누적 저장할 수 있는 컬렉션 필드 (외부 직접 접근 차단: private)
    private List<Integer> results = new ArrayList<>();

    public Calculator() {
    }

    /**
     * 사칙연산을 수행하고 결과값을 반환하며 결과 리스트에 저장합니다.
     *
     * @param num1 첫 번째 양의 정수
     * @param num2 두 번째 양의 정수
     * @param operator 사칙연산 기호 (+, -, *, /)
     * @return 연산 결과
     */
    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
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
                if (num2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("올바른 사칙연산 기호(+, -, *, /)를 입력해주세요.");
        }

        results.add(result);
        return result;
    }

    /**
     * 연산 기호가 String으로 전달되는 경우를 위한 오버로딩 메서드
     */
    public int calculate(int num1, int num2, String operator) {
        if (operator == null || operator.isEmpty()) {
            throw new IllegalArgumentException("올바른 사칙연산 기호(+, -, *, /)를 입력해주세요.");
        }
        return calculate(num1, num2, operator.charAt(0));
    }

    /**
     * 가장 먼저 저장된 연산 결과를 삭제합니다 (리스트의 첫 번째 요소 삭제).
     */
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("가장 먼저 저장된 연산 결과가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 연산 결과가 없습니다.");
        }
    }

    /**
     * 저장된 연산 결과 목록을 콘솔에 출력하여 조회합니다.
     */
    public void inquiryResults() {
        if (results.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
        } else {
            System.out.println("현재 저장된 연산 결과 목록: " + results);
        }
    }

    // Getter 메서드
    public List<Integer> getResults() {
        return results;
    }

    // Setter 메서드
    public void setResults(List<Integer> results) {
        this.results = results;
    }

    // 별칭 Getter (resultList 명칭 대응)
    public List<Integer> getResultList() {
        return results;
    }

    // 별칭 Setter (resultList 명칭 대응)
    public void setResultList(List<Integer> results) {
        this.results = results;
    }
}
