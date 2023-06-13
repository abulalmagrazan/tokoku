package com.example.TokoKu.dao;


import com.example.TokoKu.dto.display.ShopBySellerDto;
import com.example.TokoKu.entity.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SellersRepository extends JpaRepository<Sellers,Long> {

    @Query("""
            SELECT s.id
            FROM Sellers as s
            WHERE s.username=:username
            """)
    public Long findSellerId(@Param("username")String username);

    @Query("""
            SELECT CONCAT(se.firstName,' ',se.lastName)
            FROM Sellers AS se
            WHERE se.username=:username
            """)
    public String findSellerName(@Param("username")String username);
}
