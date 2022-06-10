package ru.first;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/begin")
public class ServletBegin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletHelper.populateHtmlBegin(resp);
        resp.getWriter().append("<p>I'm begin servlet</p>");

        System.out.println("ServletBegin is running!");

        Cookie c = new Cookie("product-category", "1");
        c.setMaxAge(15);
        resp.addCookie(c);

       RequestDispatcher rd =  req.getRequestDispatcher("/middle");
       rd.forward(req, resp);
    }
}
