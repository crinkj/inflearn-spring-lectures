package test.core.member;

public class MemberServiceImpl implements MemberService{

    // private final MemberRepository memberRepository;
    // 할경우 NullpointerException이 나올수 있으니 구현체 선택을 해줘야한다.
    // 도메인 설계시 역할과 구현을 분리해서 자유롭게 구현 객체를 조립할 수 있게 설계해야한다 그래야 변경이 설계에 변경이 있어도 유연하게 대처한다.(인터페이스를 사용하는 이유와 중요성)
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
