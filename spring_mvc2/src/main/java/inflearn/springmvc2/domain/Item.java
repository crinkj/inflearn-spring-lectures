package inflearn.springmvc2.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 1000000, message = "1000보다 커야하고 100000보다 작아야합니다.")
    private int price;

    @NotNull
    @Max(value = 9999, message = "9999 보다 작아야합니다.")
    private int quantity;

    public Item() {

    }

    public Item(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
