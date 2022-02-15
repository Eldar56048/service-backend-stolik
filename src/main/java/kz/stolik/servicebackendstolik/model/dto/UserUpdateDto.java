package kz.stolik.servicebackendstolik.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserUpdateDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String secondName;
    private Date dateOfBirth;
}
