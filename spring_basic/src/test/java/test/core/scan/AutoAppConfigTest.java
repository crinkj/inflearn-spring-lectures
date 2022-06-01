package test.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.core.AutoAppConfig;
import test.core.member.MemberService;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan(){

        // @Component 로 등록한 스프링 빈과
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
