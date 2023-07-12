package com.example.TokoKu;



import com.example.TokoKu.dto.MenuAccessDto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GlobalConfiguration {


    public static HashMap<String, List<MenuAccessDto>> datasetMenuAccess(){

        var datasetMenuAccess= new HashMap<String,List<MenuAccessDto>>();
        datasetMenuAccess.put("Administrator",new LinkedList<>(Arrays.asList(
               new MenuAccessDto("Home","home","indexAdmin")
        )));
        datasetMenuAccess.put("Customer",new LinkedList<>(Arrays.asList(
               new MenuAccessDto("Home","home","indexCustomer")
        )));
        datasetMenuAccess.put("Seller",new LinkedList<>(Arrays.asList(
               new MenuAccessDto("Home","home","seller"),
                new MenuAccessDto("Product","product","seller"),
                new MenuAccessDto("Product","product","upsert"),
                new MenuAccessDto("Shop","shop","index"),
                new MenuAccessDto("Shop","shop","upsert"),
                new MenuAccessDto("Shop","shop","profile")
        )));

        return datasetMenuAccess;
    }
}
