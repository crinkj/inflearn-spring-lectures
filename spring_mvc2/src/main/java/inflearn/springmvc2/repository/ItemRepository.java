package inflearn.springmvc2.repository;

import inflearn.springmvc2.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface ItemRepository extends JpaRepository<Item, Id> {
}
