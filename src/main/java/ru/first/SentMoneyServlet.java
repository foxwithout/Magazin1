package ru.first;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/money")
public class SentMoneyServlet extends HttpServlet {


    @Override
    public void init() throws ServletException  {
        System.out.println(">Starting SentMoneyServlet");
    }

    public SentMoneyServlet() {
        System.out.println("Running");
    }

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Random r  = new Random();

        System.out.println("HelloServlet is invoking");
        response.getWriter().append("Hello! This random number: "+ r.nextInt());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }
}
