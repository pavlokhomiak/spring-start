package controllers;

import dto.UserResponseDto;
import java.util.ArrayList;
import java.util.List;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void inject(@RequestParam String firstName,
                         @RequestParam(required = false) String lastName,
                         @RequestParam String email) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userService.add(user);
    }

    @GetMapping(value = "/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) {
        User user = userService.getById(userId);
        UserResponseDto dto = new UserResponseDto();
        dto.setName(user.getFirstName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    @GetMapping(value = "/")
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> dtoList = new ArrayList<>();
        for (User user : userService.listUsers()) {
            UserResponseDto dto = new UserResponseDto();
            dto.setName(user.getFirstName());
            dto.setEmail(user.getEmail());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
