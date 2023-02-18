package inflearn.springmvc2.repository;


import inflearn.springmvc2.domain.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Id> {

    List<User> findAll(Specification<User> spec);

    List<User> findAllByOrderByIdDesc();

    List<User> findAll(Sort sort);

    List<User> findAllBy(Pageable pageable);
}
