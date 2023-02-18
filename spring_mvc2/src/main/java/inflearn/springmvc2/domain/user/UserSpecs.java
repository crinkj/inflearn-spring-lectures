package inflearn.springmvc2.domain.user;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class UserSpecs {
    public static final String USERID = "userId";
    public static final String NICKNAME = "nickname";
    public static final String AGE = "age";

    public static Specification<User> userId(String userId) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb)
                -> cb.equal(root.get(USERID), userId);
    }

    public static Specification<User> nickname(String nickname) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb)
                -> cb.equal(root.get(NICKNAME), nickname);
    }

    public static Specification<User> age(int minAge, int maxAge) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb)
                -> cb.between(root.get(AGE), minAge, maxAge);
    }
}
