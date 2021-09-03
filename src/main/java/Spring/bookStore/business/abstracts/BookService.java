package Spring.bookStore.business.abstracts;

import Spring.bookStore.core.utilities.results.DataResult;
import Spring.bookStore.core.utilities.results.Result;
import Spring.bookStore.entities.concretes.Book;
import Spring.bookStore.entities.concretes.Category;

import javax.xml.crypto.Data;
import java.util.List;

public interface BookService {
    DataResult<List<Book>> getAll();
    DataResult<List<Book>> pageAll(int pageNo, int pageSize);
    Result add(Book book);
    Result deleteAll();
    Result deleteById(int id);
    Result update(Book book);
    DataResult<Book> findById(int id);
    DataResult<List<Book>> findByCategory_CategoryId(int categoryId);
    DataResult<Book> findByBookName(String bookName);
    DataResult<List<Book>> findByBookNameContains(String bookName);
    DataResult<List<Book>> findByBookNameStartsWith(String bookName);
    DataResult<List<Book>> findByAuthor(String authorName);
    DataResult<List<Book>> findByAuthorContains(String authorName);

}
