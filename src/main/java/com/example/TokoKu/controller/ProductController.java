package com.example.TokoKu.controller;

import com.example.TokoKu.dto.display.CartDto;
import com.example.TokoKu.dto.display.SellerBreadCrumb;
import com.example.TokoKu.dto.upsert.ProductUpsertDto;
import com.example.TokoKu.service.interfacefile.CategoriesService;
import com.example.TokoKu.service.interfacefile.ProductsService;
import com.example.TokoKu.service.interfacefile.SellersService;
import com.example.TokoKu.service.interfacefile.ShopService;
import com.example.TokoKu.utility.Helper;
import com.example.TokoKu.utility.HelperData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    ProductsService productsService;

    @Autowired
    ShopService shopService;

    @Autowired
    SellersService sellersService;

    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/seller-product")
    public String product(Model model,@RequestParam(required = false) Long shopId,
                          @RequestParam(defaultValue = "")String productName,
                          @RequestParam(defaultValue = "1")Integer page){
        SellerBreadCrumb sellerBreadCrumb=new SellerBreadCrumb(sellersService.findSellerName(getCurrentUser()),shopService.findCurrentShop(shopId));
        if(isAccess("product","seller")) {
            long totalPage = productsService.getCountPage(shopId, productName);
            model.addAttribute("listShopProduct", productsService.getShopProduct(shopId, productName, page));
            if (totalPage == 0) {
                page = 0;
            }
            model.addAttribute("page", page);
            model.addAttribute("totalPage", totalPage);
            model.addAttribute("currentUser", getCurrentUser());
            model.addAttribute("dto", shopService.findShopProfile(shopId, getCurrentUser()));
            model.addAttribute("shopId", shopId);
            model.addAttribute("shopList", shopService.shopListByUser(getCurrentUser(), shopId));
            model.addAttribute("sellerBreadCrumb", sellerBreadCrumb);
            return "/product/product-seller";
        }

        return "redirect:/access-denied";

    }

    @GetMapping("/product-upsert")
    public String productUpsert(Model model, @RequestParam(required = false)Long shopId,
                                @RequestParam(required = false)Long productId){
        if(isAccess("product","upsert")) {
            //data
            ProductUpsertDto dto = new ProductUpsertDto();
            dto.setIdShop(shopId);
            Helper.setUpsertViewModel(dto, "Create", "Product", model);
            if (productId != null) {
                dto = productsService.findByProductId(productId);
                Helper.setUpsertViewModel(dto, "Update", "Product", model);
            }

            model.addAttribute("categoryDropdown", categoriesService.categoryDropdown());
            //header
            SellerBreadCrumb sellerBreadCrumb = new SellerBreadCrumb(sellersService.findSellerName(getCurrentUser()), shopService.findCurrentShop(shopId));
            model.addAttribute("shopId", shopId);
            model.addAttribute("shopList", shopService.shopListByUser(getCurrentUser(), shopId));
            model.addAttribute("sellerBreadCrumb", sellerBreadCrumb);
            //return
            return "/product/product-upsert";
        }
        return "redirect:/access-denied";
    }


    @PostMapping("/product-upsert")
    public String productUpsert(@Valid @ModelAttribute("dto") ProductUpsertDto dto, BindingResult bindingResult,
                                Model model){
        if(bindingResult.hasErrors()){
            Helper.setUpsertViewModel(dto,"Create","Product",model);
            if(dto.getId()!=null){
                Helper.setUpsertViewModel(dto,"Update","Product",model);
            }
            return "product/product-upsert";
        }else{
            MultipartFile multipartFile=dto.getImage();
            String fileName=(dto.getImagePath()==null || dto.getImagePath().equals(null)?null:dto.getImagePath());
            try{
                var imagePath=fileName;
                if(!multipartFile.isEmpty()){
                    imagePath=Helper.uploadPhoto("product",fileName,multipartFile);
                    dto.setImagePath(imagePath);
                }
                productsService.add(dto);
            }catch (Exception e){
                System.out.println("error upload photo");
                Helper.setUpsertViewModel(dto,"Create","Product",model);
                return "/product/product-upsert";
            }
        }
        return "redirect:/product/seller-product?shopId="+dto.getIdShop();
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "")String name,
                         @RequestParam(defaultValue = "0")Double minPrice,
                         @RequestParam(defaultValue = "99999999")Double maxPrice,
                         @RequestParam(defaultValue = "1")Integer page,
                         Model model){
        long totalPage=productsService.countProductSearch(name,minPrice,maxPrice);
        model.addAttribute("listProduct",productsService.getAll(name,minPrice,maxPrice,page));
        if(totalPage==0){page=0;}
        model.addAttribute("page",page);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("minPrice",minPrice);
        model.addAttribute("maxPrice",maxPrice);
        model.addAttribute("name",name);
        return "/product/search";
    }

    @GetMapping("product-detail")
    public String productDetail(Model model,
                                @RequestParam()Long productId){

        model.addAttribute("productDetail",productsService.detail(productId));
        return "/product/product-detail";
    }
}
