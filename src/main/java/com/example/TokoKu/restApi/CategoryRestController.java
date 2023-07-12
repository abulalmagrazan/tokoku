package com.example.TokoKu.restApi;

import com.example.TokoKu.dto.ResponseCrudDto;
import com.example.TokoKu.service.interfacefile.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryRestController {


    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/getAll")
    public ResponseCrudDto get(){
        try{
            var data =categoriesService.getAll();
            return new ResponseCrudDto(HttpStatus.OK,"Success",data);
        }catch (Exception e){
            return new ResponseCrudDto(HttpStatus.INTERNAL_SERVER_ERROR,"Error","failed");
        }
    }
}
