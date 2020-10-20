package controllers;

import dto.UserResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/inject")
    public void inject() {
        userService.add(new User("Bob", "Hob", "bob@mail"));
        userService.add(new User("Alisa", "Gob", "alisa@mail"));
        userService.add(new User("Joe", "Mob", "joe@mail"));
        userService.add(new User("Tim", "Kob", "tim@mail"));
    }

    @GetMapping(value = "/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) {
        User user = userService.getById(userId);
        return createUserDto(user);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(this::createUserDto)
                .collect(Collectors.toList());
    }

    private UserResponseDto createUserDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setName(user.getFirstName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
