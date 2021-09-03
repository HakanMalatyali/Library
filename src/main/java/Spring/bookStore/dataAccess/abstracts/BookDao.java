package Spring.bookStore.dataAccess.abstracts;

import Spring.bookStore.entities.concretes.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {

    Book findById(int id);
    Book findByBookName(String bookName);
    Book deleteById(int id);
    List<Book> findByCategory_CategoryId(int categoryId);
    List<Book> findByBookNameContains(String bookName);
    List<Book> findByBookNameStartsWith(String bookName);
    List<Book> findByAuthor(String authorName);
    List<Book> findByAuthorContains(String authorName);

}
