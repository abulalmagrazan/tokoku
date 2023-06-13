package com.example.TokoKu.security;

import com.example.TokoKu.dao.AccountRepository;
import com.example.TokoKu.entity.Account;
import com.example.TokoKu.service.interfacefile.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Account account=new Account();

        var username=request.getParameter("username");
        var password= request.getParameter("password");
        var role=request.getParameter("role");
        String url="/login/"+role;
        String message="Password salah";
        try{
            account=accountRepository.findById(username).orElseThrow(()->new RuntimeException("not found"));

            if(!account.getRole().toLowerCase().equals(role.toLowerCase())){
                message="akun tidak ditemukan";
            }





            response.sendRedirect(request.getContextPath()+url+"?error="+message);

        }catch (Exception e){
                response.sendRedirect(request.getContextPath()+url+"?error="+"akun tidak ditemukan");
        }
    }
}
