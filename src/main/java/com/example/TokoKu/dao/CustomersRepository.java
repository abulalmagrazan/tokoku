package com.example.TokoKu.dao;

import com.example.TokoKu.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomersRepository extends JpaRepository<Customers,Long> {

    @Query("""
            SELECT cu.id
            FROM Customers AS cu
            WHERE cu.username=:username
            """)
    public Long findCustomerId(@Param("username") String username);

}
