package me.arok.core;

import me.arok.core.member.Grade;
import me.arok.core.member.Member;
import me.arok.core.member.MemberService;
import me.arok.core.member.MemberServiceImpl;
import me.arok.core.order.Order;
import me.arok.core.order.OrderService;
import me.arok.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order : " + order);
    }
}
