package app.service;

import app.controller.UserController;
import app.controller.dto.UserDto;
import app.domain.User;
import app.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService implements UserController {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> register(UserDto userDto) {
        User user = new User(userDto.getName(), User.Currency.valueOf(userDto.getCurrency()));
        return userRepository.save(user);
    }
}
