package Test;

import Pojo.Book;
import Service.impl.BookService;
import Service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {


    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"水浒传","123456",new BigDecimal(13),55,500,null));

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(23,"红楼梦","123456",new BigDecimal(13),55,500,null));
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBooks() {
    }
}