package kz.stolik.servicebackendstolik.service;

import kz.stolik.servicebackendstolik.model.dto.UserCreateDto;
import kz.stolik.servicebackendstolik.model.dto.UserUpdateDto;
import kz.stolik.servicebackendstolik.model.entity.User;
import kz.stolik.servicebackendstolik.service.base.CrudService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CrudService<User, UserCreateDto, UserUpdateDto>, UserDetailsService {
}
