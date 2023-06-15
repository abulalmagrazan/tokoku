package com.example.TokoKu.service.interfacefile;


import com.example.TokoKu.dto.DropdownDto;
import com.example.TokoKu.dto.display.CategoryDisplayDto;
import com.example.TokoKu.entity.Categories;

import java.util.List;

public interface CategoriesService {
    public List<CategoryDisplayDto> getAll();
    public List<DropdownDto> categoryDropdown();
}
