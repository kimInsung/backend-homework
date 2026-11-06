package com.example.calculator;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    /**
     * 사칙연산을 수행합니다.
     *
     * @param a 첫 번째 피연산자
     * @param b 두 번째 피연산자
     * @return 연산 결과
     */
    public double apply(double a, double b) {
        switch (this) {
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두 번째 피연산자)에 0이 입력될 수 없습니다.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("올바른 사칙연산 기호를 입력해주세요.");
        }
    }

    /**
     * char 기호에 매핑되는 OperatorType을 반환합니다.
     *
     * @param symbol 사칙연산 문자 (+, -, *, /)
     * @return OperatorType
     */
    public static OperatorType fromSymbol(char symbol) {
        for (OperatorType type : values()) {
            if (type.symbol == symbol) {
                return type;
            }
        }
        throw new IllegalArgumentException("올바른 사칙연산 기호(+, -, *, /)를 입력해주세요: " + symbol);
    }

    /**
     * String 기호에 매핑되는 OperatorType을 반환합니다.
     *
     * @param symbol 사칙연산 문자열 (+, -, *, /)
     * @return OperatorType
     */
    public static OperatorType fromSymbol(String symbol) {
        if (symbol == null || symbol.trim().isEmpty()) {
            throw new IllegalArgumentException("사칙연산 기호가 입력되지 않았습니다.");
        }
        return fromSymbol(symbol.trim().charAt(0));
    }

    // 편의용 별칭 메서드
    public static OperatorType from(char symbol) {
        return fromSymbol(symbol);
    }

    public static OperatorType from(String symbol) {
        return fromSymbol(symbol);
    }
}
