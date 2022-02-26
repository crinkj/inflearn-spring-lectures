package test.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

	/**
	 * 단위 테스트가 중요하다. 라이브러리도 많아지고 데이터베이스도 연결하고 하면 무거워져서 로드하는데 속도가오래걸린다
	 * 단위 테스트를하면 스프링이나 컨테이너 도움없이 순수하게 자바 코드만으로만 테스트를 진행하기 떄문에
	 * 프로젝트가 아무리 커지고 무거워져도 빠르게 테스트를 할 수 있는 장점이 있다.
	 * 단위 테스트는 선택이 아닌 필수
	 * */

	@Test
	void contextLoads() {
	}

}
