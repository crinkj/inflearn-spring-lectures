package inflearn.springmvc2.domain.user;

import inflearn.springmvc2.domain.Item;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private Integer age;
    private String userId;
    private String nickName;
    private String password;

    @OneToMany
    @JoinColumn(name="item_id")
    private List<Item> itemList = new ArrayList<>();
}
