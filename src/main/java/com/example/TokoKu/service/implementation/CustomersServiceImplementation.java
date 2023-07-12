package com.example.TokoKu.service.implementation;

import com.example.TokoKu.dao.CustomersRepository;
import com.example.TokoKu.dto.upsert.NewAccountDto;
import com.example.TokoKu.dto.upsert.RegisterAccountDto;
import com.example.TokoKu.entity.Customers;
import com.example.TokoKu.service.interfacefile.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomersServiceImplementation implements CustomersService {

    @Autowired
    private CustomersRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void add(RegisterAccountDto dto) {
        Customers entity=new Customers(null,dto.getUsername(), encoder.encode(dto.getPassword()),dto.getFirstName(), dto.getLastName(), dto.getBirthDate(),dto.getGender(),dto.getPhone(),dto.getEmail(), LocalDate.now());
        repository.save(entity);
    }

    @Override
    public Long findCustomerId(String username) {
        return repository.findCustomerId(username);
    }
}
