package com.example.TokoKu.service.interfacefile;


import com.example.TokoKu.dto.display.CartDto;
import com.example.TokoKu.entity.Cart;

import java.util.List;

public interface CartService {
    public void add(Long idCustomer,Long idProduct,Integer quantity);

    public List<CartDto> getCartList(Long idUser);

    public String countQuantity(Long customerId, Long productId,Integer qty);

}
