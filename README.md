## SpringCoreStudy

### 비즈니스 요구사항과 설계
+ 회원
  + 회원 가입 및 조회
  + 회원은 일반, VIP 두 가지 등급
  + 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.(미확정)
+ 주문과 할인 정책
  + 회원은 상품을 주문할 수 있다.
  + 회원 등급에 따라 할인 정책을 적용
  + 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용.(나중에 변경 가능)
  + 할인 정책은 변경 가능성이 높다. 기본 할인 정책은 아직 미정. 최악의 경우 할인을 적용하지 않을 수 있다.
  
+ 회원 데이터, 할인 정책 같은 부분들이 결정될 때 까지 기다리기 보다는, 인터페이스를 만들고 구현체를 얼마든지 갈아끼울 수 있도록 설계를 해보자!

+ "참고" : 우선 순수한 자바로만 개발을 하고, 이후에 스프링 사용

------------

### 회원 도메인 설계
