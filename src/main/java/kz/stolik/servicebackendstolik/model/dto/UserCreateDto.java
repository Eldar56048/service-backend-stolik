package kz.stolik.servicebackendstolik.model.dto;

import kz.stolik.servicebackendstolik.annotation.annotation.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

import static kz.stolik.servicebackendstolik.constants.validation.UserValidationConstants.USER_PASSWORD_REQUIRED_MESSAGE;

@Getter
@Setter
public class UserCreateDto {
    @PhoneNumber(required = true)
    private String phoneNumber;
    @NotBlank(message = USER_PASSWORD_REQUIRED_MESSAGE)
    private String password;
}
