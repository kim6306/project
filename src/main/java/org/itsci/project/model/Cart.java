package org.itsci.project.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "product_cart", joinColumns = {@JoinColumn(name = "cart_id")}, inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> products;
    @NotNull
    @Pattern(regexp = "^CH[0-9]{3}")
    @Column(name = "code", length = 10, nullable = false, unique = true)
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void fill(Cart cart) {
        this.code = cart.getCode();

    }
}
