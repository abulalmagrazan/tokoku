package com.example.TokoKu;

import com.example.TokoKu.dao.AccountRepository;
import com.example.TokoKu.dao.CustomersRepository;
import com.example.TokoKu.dao.SellersRepository;
import com.example.TokoKu.dto.LoginAccessDto;
import com.example.TokoKu.entity.Account;
import com.example.TokoKu.entity.Customers;
import com.example.TokoKu.security.CustomAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository accRepo;

    @Autowired
    private CustomersRepository cusRepo;

    @Autowired
    private SellersRepository selRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        var role = request.getParameter("role");
        Long idUser=null;
        Account userLogin= accRepo.findById(username).orElseThrow(()->new RuntimeException("Username "+username+" not Found"));
        if(role!=null){
            if(role.toLowerCase().equals("customer")){
                idUser=cusRepo.findCustomerId(userLogin.getUsername());
            }
            if(role.toLowerCase().equals("seller")){
                idUser=selRepo.findSellerId(userLogin.getUsername());
            }
        }
        LoginAccessDto accessDto= new LoginAccessDto (userLogin.getUsername(),userLogin.getPassword(),idUser,userLogin.getRole(),role);
        return new AppUserDetail(accessDto);
    }


}