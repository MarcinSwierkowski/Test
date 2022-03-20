package pl.sda.JDBC.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class Order {

    private Integer id;
    private LocalDateTime orderDate;
    private BigDecimal price;
    private User user;
}
