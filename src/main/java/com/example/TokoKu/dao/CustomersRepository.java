package com.example.TokoKu.dao;

import com.example.TokoKu.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomersRepository extends JpaRepository<Customers,Long> {

}
