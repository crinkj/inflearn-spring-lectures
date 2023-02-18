package inflearn.springmvc2.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService service;

    @Test
    public void spec_조회_테스트() {
        Specification<User> specs = UserSpecs.age(20, 30);

        List<User> users = service.getUsers(specs);
        Assertions.assertTrue(users.size() > 0);
    }

    @Test
    public void 정렬_테스트(){
        List<User> users = service.orderByDesc();
        Assertions.assertTrue(!users.isEmpty());
    }

    @Test
    public void sort테스트(){
        Sort sort = Sort.by("id").descending();
        List<User> users = service.orderBySort(sort);
    }

    @Test
    public void 페이징테스트(){
        PageRequest pageReq = PageRequest .of(2, 4);
        List<User> users = service.findAllByPageable(pageReq);
    }
}