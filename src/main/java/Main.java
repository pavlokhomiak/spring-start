import config.AppConfig;
import java.util.List;
import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        final UserService userService = context.getBean(UserService.class);

        User firstUser = new User();
        firstUser.setFirstName("Pavlo1");
        firstUser.setLastName("Khomiak");
        firstUser.setEmail("email1@gmail.com");
        System.out.println(firstUser);
        userService.add(firstUser);
        System.out.println(firstUser);

        User secondUser = new User();
        secondUser.setFirstName("Bob");
        secondUser.setLastName("Bober");
        secondUser.setEmail("email2@gmail.com");
        userService.add(secondUser);
        System.out.println(secondUser);

        User thirdUser = new User();
        thirdUser.setFirstName("Alice");
        thirdUser.setLastName("Alisha");
        thirdUser.setEmail("email3@gmail.com");
        userService.add(thirdUser);
        System.out.println(thirdUser);

        List<User> users = userService.listUsers();
        users.forEach(System.out::println);
    }
}
