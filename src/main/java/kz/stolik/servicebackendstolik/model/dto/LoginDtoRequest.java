package kz.stolik.servicebackendstolik.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDtoRequest {
    private String username;
    private String password;
}

