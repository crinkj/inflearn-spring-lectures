package test.core;

import test.core.member.Grade;
import test.core.member.Member;
import test.core.member.MemberService;
import test.core.member.MemberServiceImpl;
import test.core.order.Order;
import test.core.order.OrderService;
import test.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.calculatePrice());
    }
}
