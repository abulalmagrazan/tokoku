package com.example.TokoKu.controller;

import com.example.TokoKu.dto.display.SellerBreadCrumb;
import com.example.TokoKu.service.interfacefile.ProductsService;
import com.example.TokoKu.service.interfacefile.SellersService;
import com.example.TokoKu.service.interfacefile.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    ProductsService productsService;

    @Autowired
    ShopService shopService;

    @Autowired
    SellersService sellersService;


    @GetMapping("/seller-product")
    public String product(Model model,@RequestParam(required = false) Long shopId,
                          @RequestParam(defaultValue = "")String productName,
                          @RequestParam(defaultValue = "1")Integer page){
        SellerBreadCrumb sellerBreadCrumb=new SellerBreadCrumb(sellersService.findSellerName(getCurrentUser()),shopService.findCurrentShop(shopId));
        long totalPage=productsService.getCountPage(shopId,productName);
        model.addAttribute("listShopProduct",productsService.getShopProduct(shopId,productName,page));
        if(totalPage==0){page=0;}
        model.addAttribute("page",page);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("currentUser",getCurrentUser());
        model.addAttribute("dto",shopService.findShopProfile(shopId,getCurrentUser()));
        model.addAttribute("shopId",shopId);
        model.addAttribute("shopList",shopService.shopListByUser(getCurrentUser(),shopId));
        model.addAttribute("sellerBreadCrumb",sellerBreadCrumb);
        return "/product/product-seller";

    }

//    @GetMapping("/etalase")
//    public String etalase(Model model,
//                          @RequestParam(defaultValue = "")String productName,
//                          @RequestParam(defaultValue = "1")Integer page){
//        model.addAttribute("productName",productName);
//
//        model.addAttribute("listProduct",productsService.getBySeller(getCurrentUser(),productName,page));
//        long totalPage=productsService.getCountPage(getCurrentUser(),productName);
//        if(totalPage==0){page=0;}
//        model.addAttribute("totalPage",totalPage);
//        model.addAttribute("currentPage",page);
//        model.addAttribute("sellerProfile",shopService.getProfile(getCurrentUser()));
//        return "product/product-etalase";
//    }
}
