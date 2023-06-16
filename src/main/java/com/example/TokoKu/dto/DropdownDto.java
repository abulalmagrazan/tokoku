package com.example.TokoKu.dto;
import lombok.*;

//@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class DropdownDto {
    private String stringValue;
    private String text;

    public DropdownDto(String stringValue, String text) {
        this.stringValue = stringValue;
        this.text = text;
    }
    public DropdownDto(Long stringValue, String text) {
        this.stringValue = stringValue.toString();
        this.text = text;
    }
}
