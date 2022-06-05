package inflearn.springmvc2.repository;

import inflearn.springmvc2.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;

@Transactional
public interface ItemRepository extends JpaRepository<Item, Id> {
}
