package com.example.TokoKu.service.implementation;


import com.example.TokoKu.dao.CategoriesRepository;
import com.example.TokoKu.dto.DropdownDto;
import com.example.TokoKu.dto.display.CategoryDisplayDto;
import com.example.TokoKu.service.interfacefile.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImplementation implements CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public List<CategoryDisplayDto> getAll() {
        return categoriesRepository.getAll();
    }

    @Override
    public List<DropdownDto> categoryDropdown() {
        return categoriesRepository.categoryDropdown();
    }
}
