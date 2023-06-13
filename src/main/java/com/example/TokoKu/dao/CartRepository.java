package com.example.TokoKu.dao;

import com.example.TokoKu.entity.Cart;
import com.example.TokoKu.utility.CartId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, CartId> {

}
