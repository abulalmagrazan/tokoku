package com.example.TokoKu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCrudDto {
    private HttpStatus status;
    private String message;
    private Object object;

    public ResponseCrudDto(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
