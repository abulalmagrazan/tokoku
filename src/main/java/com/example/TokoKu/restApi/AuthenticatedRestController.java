package com.example.TokoKu.restApi;

import com.example.TokoKu.dto.RequestRestDto;
import com.example.TokoKu.dto.ResponseCrudDto;
import com.example.TokoKu.service.interfacefile.AccountService;
import com.example.TokoKu.utility.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AuthenticatedRestController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/authenticated")
    public ResponseCrudDto post(@RequestBody RequestRestDto dto){
        try{
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword());
            authenticationManager.authenticate(token);
        }catch (Exception e){

        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
        String token =jwtToken.generateToken(dto.getSubject(), dto.getUsername(), dto.getSecretKey(),dto.getRole(),dto.getAudience());
        var response = new ResponseCrudDto(HttpStatus.OK,"success",token);
        return response;
    }
}
