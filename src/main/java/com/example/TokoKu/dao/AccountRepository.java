package com.example.TokoKu.dao;

import com.example.TokoKu.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account,String> {

    @Query("""
            SELECT COUNT(*)
            FROM Account AS ac
            WHERE ac.username=:username
            """)
    public long getCountUsername(@Param("username") String username);


    @Query("""
            SELECT ac.role
            FROM Account AS ac
            WHERE ac.username=:username
            """)
    public String getRoleByUsername(@Param("username")String name);
}
