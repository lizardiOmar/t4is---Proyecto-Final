package uv.mx.apiServicioSocial.apiSS.DB;

import java.sql.Statement;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Coordinador {
    private int idCoordinador;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String token;
    public Coordinador(int idCoordinador, String nombres, String apellidoPaterno, String apellidoMaterno,
            String token) {
        this.idCoordinador = idCoordinador;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.token = token;
    }
    public int getIdCoordinador() {
        return idCoordinador;
    }
    public void setIdCoordinador(int idCoordinador) {
        this.idCoordinador = idCoordinador;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    @Override
    public String toString() {
        return "Coordinador [apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno
                + ", idCoordinador=" + idCoordinador + ", nombres=" + nombres + ", token=" + token + "]";
    }
    public static Coordinador getCoordinadorByToken(String token){
        Coordinador c=null;
        Statement statement;
        try{
            Connection conn= Conexion.getConexion();
            statement = conn.createStatement();
            ResultSet rs=statement.executeQuery("select * from coordinadores where token='"+token+"';");
            if(rs.next()){
                c = new Coordinador(rs.getInt("idCoordinador"), rs.getString("nombres"), rs.getString("apellidoPaterno"), rs.getString("apellidoMaterno"), rs.getString("token"));
            }
            rs.close();
            statement.close();
            conn.close();
        }catch(SQLException | URISyntaxException e){
            System.out.println(e.getMessage());
        }
        return c;
    }
    public static Coordinador getCoordinadorById(int idCoordinador){
        Coordinador c=null;
        Statement statement;
        try{
            Connection conn= Conexion.getConexion();
            statement = conn.createStatement();
            ResultSet rs=statement.executeQuery("select * from coordinadores where idCoordinador="+idCoordinador+";");
            if(rs.next()){
                c = new Coordinador(rs.getInt("idCoordinador"), rs.getString("nombres"), rs.getString("apellidoPaterno"), rs.getString("apellidoMaterno"), rs.getString("token"));
            }
            rs.close();
            statement.close();
            conn.close();
        }catch(SQLException | URISyntaxException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Coordinador: "+c.toString());
        return c;
    }
}
