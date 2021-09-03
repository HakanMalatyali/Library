package Spring.bookStore.business.abstracts;

import Spring.bookStore.core.utilities.results.DataResult;
import Spring.bookStore.core.utilities.results.Result;
import Spring.bookStore.entities.concretes.User;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAllUsers();
    Result addUser(User user);
    Result deleteById(int userId);
    DataResult<User> findById(int userId);
    DataResult<List<User>> findByUsernameAndPassword(String username,String password);
}
