package com.example.TokoKu.controller;

import com.example.TokoKu.AppUserDetail;
import com.example.TokoKu.GlobalConfiguration;
import com.example.TokoKu.dto.MenuAccessDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.util.Locale;

public class BaseController {
    private String currentUser;
    private String currentRole;

    private Long currentId;

    private boolean access;

    public String getCurrentUser(){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
      return this.currentUser=auth.getName();

    }

    public String getCurrentRole(){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if(getCurrentUser().equals("anonymousUser")){
            return "guest";
        }

        var principal=(AppUserDetail)auth.getPrincipal();
        String role=String.valueOf(principal.getRole());
        return role;
    }

    public Long getCurrentId(){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        var principal=(AppUserDetail)auth.getPrincipal();
        return principal.getIdUser();
    }

    public boolean isAccess(String controller, String action) {
        var menuUser= GlobalConfiguration.datasetMenuAccess().get(getCurrentRole());
        for(MenuAccessDto menu:menuUser){
            if(menu.getController().toLowerCase(Locale.ROOT).equals(controller.toLowerCase(Locale.ROOT)) &&
               menu.getAction().toLowerCase(Locale.ROOT).equals(action.toLowerCase(Locale.ROOT))){
                return true;
            }else {
                continue;
            }
        }
        return false;
    }
}
