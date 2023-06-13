package com.example.TokoKu.entity;
import com.example.TokoKu.utility.CartId;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity
@Table(name = "Cart")
@IdClass(CartId.class)
public class Cart {
    @Id
    @Column(name = "IdCustomer")
    private Long idCustomer;

    @Id
    @Column(name = "IdProduct")
    private Long idProduct;

    @Column(name="Quantity")
    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "IdCustomer",insertable = false,updatable = false)
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "IdProduct",insertable = false,updatable = false)
    private Products products;

    public Cart(Long idCustomer, Long idProduct, Integer qty) {
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.qty = qty;
    }
}
