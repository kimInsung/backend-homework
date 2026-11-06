# backend-homework 
# Java 계산기 과제 (Spring 7기)

콘솔 기반으로 동작하는 사칙연산 계산기 구현 프로젝트입니다. 단계별 리팩토링을 통해 객체지향 원칙, 제네릭, Enum, 그리고 Stream API를 적용했습니다.

---

## 🛠 개발 환경
- **언어**: Java 17
- **IDE**: IntelliJ IDEA
- **도구**: Git / GitHub

---

## 📌 단계별 구현 기능

### STEP 1. 절차적 콘솔 계산기 (`App.java`)
- `Scanner`를 통한 피연산자 및 사칙연산 기호(+, -, *, /) 입력 처리
- `switch`문을 활용한 기본 사칙연산 수행
- 나눗셈 분모가 0일 경우 예외 안내 메시지 출력 및 비정상 종료 방어
- `exit` 입력 시까지 무한 반복 실행

### STEP 2. 클래스 분리 및 연산 결과 누적 (`Calculator.java`)
- 비즈니스 연산 로직을 전담하는 `Calculator` 클래스 분리
- 연산 결과를 순서대로 저장하는 `List<Integer>` 컬렉션 필드 선언 및 `private` 캡슐화
- 캡슐화 유지를 위한 간접 접근 메서드(Getter/Setter) 구현
- 연산 결과 삭제(`removeResult`) 및 전체 목록 조회 기능 추가

### STEP 3. Enum, 제네릭 및 Stream API 적용 (`ArithmeticCalculator.java`, `OperatorType.java`)
- **`OperatorType` (Enum)**: 사칙연산 기호 상수 정의 및 연산 로직 캡슐화
- **`ArithmeticCalculator<T extends Number>` (Generic)**: 정수와 실수(`Double`) 연산을 모두 처리할 수 있는 유연한 설계
- **Stream API & Lambda**: 저장된 연산 결과 중 사용자가 입력한 기준값보다 큰 값만 필터링하여 출력하는 기능 구현

---

## 📂 패키지 구조
```text
src/
└── com/
    └── example/
        └── calculator/
            ├── App.java
            ├── Calculator.java
            ├── ArithmeticCalculator.java
            └── OperatorType.java