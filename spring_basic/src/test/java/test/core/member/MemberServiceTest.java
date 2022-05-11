package test.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.core.AppConfig;

public class MemberServiceTest{


    MemberService memberService;

    // test실행전 무조건 실행, 테스트가 두개일시 이 메소드 두번 돈다.
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    /**
     * - 개발한 기능을 실행해서 테스트 할 때 자바의 main 메서드를 통해서 실행하거나,
     * 웹어플리케이션의 컨트롤러를 통해서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래걸리고,
     * 반복 실행하기 어려워서 여러 테스트를 한번에 실행하기 어렵다는 단점이 있다.
     * 자바는 JUnit이라는 프레임워크로 단위 테스트를 진행해서 이러한 문제를 해결한다
     * - test 패키지안에 메인과 같은 구조의 클래스를 생성후 이름뒤에Test를 맞춰준다( ]
     * 메인 패키지 클래스:MemoryMemberRepository면 test패키지안에 클래스는 MemoryMemberRepositoryTest이다.
     * 테스트하려는 클래스를 임포트 한 후
     *                  public void에 @TEST 어노테이션을 단후 임포트한 클래스의 메소드를 테스트하고 사용하면된다

     * - Assertions.assertEquals(객체1,객체2)
     * - Assertions.assertThat(객체1).isEqualTo(객체2);
     */
    @Test
    void join(){
        // given
        Member member = new Member(1L, "memberA",Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
