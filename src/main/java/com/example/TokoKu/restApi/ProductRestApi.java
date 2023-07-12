package com.example.TokoKu.restApi;

import com.example.TokoKu.dto.ResponseCrudDto;
import com.example.TokoKu.service.interfacefile.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductRestApi {

    @Autowired
    ProductsService productsService;


    @GetMapping("/getAll/productName={productName}/minPrice={minPrice}/maxPrice={maxPrice}")
    public ResponseCrudDto get(@PathVariable(required = false) String productName,
                               @PathVariable(required = false) Double minPrice,
                               @PathVariable(required = false) Double maxPrice,
                               @RequestParam(defaultValue = "1") Integer page){
        try{

            var product=productsService.getAll(productName,minPrice,maxPrice,page);
            if(!product.isEmpty()){
                return new ResponseCrudDto(HttpStatus.OK,"Success",product);
            }else{
                return new ResponseCrudDto(HttpStatus.NOT_FOUND,"Product Not Found");
            }
        }catch (Exception e){
            return new ResponseCrudDto(HttpStatus.INTERNAL_SERVER_ERROR,"Not Found Object Product",e);
        }
    }

//    @GetMapping("/getProductShop")
//    public ResponseCrudDto getProductByShop(){
//        try{
//        }catch (Exception e){
//
//        }
//    }



}
