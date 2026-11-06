package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 정수와 실수 타입을 모두 처리할 수 있는 제네릭 기반 사칙연산 계산기 클래스입니다.
 *
 * @param <T> Number의 하위 타입 (Integer, Double, Float, Long 등)
 */
public class ArithmeticCalculator<T extends Number> {
    // 연산 결과를 순서대로 누적 저장하는 컬렉션 필드 (캡슐화: private)
    private List<Double> results = new ArrayList<>();

    public ArithmeticCalculator() {
    }

    /**
     * 사칙연산을 수행하고 결과를 리스트에 저장한 뒤 반환합니다.
     *
     * @param num1 첫 번째 피연산자
     * @param num2 두 번째 피연산자
     * @param operator 사칙연산 타입
     * @return 연산 결과 (double)
     */
    public double calculate(T num1, T num2, OperatorType operator) {
        if (operator == null) {
            throw new IllegalArgumentException("올바른 사칙연산 기호를 입력해주세요.");
        }

        // 나눗셈 연산 시 분모가 0인지 검증 (num2.doubleValue() == 0)
        if (operator == OperatorType.DIVIDE && num2.doubleValue() == 0) {
            throw new ArithmeticException("나눗셈 연산에서 분모(두 번째 피연산자)에 0이 입력될 수 없습니다.");
        }

        double result = operator.apply(num1.doubleValue(), num2.doubleValue());
        results.add(result);
        return result;
    }

    /**
     * char 기호를 받는 calculate 오버로딩 메서드
     */
    public double calculate(T num1, T num2, char operatorChar) {
        return calculate(num1, num2, OperatorType.fromSymbol(operatorChar));
    }

    /**
     * String 기호를 받는 calculate 오버로딩 메서드
     */
    public double calculate(T num1, T num2, String operatorStr) {
        return calculate(num1, num2, OperatorType.fromSymbol(operatorStr));
    }

    /**
     * 가장 먼저 저장된 데이터를 삭제합니다 (리스트의 첫 번째 요소 삭제).
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
     * 저장된 모든 연산 결과 목록을 콘솔에 출력합니다.
     */
    public void inquiryResults() {
        if (results.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
        } else {
            System.out.println("현재 저장된 연산 결과 목록: " + results);
        }
    }

    /**
     * [Lambda & Stream]
     * 특정 기준값(double target)보다 큰 결과들만 Stream API를 활용해 필터링하여 반환합니다.
     *
     * @param target 기준값
     * @return 기준값보다 큰 연산 결과 리스트
     */
    public List<Double> getResultsGreaterThan(double target) {
        return results.stream()
                .filter(result -> result > target)
                .collect(Collectors.toList());
    }

    /**
     * [Lambda & Stream]
     * 특정 기준값(double target)보다 큰 결과들만 필터링하여 콘솔에 출력합니다.
     *
     * @param target 기준값
     */
    public void printResultsGreaterThan(double target) {
        List<Double> filtered = getResultsGreaterThan(target);
        if (filtered.isEmpty()) {
            System.out.println(target + "보다 큰 연산 결과가 없습니다.");
        } else {
            System.out.println(target + "보다 큰 연산 결과 목록: " + filtered);
        }
    }

    // 별칭 메서드 (필터링)
    public List<Double> filterResultsGreaterThan(double target) {
        return getResultsGreaterThan(target);
    }

    // 별칭 메서드 (출력)
    public void inquiryResultsGreaterThan(double target) {
        printResultsGreaterThan(target);
    }

    // Getter & Setter
    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> results) {
        this.results = results;
    }

    public List<Double> getResultList() {
        return results;
    }

    public void setResultList(List<Double> results) {
        this.results = results;
    }
}
