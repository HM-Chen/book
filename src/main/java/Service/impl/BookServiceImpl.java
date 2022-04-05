package Service.impl;

import Dao.impl.BookDao;
import Dao.impl.BookDaoImpl;
import Pojo.Book;
import Pojo.Page;

import java.util.List;

public class BookServiceImpl implements BookService{
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookBYId(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pagesize) {
        Page<Book> page = new Page<Book>();

        page.setPagesize(pagesize);

        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pagesize;
        if(pageTotalCount % pagesize > 0)
        {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pagesize;

        List<Book> items = bookDao.queryForPageItems(begin,pagesize);

        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pagesize, int min, int max) {
        Page<Book> page = new Page<Book>();

        page.setPagesize(pagesize);

        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pagesize;
        if(pageTotalCount % pagesize > 0)
        {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pagesize;

        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pagesize,min,max);

        page.setItems(items);

        return page;
    }
}
