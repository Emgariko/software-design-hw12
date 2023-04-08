package app.controller;

import app.controller.dto.UserDto;
import app.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public interface UserController {
    @PostMapping
    Mono<User> register(@RequestBody UserDto user);
}
