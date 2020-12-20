package me.arok.core;

import me.arok.core.discount.DiscountPolicy;
import me.arok.core.discount.FixDiscountPolicy;
import me.arok.core.discount.RateDiscountPolicy;
import me.arok.core.member.MemberRepository;
import me.arok.core.member.MemberService;
import me.arok.core.member.MemberServiceImpl;
import me.arok.core.member.MemoryMemberRepository;
import me.arok.core.order.OrderService;
import me.arok.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
