package test.core.order;

import test.core.discount.DiscountPolicy;
import test.core.discount.FixDiscountPolicy;
import test.core.member.Member;
import test.core.member.MemberRepository;
import test.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // AppConfig에서 구현체를 관리를 해서
    // OrderServiceImpl 입장에서는 생성자를 통해 어떤 구현 객체가 들어올지 모른다.
    // 오직 외부(AppConfig)에서 결정된다.
    // 구현체에 의존하지 않고 추상화인(MemberRepository,DiscountPolicy)에만 의존한다.
    private final MemberRepository memberRepository;
    // final 키워드를 이용함으로써 생성자에 필수로 주입받아야함을 명시
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // SRP(Single responsibility principal) 단일 책임 원칙
        // 한 클래스는 하나의 책임만 가져야한다
        // 밑에 discountPolicy 같은 경우에는 discountPolicy의 메소드인 discount이 할인에
        // 관한 전권을 책임지기 때문에 설계가 잘 되있는 경우다.
        // 할인에 대한 변경이 필요하면 할인에 대한 서비스(discountPolicy)만 변경하면된다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice, discountPrice);
    }
}
