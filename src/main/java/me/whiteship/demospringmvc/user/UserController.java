package me.whiteship.demospringmvc.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController { //핸들러 코드


    @GetMapping("/hello")
    public  String hello(){
        return "hello";
    }


    @PostMapping("/users/create")
        public User create(@RequestBody User user){

        return user;
}

}
