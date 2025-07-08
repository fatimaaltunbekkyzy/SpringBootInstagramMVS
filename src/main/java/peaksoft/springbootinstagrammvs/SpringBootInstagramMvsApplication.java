package peaksoft.springbootinstagrammvs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import peaksoft.springbootinstagrammvs.entites.User;
import peaksoft.springbootinstagrammvs.service.UserService;

@SpringBootApplication
public class SpringBootInstagramMvsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInstagramMvsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserService userService) {
        return args -> {
//userService.save(new User("Sakina","123","s@gmail.com","+996509082733"));
//userService.save(new User("Safia","1234","sf@gmail.com","+996509082733"));
//userService.save(new User("Melis","12345","m@gmail.com","+996509082733"));
//userService.save(new User("Ajelika","123456","a@gmail.com","+996509082733"));
//            userService.updateUser(4L,new User("Elizar","e123zar","e@gmail.com","+996223293390"));
//            userService.deleteUser(4L);
//            System.out.println(userService.getAllUser());
//            System.out.println(userService.findById(1L));
//            System.out.println(userService.search("Safia"));
        };
    }
}