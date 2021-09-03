package Spring.bookStore.dataAccess.abstracts;

import Spring.bookStore.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    User deleteById(int userId);
    User findById(int userId);
    List<User> findByUsernameAndPassword(String username,String password);




}
