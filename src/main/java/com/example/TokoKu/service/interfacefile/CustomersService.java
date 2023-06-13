package com.example.TokoKu.service.interfacefile;

import com.example.TokoKu.dto.upsert.NewAccountDto;
import com.example.TokoKu.dto.upsert.RegisterAccountDto;

public interface CustomersService {
    public void add(RegisterAccountDto dto);
}
