package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public abstract class ConnectionDB {

    private Connection connection = null;

    public Connection getConnection(){
        Properties properties = new Properties();
        try (InputStreamReader propertiesFile = new InputStreamReader(
                new FileInputStream(Objects.requireNonNull(getClass()
                        .getClassLoader()
                        .getResource("connection_db.properties"))
                        .getFile()), "UTF-8")) {
            properties.load(propertiesFile);
            if(!properties.isEmpty()){
                String env = properties.getProperty("env");
                if(env != null){
                    String conn = "";
                    String user = "";
                    String pass = "";
                    try {
                        conn = properties.getProperty(env + ".jdbc.conn");
                        user = properties.getProperty(env + ".jdbc.user");
                        pass = properties.getProperty(env + ".jdbc.pass");
                    }finally {
                        if(connection == null || connection.isClosed())
                            this.connection  = DriverManager.getConnection(conn, user, pass);
                    }
                }else
                    System.out.println("La property environment no esta definida.");
            }else
                System.out.println("El archivo de configuracion se encuentra vacio.");
        } catch(IOException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }

    public void closeConnection(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection connection(){
        return this.connection;
    }
}
