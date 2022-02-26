package test.core.member;

public class MemberServiceImpl implements MemberService{

    // private final MemberRepository memberRepository;
    // 할경우 NullpointerException이 나올수 있으니 구현체 선택을 해줘야한다.
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
