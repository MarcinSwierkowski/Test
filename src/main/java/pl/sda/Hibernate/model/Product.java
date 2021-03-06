package pl.sda.Hibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Integer id;
    @Column(name = "PRO_NAME")
    private String name;
    @Column(name = "PRO_DESCRIPTION")
    private String description;
    @Column(name = "PRO_PRICE")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "PRO_CAT_ID", referencedColumnName = "CAT_ID")
    private Category category;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;
}
