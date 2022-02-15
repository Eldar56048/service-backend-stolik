package kz.stolik.servicebackendstolik.model.dto;

import kz.stolik.servicebackendstolik.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String secondName;
    private String phoneNumber;
    private Set<Role> roles;
    private boolean enabled;
}
