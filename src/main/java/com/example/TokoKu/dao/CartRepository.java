package com.example.TokoKu.dao;

import com.example.TokoKu.dto.display.CartDto;
import com.example.TokoKu.entity.Cart;
import com.example.TokoKu.utility.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart, CartId> {

    @Query("""
            SELECT new com.example.TokoKu.dto.display.CartDto(ca.idCustomer,ca.idProduct,pr.name,pr.image,pr.price,ca.qty)
            FROM Cart AS ca
            LEFT JOIN ca.products AS pr
            WHERE ca.idCustomer=:idUser
            """)
    public List<CartDto>getCartList(@Param("idUser")Long idUser);

}
