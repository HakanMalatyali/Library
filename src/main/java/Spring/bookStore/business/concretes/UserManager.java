package Spring.bookStore.business.concretes;

import Spring.bookStore.business.abstracts.UserService;
import Spring.bookStore.core.utilities.results.*;
import Spring.bookStore.dataAccess.abstracts.UserDao;
import Spring.bookStore.entities.concretes.Book;
import Spring.bookStore.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserManager implements UserService {


    private UserDao userDao;


    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAllUsers() {
        return new SuccessDataResult<List<User>>
                (this.userDao.findAll(),"Tüm Kullanıcılar Listelendi");
    }

    @Override
    public Result addUser(User user) {
       this.userDao.save(user);
       return new SuccessResult("Kullanıcı Eklendi");
    }

    @Override
    public Result deleteById(int UserId) {
        this.userDao.deleteById(UserId);
        return new SuccessResult("Kullanıcı Silindi");
    }

    @Override
    public DataResult<User> findById(int userId) {
        return new SuccessDataResult<User>
                (this.userDao.findById(userId));
    }

    @Override
    public DataResult<List<User>> findByUsernameAndPassword(String username, String password) {
        return new SuccessDataResult<List<User>>
                (this.userDao.findByUsernameAndPassword(username,password));


    }
}
