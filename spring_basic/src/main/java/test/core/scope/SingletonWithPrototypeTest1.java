package test.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);

    }

    @Test
    void singletonClientUserPrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(2);
    }

    /*
        이렇게 생성자 주입으로 prototypeBean을 사용하면
        싱글턴처럼 공유하게 된다. 그래서
        직접 applicationContext를 통해 주입을 하던가
        ObjectProvider(스프링에 의존적)/ JSR-330 Provider(라이브러리 추가 필요) 둘중에 하나를 사용해야한다.
     */
    @Scope("singleton")
    static class ClientBean {
        /*
            싱글턴에서 prototype사용하는법
            밑과같이  ObjectPRovider를 사용하면 싱글턴안에서 프로토타입을 사용할 수 있다.
            @Autowired
            private ObjectProvider<PrototypeBean> prototypeBeanProvider;

            public int logic(){
                PrototypeBean prototypeBean = prototypeBeanProvide.getObject();
                prototypeBean.addCount();
                return prototypeBean.getCount();
            }
         */
        private final PrototypeBean prototypeBean; // 생성시점에 주입

        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic(){
            prototypeBean.addCount();
            return  prototypeBean.getCount();
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
