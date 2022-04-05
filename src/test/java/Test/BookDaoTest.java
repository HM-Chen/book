package Test;

import Dao.impl.BookDao;
import Dao.impl.BookDaoImpl;
import Pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

       private BookDao bookDao = new BookDaoImpl();
       @Test
       public void addBook() {
           bookDao.addBook(new Book(null,"水滸傳","191125",new BigDecimal(99),1000,0,null));
       }

       @Test
       public void deleteBookById() {
           bookDao.deleteBookById(22);
       }

       @Test
       public void updateBook() {
           bookDao.updateBook(new Book(22,"三国","191125",new BigDecimal(99),1000,0,null));
       }

       @Test
       public void queryBookBYId() {
           System.out.println(bookDao.queryBookBYId(22));
       }

       @Test
       public void queryBooks() {

           System.out.println(bookDao.queryBooks());
       }


}