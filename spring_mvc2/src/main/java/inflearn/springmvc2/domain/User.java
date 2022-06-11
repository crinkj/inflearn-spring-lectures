package inflearn.springmvc2.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String password;

    @OneToMany
    @JoinColumn(name="item_id")
    private List<Item> itemList = new ArrayList<>();
}
