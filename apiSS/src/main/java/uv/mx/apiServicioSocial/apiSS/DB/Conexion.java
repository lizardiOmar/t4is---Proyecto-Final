package uv.mx.apiServicioSocial.apiSS.DB;

import java.net.URI;
import java.net.URISyntaxException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
        Connection c=null;
        try{
            Class.forName("org.postgresql.Driver");
            c=DriverManager.getConnection(dbUrl, username, password);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return c;
    }
}