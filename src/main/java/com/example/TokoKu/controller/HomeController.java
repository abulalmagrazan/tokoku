package com.example.TokoKu.controller;

import com.example.TokoKu.dto.display.SellerBreadCrumb;
import com.example.TokoKu.service.interfacefile.CategoriesService;
import com.example.TokoKu.service.interfacefile.ProductsService;
import com.example.TokoKu.service.interfacefile.SellersService;
import com.example.TokoKu.service.interfacefile.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    @Autowired
    CategoriesService categoriesService;
    @Autowired
    ProductsService productsService;

    @Autowired
    SellersService sellersService;

    @Autowired
    ShopService shopService;



    @GetMapping("/index")
    public String index(){
        getCurrentUser();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(getCurrentRole().toLowerCase(Locale.ROOT).equals("administrator")){
            return "redirect:/home/indexAdmin";
        }else if(getCurrentRole().toLowerCase(Locale.ROOT).equals("seller")){

            return "redirect:/home/seller";
        }else{

            return "redirect:/home/indexGuest";
        }
    }

    @GetMapping("/indexCustomer")
    public String indexCustomer(Model model){
        model.addAttribute("listCategory",categoriesService.getAll());
        model.addAttribute("listProduct",productsService.getAll());
        return "home/home-customers";
    }

    @GetMapping("/indexGuest")
    public String indexGuest(Model model){
        model.addAttribute("listCategory",categoriesService.getAll());
        model.addAttribute("listProduct",productsService.getAll());
        return "home/second-index";
    }

    @GetMapping("/seller")
    public String indexSeller(Model model, @RequestParam(required = false) Long shopId){
        if(isAccess("home","seller")){
            SellerBreadCrumb sellerBreadCrumb=new SellerBreadCrumb(sellersService.findSellerName(getCurrentUser()),shopService.findCurrentShop(shopId));
            if(shopId==null){
                return "redirect:/shop/index";
            }

            model.addAttribute("sellerBreadCrumb",sellerBreadCrumb);
            model.addAttribute("currentUser",getCurrentUser());
            model.addAttribute("shopId",shopId);
            model.addAttribute("shopList",shopService.shopListByUser(getCurrentUser(),shopId));
            return "home/homeSeller";
        }
        return "redirect:/access-denied";
    }

    @GetMapping("/indexAdmin")
    public String indexAdmin(){
        return "home/home-admin";
    }

}
