package ru.first;

import ru.first.basket.BasketService;
import ru.first.product.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// TODO: Refactor!
@WebServlet(urlPatterns = "/remove")
public class RemoveProductFromBasketServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

       Integer id = Integer.valueOf(request.getParameter("id"));

        Object myBasket = request.getSession().getAttribute(ServletHelper.SESSION_ATTRIBUTE_PRODUCT_SERVICE);

        BasketService.removeFromBasket((int) id, (List<Product>) myBasket);

        RequestDispatcher rd = request.getRequestDispatcher("/viewBasket");
        rd.include(request, response);

    }

}
