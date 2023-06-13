package com.example.TokoKu.service.interfacefile;

import com.example.TokoKu.dto.upsert.RegisterAccountDto;

public interface AccountService {
    public long getCountUsername(String username);
    public void add(RegisterAccountDto dto);
    public String getRoleByUsername(String name);

}
