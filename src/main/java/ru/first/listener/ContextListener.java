package ru.first.listener;

import ru.first.ServletHelper;
import ru.first.product.ProductService;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">>>> ContextListener is working!");

      ServletContext sc =  sce.getServletContext();

      ProductService ps = new ProductService();

      sc.setAttribute(ServletHelper.SC_ATTRIBUTE_PRODUCT_SERVICE, ps);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
