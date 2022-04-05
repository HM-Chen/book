package web;

import Pojo.Book;
import Pojo.Page;
import Service.impl.BookService;
import Service.impl.BookServiceImpl;
import Utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();




    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pagesize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo,pagesize);

        page.setUrl("manager/bookServlet?action=page");

        req.setAttribute("page",page);

        req.getRequestDispatcher("../pages/manager/book_manager.jsp").forward(req,resp);

    }


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo += 1;
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());

        bookService.addBook(book);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Book> books = bookService.queryBooks();

        req.setAttribute("books",books);

        req.getRequestDispatcher("../pages/manager/book_manager.jsp").forward(req,resp);

    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("../pages/manager/book_edit.jsp").forward(req,resp);

    }


}
