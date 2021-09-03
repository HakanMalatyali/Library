package Spring.bookStore.api.controller;

import Spring.bookStore.business.abstracts.UserService;
import Spring.bookStore.core.utilities.results.DataResult;
import Spring.bookStore.core.utilities.results.Result;
import Spring.bookStore.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }


    @GetMapping("/getAllUsers")
    public DataResult<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public Result addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(int userId){
        return userService.deleteById(userId);
    }

    @PostMapping("/findById")
    DataResult<User> findById(int userId){
        return userService.findById(userId);
    }

    @GetMapping("/findByUsernameAndPassword")
    DataResult<List<User>> findByUsernameAndPassword(@RequestParam String username,@RequestParam String password){
        return userService.findByUsernameAndPassword(username,password);
    }
}
