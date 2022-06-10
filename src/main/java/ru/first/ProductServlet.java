package ru.first;

import ru.first.product.Product;
import ru.first.product.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Random;


@WebServlet(urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "name";

    public static final String CATEGORY = "category";
    public static final String PRICE = "price";

    private ProductService ps = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ps  = (ProductService)getServletContext().getAttribute(ServletHelper.SC_ATTRIBUTE_PRODUCT_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String productName = request.getParameter(NAME);
        String category = request.getParameter(CATEGORY);
        Product foundProduct = ps.getAll().get(productName);


        if (category!=null && category.length() > 0) {
            Cookie c = new Cookie("product-category", category);
            c.setMaxAge(15);
            response.addCookie(c);
        }

        ServletHelper.populateHtmlBegin(response);

        if (foundProduct != null) {
            response.getWriter().append("<p> Name: " + foundProduct.getName() + " Category " +
                    foundProduct.getCategory() + " Price: " + foundProduct.getPrice() + "</p>");
            response.getWriter().append("<p><a href=\"./addToBasket?name="  + foundProduct.getName() + "\">Add to basket</a></p>");
        } else {
            response.getWriter().append("<p>Unknown product<p>");
        }

        ServletHelper.populateHtmlEnd(response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String pName = request.getParameter(NAME);
        String pCategory = request.getParameter(CATEGORY);
        String pPrice = request.getParameter(PRICE);

        Product product = new Product(pName, Double.valueOf(pPrice), pCategory);
        ps.add(product);

        ServletHelper.populateHtmlBegin(response);
        response.getWriter().append("<p>New product added!</p>");
        ServletHelper.populateHtmlEnd(response);
    }


}
