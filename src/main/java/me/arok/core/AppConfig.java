package me.arok.core;

import me.arok.core.discount.FixDiscountPolicy;
import me.arok.core.member.MemberService;
import me.arok.core.member.MemberServiceImpl;
import me.arok.core.member.MemoryMemberRepository;
import me.arok.core.order.OrderService;
import me.arok.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
