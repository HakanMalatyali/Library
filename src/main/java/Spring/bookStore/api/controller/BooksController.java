package Spring.bookStore.api.controller;

import Spring.bookStore.business.abstracts.BookService;
import Spring.bookStore.core.utilities.results.DataResult;
import Spring.bookStore.core.utilities.results.Result;
import Spring.bookStore.entities.concretes.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")

@CrossOrigin
public class BooksController {

    private  BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Book>> getAll(){
        return bookService.getAll();
    }

    @GetMapping("pageAll")
    public DataResult<List<Book>> pageAll(@RequestParam int pageNo,@RequestParam int pageSize){
        return bookService.pageAll(pageNo,pageSize);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Book book){
        return bookService.add(book);
    }

    @DeleteMapping("/deleteAll")
    public Result deleteAll(){
        return bookService.deleteAll();
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam int id){
        return bookService.deleteById(id);
    }

    @PostMapping("/updateBook")
    Result updateBook(@Valid @RequestBody Book book){
        return bookService.update(book);
    }

    @GetMapping("/findById")
    public DataResult<Book> findById(@RequestParam int id){
        return bookService.findById(id);
    }

    @GetMapping("/findByCategoryId")
    public DataResult<List<Book>> findByCategory_CategoryId(@RequestParam int categoryId){
        return bookService.findByCategory_CategoryId(categoryId);
    }

    @GetMapping("/findByBookName")
    public DataResult<Book> findByBookName(@RequestParam String bookName){
        return this.bookService.findByBookName(bookName);
    }

    @GetMapping("/findByBookNameContains")
    DataResult<List<Book>> findByBookNameContains(@RequestParam String bookName){
        return this.bookService.findByBookNameContains(bookName);
    }

    @GetMapping("/findByBookNameStartsWith")
    DataResult<List<Book>> findByBookNameStartsWith(@RequestParam String bookName){
        return this.bookService.findByBookNameStartsWith(bookName);
    }

    @GetMapping("/findByAuthor")
    DataResult<List<Book>> findByAuthor(String authorName){
        return this.bookService.findByAuthor(authorName);
    }

    @GetMapping("/findByAuthorContains")
    DataResult<List<Book>> findByAuthorContains(String authorName){
        return this.bookService.findByAuthorContains(authorName);
    }



}
