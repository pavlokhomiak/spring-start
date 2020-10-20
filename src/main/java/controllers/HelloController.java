package controllers;

import dto.UserResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ResponseBody
    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello";
    }

    @ResponseBody
    @GetMapping("/userDto")
    public UserResponseDto getUser() {
        UserResponseDto dto = new UserResponseDto();
        dto.setName("Bob");
        dto.setEmail("bob@i.ua");
        return dto;
    }
}
