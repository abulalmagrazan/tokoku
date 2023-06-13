package com.example.TokoKu.service.implementation;

import com.example.TokoKu.dao.AccountRepository;
import com.example.TokoKu.dto.upsert.RegisterAccountDto;
import com.example.TokoKu.entity.Account;
import com.example.TokoKu.service.interfacefile.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void add(RegisterAccountDto dto) {
        Account entity=new Account(dto.getUsername(), encoder.encode(dto.getRetypePassword()),dto.getRole());
        repository.save(entity);
    }
    @Override
    public long getCountUsername(String username) {
        return repository.getCountUsername(username);
    }


    @Override
    public String getRoleByUsername(String name) {
        return repository.getRoleByUsername(name);
    }
}
