package inflearn.springmvc2.domain.user;

import inflearn.springmvc2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers(Specification<User> specs) {
        return userRepository.findAll(specs);
    }

    public List<User> orderByDesc(){
        return userRepository.findAllByOrderByIdDesc();
    }

    public List<User> orderBySort(Sort sort){
        return userRepository.findAll(sort);
    }

    public List<User> findAllByPageable(Pageable pageable){
        return userRepository.findAllBy(pageable);
    }
}
