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

public class ClientBookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pagesize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo,pagesize);

        page.setUrl("client/bookServlet?action=page");

        req.setAttribute("page",page);

        req.getRequestDispatcher("../pages/client/index.jsp").forward(req,resp);

    }


    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pagesize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo,pagesize,min,max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(req.getParameter("min") != null)
        {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max") != null)
        {
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());

        req.setAttribute("page",page);

        req.getRequestDispatcher("../pages/client/index.jsp").forward(req,resp);

    }

}
