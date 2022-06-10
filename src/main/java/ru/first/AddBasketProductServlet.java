package ru.first;

import ru.first.product.Product;
import ru.first.product.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = "/addToBasket")
public class AddBasketProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "name";

    private ProductService ps = null;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ps  = (ProductService)getServletContext().getAttribute(ServletHelper.SC_ATTRIBUTE_PRODUCT_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String pName = request.getParameter(NAME);

        Product selectProduct = ps.get(pName);

        Object myBasket = request.getSession().getAttribute(ServletHelper.SESSION_ATTRIBUTE_PRODUCT_SERVICE);
        if (myBasket !=null) {
            List<Product> list = (List<Product>)myBasket;
            list.add(selectProduct);
        } else {
            List<Product> list = new ArrayList();
            list.add(selectProduct);
            request.getSession().setAttribute(ServletHelper.SESSION_ATTRIBUTE_PRODUCT_SERVICE, list);
        }

        ServletHelper.populateHtmlBegin(response);
        response.getWriter().append("<p>Product Added to basket!<p>");
        ServletHelper.populateHtmlEnd(response);
    }

}
