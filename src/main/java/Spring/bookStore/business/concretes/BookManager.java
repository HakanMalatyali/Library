package Spring.bookStore.business.concretes;

import Spring.bookStore.business.abstracts.BookService;
import Spring.bookStore.core.utilities.results.DataResult;
import Spring.bookStore.core.utilities.results.Result;
import Spring.bookStore.core.utilities.results.SuccessDataResult;
import Spring.bookStore.core.utilities.results.SuccessResult;
import Spring.bookStore.dataAccess.abstracts.BookDao;
import Spring.bookStore.entities.concretes.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements BookService {

    private BookDao bookDao;

    @Autowired
    public BookManager(BookDao bookDao) {
        super();
        this.bookDao = bookDao;
    }

    @Override
    public DataResult<List<Book>> getAll() {
        return new SuccessDataResult<List<Book>>
                (this.bookDao.findAll(),"Kitaplar Listelendi");
    }

    @Override
    public DataResult<List<Book>> pageAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return new SuccessDataResult<List<Book>>
                (this.bookDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Book book) {
        this.bookDao.save(book);
        return new SuccessResult("Kitap Eklendi");

    }

    @Override
    public Result deleteAll() {
        this.bookDao.deleteAll();
        return new SuccessResult("Tüm kitaplar Silindi");
    }

    @Override
    public Result deleteById(int id) {
        this.bookDao.deleteById(id);
        return new SuccessResult("Kitap Silindi");
    }


    @Override
    public Result update(Book book) {
        Book bookUpdate = this.bookDao.getById(book.getId());
        bookUpdate.setBookName(book.getBookName());
        bookUpdate.setAuthor(book.getAuthor());
        bookUpdate.setReleaseDate(book.getReleaseDate());

        this.bookDao.save(bookUpdate);
        return new SuccessResult("Kitap Başarılı Bir Şekilde Güncellendi");
    }


    @Override
    public DataResult<Book> findById(int id) {
        return new SuccessDataResult<Book>
                (this.bookDao.findById(id),"Kitap Listelendi");
    }

    @Override
    public DataResult<List<Book>> findByCategory_CategoryId(int categoryId) {
        return new SuccessDataResult<List<Book>>
                (this.bookDao.findByCategory_CategoryId(categoryId),"Kitaplar Listelendi");
    }

    @Override
    public DataResult<Book> findByBookName(String bookName) {
        return new SuccessDataResult<Book>
                (this.bookDao.findByBookName(bookName),"Kitap Listelendi");
    }

    @Override
    public DataResult<List<Book>> findByBookNameContains(String bookName) {
        return new SuccessDataResult<List<Book>>
                (this.bookDao.findByBookNameContains(bookName),"Kitaplar Listelendi");
    }

    @Override
    public DataResult<List<Book>> findByBookNameStartsWith(String bookName) {
        return new SuccessDataResult<List<Book>>
                (this.bookDao.findByBookNameStartsWith(bookName),"Kitaplar Listelendi");
    }

    @Override
    public DataResult<List<Book>> findByAuthor(String authorName) {
        return new SuccessDataResult<List<Book>>
                (this.bookDao.findByAuthor(authorName),"Yazar Listelendi");
    }

    @Override
    public DataResult<List<Book>> findByAuthorContains(String authorName) {
        return new SuccessDataResult<List<Book>>
                (this.bookDao.findByAuthorContains(authorName),"Yazarlar Listelendi");
    }
}
