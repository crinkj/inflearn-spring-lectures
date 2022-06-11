package inflearn.springmvc2.repository;

import inflearn.springmvc2.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface ItemRepository extends JpaRepository<Item, Id> {
}
