package com.example.TokoKu.controller;

import com.example.TokoKu.dto.upsert.NewAccountDto;
import com.example.TokoKu.dto.upsert.RegisterAccountDto;
import com.example.TokoKu.service.interfacefile.AccountService;
import com.example.TokoKu.service.interfacefile.CustomersService;
import com.example.TokoKu.service.interfacefile.SellersService;
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


    @GetMapping("/seller")
    public String seller() {
        return "login/login-seller";
    }

    @GetMapping("/seller-register")
    public String sellerRegister(Model model){
        RegisterAccountDto dto=new RegisterAccountDto() ;

        model.addAttribute("dto",dto);
        return "login/register-seller";
    }

    @PostMapping("/seller-register")
    public String sellerRegister(@Valid @ModelAttribute("dto")RegisterAccountDto dto,
                                 BindingResult bindingResult,Model model){
       dto.setRole("Seller");
        if(bindingResult.hasErrors()){
            model.addAttribute("dto",dto);
            return "login/register-seller";
        }else{
            sellersService.add(dto);
            accountService.add(dto);
            return "redirect:/login/seller";
        }
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "login/login-form";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "login/access-denied";
    }


    @GetMapping("/register")
    public String register(Model model){
        RegisterAccountDto dto=new RegisterAccountDto();
        model.addAttribute("dto",dto);
        return "login/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("dto")RegisterAccountDto dto,
                           BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("dto",dto);
            return "login/register";
        }else{
            if(dto.role.equals("customer")){
                customersService.add(dto);
                accountService.add(dto);
                return "redirect:/login/loginForm";
            }else{
                sellersService.add(dto);
                accountService.add(dto);
                return "redirect:/login/loginForm";
            }

        }
    }
}
