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

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
