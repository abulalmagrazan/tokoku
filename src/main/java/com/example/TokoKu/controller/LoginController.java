package com.example.TokoKu.controller;

import com.example.TokoKu.dto.upsert.NewAccountDto;
import com.example.TokoKu.dto.upsert.RegisterAccountDto;
import com.example.TokoKu.service.interfacefile.AccountService;
import com.example.TokoKu.service.interfacefile.CustomersService;
import com.example.TokoKu.service.interfacefile.SellersService;
import com.example.TokoKu.utility.Helper;
import com.example.TokoKu.utility.HelperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AccountService accountService;
    @Autowired
    CustomersService customersService;
    @Autowired
    SellersService sellersService;

//login
    @GetMapping("/seller")
    public String seller() {
        return "login/login-seller";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "login/loginForm";
    }

    //register get
    @GetMapping("/register")
    public String customerRegister(Model model){
        RegisterAccountDto dto=new RegisterAccountDto() ;
        Helper.setRegisterViewModel(dto,"Account",model);
        return "/login/register";
    }

    @GetMapping("/seller-register")
    public String sellerRegister(Model model,String role){
        RegisterAccountDto dto=new RegisterAccountDto() ;
        Helper.setRegisterViewModel(dto, "Seller", model);
        return "login/seller-register";
    }


    //register post

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("dto")RegisterAccountDto dto,
                                 BindingResult bindingResult,Model model){
            dto.setRole("Customer");
            if(bindingResult.hasErrors()){
                Helper.setRegisterViewModel(dto, "Account", model);
                return "login/register";
            }else{
                customersService.add(dto);
                accountService.add(dto);
                return "redirect:/login/loginForm";
            }
    }

    @PostMapping("/seller-register")
    public String sellerRegister(@Valid @ModelAttribute("dto")RegisterAccountDto dto,
                                 BindingResult bindingResult,Model model){
            dto.setRole("Seller");
            if(bindingResult.hasErrors()){
                Helper.setRegisterViewModel(dto, "Seller", model);
                return "login/register";
            }else{
                sellersService.add(dto);
                accountService.add(dto);
                return "redirect:/login/seller";
            }
    }


    @GetMapping("/access-denied")
    public String accessDenied(){
        return "login/access-denied";
    }


}
