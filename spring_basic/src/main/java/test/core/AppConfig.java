package test.core;

import test.core.discount.DiscountPolicy;
import test.core.discount.FixDiscountPolicy;
import test.core.discount.RateDiscountPolicy;
import test.core.member.MemberService;
import test.core.member.MemberServiceImpl;
import test.core.member.MemoryMemberRepository;
import test.core.order.OrderService;
import test.core.order.OrderServiceImpl;

/**
 * 어플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성 하고, 연결하는 책임을 가지는 별도의 설정 클래스를 만들자
 * 1. App Config는 실제 동작에 필요한 구현객체를 생성한다.
 * 2. 생성자를 통해 주입(연결) 해준다.
 */
public class AppConfig {

    // 밑에 메소드를 공통으로 분리 후 new MemoryMemberRepository() 부분이 중복제거
    // DiscountPolicy 와 getMemberRepository 를분리함으로써 역할과 구현이 한눈에 들어와서 전체구성을 쉽게 파악할 수 있다.
    private MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }
}
