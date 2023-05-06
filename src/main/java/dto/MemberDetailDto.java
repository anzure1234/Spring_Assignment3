package dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDetailDto {
    private Long id;
    @NotBlank(message = "{common.error.required}")
    private String username;
    @NotBlank(message = "{common.error.required}")
    private String password;
    @NotBlank(message = "{common.error.required}")
    private String email;
}
