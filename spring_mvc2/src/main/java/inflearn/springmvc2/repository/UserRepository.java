package inflearn.springmvc2.repository;


import inflearn.springmvc2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Id> {

    Optional<User> findUserByUserIdAndPassword(User user);
}
