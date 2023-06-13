package com.example.TokoKu.service.implementation;

import com.example.TokoKu.dao.SellersRepository;
import com.example.TokoKu.dto.display.ShopBySellerDto;
import com.example.TokoKu.dto.upsert.NewAccountDto;
import com.example.TokoKu.dto.upsert.RegisterAccountDto;
import com.example.TokoKu.entity.Sellers;
import com.example.TokoKu.service.interfacefile.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SellersServiceImplementation implements SellersService {

    @Autowired
    private SellersRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void add(RegisterAccountDto dto) {
        Sellers entity=new Sellers(null,dto.getUsername(), encoder.encode(dto.getPassword()),dto.getFirstName(), dto.getLastName(), dto.getBirthDate(),dto.getGender(),dto.getPhone(), LocalDate.now());
        repository.save(entity);
    }

    @Override
    public Long findSellerId(String username) {
        return repository.findSellerId(username);
    }

    @Override
    public String findSellerName(String username) {
        return repository.findSellerName(username);
    }


}
