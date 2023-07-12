package com.example.TokoKu.service.implementation;

import com.example.TokoKu.dao.CartRepository;
import com.example.TokoKu.dto.display.CartDto;
import com.example.TokoKu.entity.Cart;
import com.example.TokoKu.service.interfacefile.CartService;
import com.example.TokoKu.utility.CartId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    CartRepository repository;
    @Override
    public void add(Long idCustomer, Long idProduct, Integer quantity) {
        Cart entity= new Cart(idCustomer,idProduct,quantity);
        repository.save(entity);
    }

    @Override
    public List<CartDto> getCartList(Long idUser) {
        return repository.getCartList(idUser);
    }

    @Override
    public String countQuantity(Long customerId, Long productId, Integer qty) {
       var data= repository.findById(new CartId(customerId,productId)).orElse(null);
       String hasil="gagal update data";
        if(data!=null){
            data.setQty(qty);
            repository.save(data);
            hasil="data bersahil di update";
        }
        return hasil;
    }
}
