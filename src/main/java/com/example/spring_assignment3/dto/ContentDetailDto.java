package com.example.spring_assignment3.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentDetailDto {
    private Long id;
    @NotBlank(message = "{common.error.required}")
    private String title;

    @NotBlank(message = "{common.error.required}")
    private String brief;
    @NotBlank(message = "{common.error.required}")
    private String content;

    private String sort;

}
