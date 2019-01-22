package kido.example.userservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable String id) {
        return "userId : " + id;
    }

    @GetMapping("/users/error/{id}")
    public String getUserError(@PathVariable String id) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            System.out.println("NO ~~~~~~");
            return "No ~~~~~ ";
        }
        return "userId : " + id;
    }
}
