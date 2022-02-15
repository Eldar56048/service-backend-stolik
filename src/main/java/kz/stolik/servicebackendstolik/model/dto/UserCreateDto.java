package kz.stolik.servicebackendstolik.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserCreateDto {
    private String firstName;
    private String lastName;
    private String secondName;
    private String phoneNumber;
    private String password;
    private Date dateOfBirth;
}
