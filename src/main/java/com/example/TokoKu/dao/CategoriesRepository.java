package com.example.TokoKu.dao;


import com.example.TokoKu.dto.DropdownDto;
import com.example.TokoKu.dto.display.CategoryDisplayDto;
import com.example.TokoKu.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CategoriesRepository extends JpaRepository<Categories,Long> {

    @Query("""
            SELECT new com.example.TokoKu.dto.display.CategoryDisplayDto(ca.id,ca.name,ca.description,ca.img)
            FROM Categories AS ca
            
            """)
    public List<CategoryDisplayDto>getAll();

    @Query("""
            SELECT new com.example.TokoKu.dto.DropdownDto(ca.name,ca.id)
            FROM Categories AS ca
            """)
    public List<DropdownDto>categoryDropdown();
}
