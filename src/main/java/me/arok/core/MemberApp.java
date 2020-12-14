package me.arok.core;

import me.arok.core.member.Grade;
import me.arok.core.member.Member;
import me.arok.core.member.MemberService;
import me.arok.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());


    }
}
