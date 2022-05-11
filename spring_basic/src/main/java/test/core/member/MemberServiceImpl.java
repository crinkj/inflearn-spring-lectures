package test.core.member;

public class MemberServiceImpl implements MemberService{

    // private final MemberRepository memberRepository;
    // 할경우 NullpointerException이 나올수 있으니 구현체 선택을 해줘야한다.
    // 도메인 설계시 역할과 구현을 분리해서 자유롭게 구현 객체를 조립할 수 있게 설계해야한다 그래야 변경이 설계에 변경이 있어도 유연하게 대처한다.(인터페이스를 사용하는 이유와 중요성)

    // AppConfig를 설정하기 전엔
    // private final MemberRepository member Repository = new MemoryMemberRepository();
    // MemoryMemberRepository 클래스에 의존성이 있엇다.
    // 하지만 AppConfig에 MemberServiceImpl 생성자 주입을 통해 추상화에만 의존한다(DIP를 지킨다)
    // memberServiceImpl은 AppConfig를 통해 의존관계 주입이 되는상태이다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
