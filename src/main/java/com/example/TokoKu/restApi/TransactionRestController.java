package com.example.TokoKu.restApi;

import com.example.TokoKu.dto.ResponseCrudDto;
import com.example.TokoKu.service.interfacefile.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController {

    @Autowired
    CartService cartService;


    @GetMapping("/getCart/customerId={customerId}")
    public ResponseCrudDto getCart(@PathVariable(required = false) Long customerId){
        try {
            var product = cartService.getCartList(customerId);
            if(!product.isEmpty()){
                return new ResponseCrudDto(HttpStatus.OK,"Success",product);
            }else {
                return new ResponseCrudDto(HttpStatus.NOT_FOUND,"Not Found");

            }
        }catch (Exception e){
            return new ResponseCrudDto(HttpStatus.INTERNAL_SERVER_ERROR,"countProduct error handler");
        }
    }

    @PostMapping("/countProduct/{idCustomer}/{idProduct}/{qty}")
    public ResponseCrudDto countProduct(@PathVariable(required = false) Long idCustomer,
                                            @PathVariable(required = false) Long idProduct,
                                            @PathVariable(required = false) Integer qty){
        try {
            var hasil=cartService.countQuantity(idCustomer,idProduct,qty);
            return new ResponseCrudDto(HttpStatus.OK,"update status",hasil);
        }catch (Exception e){
            return new ResponseCrudDto(HttpStatus.INTERNAL_SERVER_ERROR,"Error");
        }
    }
}
