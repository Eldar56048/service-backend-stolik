package kz.stolik.servicebackendstolik.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDtoResponse {
    private AuthToken token;
    private UserDtoResponse user;
}

