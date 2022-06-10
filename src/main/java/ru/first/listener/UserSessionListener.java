package ru.first.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserSessionListener implements HttpSessionListener {


    public UserSessionListener(){
        System.out.println(">UserSessionListener");
    }

    private int total = 0 , current =0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {

        total++;
        current++;

        System.out.println("All users visited website: " + total);

        System.out.println("Current users on website: " + total);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        current--;

        System.out.println("All users visited website: " + total);

        System.out.println("Current users on website: " + total);

    }
}
