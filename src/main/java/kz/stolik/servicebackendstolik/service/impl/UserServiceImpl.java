package kz.stolik.servicebackendstolik.service.impl;

import kz.stolik.servicebackendstolik.exception.domain.UserNotFoundByPhoneNumberException;
import kz.stolik.servicebackendstolik.model.dto.SearchCriteriaDto;
import kz.stolik.servicebackendstolik.model.dto.UserCreateDto;
import kz.stolik.servicebackendstolik.model.dto.UserUpdateDto;
import kz.stolik.servicebackendstolik.model.entity.User;
import kz.stolik.servicebackendstolik.model.enums.Role;
import kz.stolik.servicebackendstolik.model.repository.UserRepository;
import kz.stolik.servicebackendstolik.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bcryptEncoder;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bcryptEncoder, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
        this.bcryptEncoder = bcryptEncoder;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Page<User> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<User> searchWithFilter(List<SearchCriteriaDto> criteria, Pageable pageable) {
        return null;
    }

    @Override
    public User create(UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);
        user.setRoles(new HashSet<>());
        user.getRoles().add(Role.USER);
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User update(UserUpdateDto userUpdateDto) {
        User user = getById(userUpdateDto.getId());
        return user;
    }

    @Override
    public User save(User model) {
        return userRepository.save(model);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.getByPhoneNumber(username).orElseThrow(() -> new UserNotFoundByPhoneNumberException());
    }
}
