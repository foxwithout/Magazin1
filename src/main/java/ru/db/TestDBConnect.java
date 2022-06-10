package ru.db;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TestDBConnect {

//    public static final String MYSQL_DB_URL = "jdbc:mysql://localhost/shop";
//    public static final String MYSQL_DB_USER = "user";
//    public static final String MYSQL_DB_PASSWORD = "123456";

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Properties props = getProperties();

            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

//            System.out.println("Connect:" +url);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection connection =
//                         DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASSWORD)) {
                         DriverManager.getConnection(url, username, password)) {

                System.out.println("Connect:" + connection);
                System.out.println("Connect:Successfully!");

        }
    }   catch(Exception ex) {
        System.out.println("Connection failed. . .");
        System.out.println(ex);
        }
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        try (
            InputStream in = Files.newInputStream(Paths.get("src/main/resources/database.properties"))){
            props.load(in);
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }
}
