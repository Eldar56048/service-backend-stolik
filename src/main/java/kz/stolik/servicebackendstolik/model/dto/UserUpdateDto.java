package kz.stolik.servicebackendstolik.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

import static kz.stolik.servicebackendstolik.constants.validation.UserValidationConstants.*;

@Getter
@Setter
public class UserUpdateDto {
    @NotNull(message = USER_ID_REQUIRED_MESSAGE)
    private Long id;
    @NotBlank(message = USER_FIRST_NAME_REQUIRED_MESSAGE)
    private String firstName;
    @NotBlank(message = USER_LAST_NAME_REQUIRED_MESSAGE)
    private String lastName;
    private String secondName;
    @NotNull(message = USER_DATE_OF_BIRTH_REQUIRED_MESSAGE)
    @Past(message = USER_DATE_OF_BIRTH_SHOULD_BE_PAST_DATE_MESSAGE)
    private Date dateOfBirth;
}
