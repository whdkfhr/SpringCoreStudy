package me.arok.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);

        // ThreadA : A 사용자, 10000주문
        int userAPrice = bean1.order("userA", 10000);

        // ThreadB : B 사용자, 20000주문
        int userBPrice = bean2.order("userB", 20000);

        // ThreadA : A 사용자, 주문 금액 조회
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(bean1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
