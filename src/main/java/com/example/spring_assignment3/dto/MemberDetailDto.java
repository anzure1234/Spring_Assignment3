package com.example.spring_assignment3.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDetailDto {
    private Long id;
    @NotBlank(message = "{common.error.required}")
//    private String username;
//    @NotBlank(message = "{common.error.required}")
//    private String password;
    private String firstName;
    private String lastName;
    @NotBlank(message = "{common.error.required}")
    private String email;
    private int phone;
    private String description;
}
