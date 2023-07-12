package com.example.TokoKu.controller;

import com.example.TokoKu.dto.display.CartDto;
import com.example.TokoKu.entity.Cart;
import com.example.TokoKu.service.interfacefile.CartService;
import com.example.TokoKu.service.interfacefile.CustomersService;
import com.example.TokoKu.service.interfacefile.ProductsService;
import com.example.TokoKu.service.interfacefile.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/transaction")
public class TransactionController extends BaseController {

    @Autowired
    ShopService shopService;

    @Autowired
    ProductsService productsService;

    @Autowired
    CartService cartService;

    @Autowired
    CustomersService customersService;

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("cartList",cartService.getCartList(getCurrentId()));
        model.addAttribute("idCustomer",getCurrentId());
        return "/transaction/cart";
    }

    @GetMapping("/addCart")
    public String addCart(@RequestParam Long idProduct,@RequestParam Integer quantity,Model model){
//        if(isAccess("transaction","addCart"))
        cartService.add(getCurrentId(),idProduct,quantity);
    return "redirect:/";
    }
}
