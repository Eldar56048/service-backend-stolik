package kz.stolik.servicebackendstolik.controller;

import kz.stolik.servicebackendstolik.model.dto.UserCreateDto;
import kz.stolik.servicebackendstolik.model.entity.User;
import kz.stolik.servicebackendstolik.service.UserService;
import kz.stolik.servicebackendstolik.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserCreateDto createDto) {
        return ResponseEntity.ok(userService.create(createDto));
    }
}
