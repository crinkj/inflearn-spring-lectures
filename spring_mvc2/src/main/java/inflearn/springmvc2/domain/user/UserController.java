package inflearn.springmvc2.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("users")
    public List<User> getUsers(){
        Specification<User> spec = UserSpecs.age(20, 30);
        return userService.getUsers(spec);
    }
}
