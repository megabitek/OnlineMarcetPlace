/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemarketplace;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;

/**
 *
 * @author admin
 */
public class ConnectionFactory {

    static Connection connections;
//    private static final  String FILE_PROPERTY_NAME = "/utils/database.properties";

    public static java.sql.Connection getConnection() throws Exception {
        if (connections == null) {
            return createConnection();
        } else {
            return connections;
        }
    }

    private static Connection createConnection() throws IOException, ClassNotFoundException {
        String FILE_PROPERTY_NAME = "/utils/database.properties";
        Properties properties = new Properties();
        try {
            InputStream in = Class.class.getResourceAsStream(FILE_PROPERTY_NAME);
            properties.load(in);
            String driverName = properties.getProperty("database.driverName");
            String userName = properties.getProperty("database.username");
            String password = properties.getProperty("database.password");
            String connectionString = properties.getProperty("database.url");
            Locale locale = Locale.getDefault();
            Locale.setDefault(Locale.ENGLISH);
            Class.forName(/*properties.getProperty(driverName)*/"oracle.jdbc.driver.OracleDriver");
            java.sql.Connection connection = DriverManager.getConnection(connectionString, userName, password);
// создание подключения*/
            return connection;
        //} catch (IOException ex) {
            //   System.out.println("Not connection!!! ");
            //      return null;
        } catch (SQLException ex) {
            System.out.println("Not connection!!! ");
            return null;
            /*throw new RuntimeException(ex.getMessage());
             */ }

    }

}
