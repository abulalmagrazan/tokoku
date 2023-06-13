package com.example.TokoKu.utility;

import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class CartId implements Serializable {

    private Long idCustomer;

    private Long idProduct;
}
