package Service.impl;

import Pojo.Book;
import Pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pagesize);

    Page<Book> pageByPrice(int pageNo, int pagesize, int min, int max);
}
