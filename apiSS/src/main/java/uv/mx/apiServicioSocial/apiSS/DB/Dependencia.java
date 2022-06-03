package uv.mx.apiServicioSocial.apiSS.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;

public class Dependencia {
    private int idDependencia;
    private String nombre;
    private String colonia;
    private String calle;
    private int numero;
    private String nombreEncargado;
    private String apellidoPaternoEncargado;
    private String apellidoMaternoEncargado;
    private String correoEncargado;
    private String telefono;
    private int idCoordinador; 

    public Dependencia(int idDependencia, String nombre, String colonia, String calle, int numero, String nombreEncargado, String apellidoPaternoEncargado, String apellidoMaternoEncargado, String correoEncargado, String telefono, int idCoordinador) {
        this.idDependencia = idDependencia;
        this.nombre = nombre;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
        this.nombreEncargado = nombreEncargado;
        this.apellidoPaternoEncargado = apellidoPaternoEncargado;
        this.apellidoMaternoEncargado = apellidoMaternoEncargado;
        this.correoEncargado = correoEncargado;
        this.telefono = telefono;
        this.idCoordinador = idCoordinador;
    }
    
    public Dependencia(){
        
    }

    public int getIdDependencia() {
        return idDependencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public String getApellidoPaternoEncargado() {
        return apellidoPaternoEncargado;
    }

    public String getApellidoMaternoEncargado() {
        return apellidoMaternoEncargado;
    }

    public String getCorreoEncargado() {
        return correoEncargado;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdDependencia(int idDependencia) {
        this.idDependencia = idDependencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public void setApellidoPaternoEncargado(String apellidoPaternoEncargado) {
        this.apellidoPaternoEncargado = apellidoPaternoEncargado;
    }

    public void setApellidoMaternoEncargado(String apellidoMaternoEncargado) {
        this.apellidoMaternoEncargado = apellidoMaternoEncargado;
    }

    public void setCorreoEncargado(String correoEncargado) {
        this.correoEncargado = correoEncargado;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setIdCoordinador(int idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    @Override
    public String toString() {
        return "Dependencia{" + "idDependencia=" + idDependencia + ", nombre=" + nombre + ", colonia=" + colonia + ", calle=" + calle + ", numero=" + numero + ", nombreEncargado=" + nombreEncargado + ", apellidoPaternoEncargado=" + apellidoPaternoEncargado + ", apellidoMaternoEncargado=" + apellidoMaternoEncargado + ", correoEncargado=" + correoEncargado + ", telefono=" + telefono + ", idCoordinador=" + idCoordinador +'}';
    }
    
    //Agregar Dependencia 
    public static boolean registrarDependencia(Dependencia a){
        boolean resultado=false;
        try{
            String query =  " insert into dependencias (nombre, colonia, calle, numero, nombreEncargado, apellidoPaternoEncargado, apellidoMaternoEncargado, correoEncargado, telefono, idCoordinador)"+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            Connection connection= Conexion.getConexion();
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.setString(1, a.getNombre());
            preparedStmt.setString(2, a.getColonia());
            preparedStmt.setString(3, a.getCalle());
            preparedStmt.setInt(4, a.getNumero());
            preparedStmt.setString(5, a.getNombreEncargado());
            preparedStmt.setString(6, a.getApellidoPaternoEncargado());
            preparedStmt.setString(7, a.getApellidoMaternoEncargado());
            preparedStmt.setString(8, a.getCorreoEncargado());
            preparedStmt.setString(9, a.getTelefono());
            preparedStmt.setInt(10, a.getIdCoordinador());

            preparedStmt.execute();
            resultado=true;
            preparedStmt.close();
            connection.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (URISyntaxException e) {
            
        }
        return resultado;
    }
    //Eliminar dependencia
    public static boolean eliminarDependencia(int idDependencia){
        boolean validacion = false;
        Connection connection = null;
        try {
            connection = Conexion.getConexion();
            PreparedStatement eliminarDependencia = connection.prepareStatement("delete from dependencias where idDependencia = ?");
            eliminarDependencia.setInt(1, idDependencia);
            eliminarDependencia.execute();
            validacion = true;
            
               
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        } catch (URISyntaxException ex){
            System.out.println(ex.getLocalizedMessage());
        }finally{
            try {
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
        return validacion;
    }
    //Actualizar dependencia
    public static boolean actualizarDependencia(Dependencia dependencia){
        boolean validacion = false;
        Connection connection = null;
        try {
            connection = Conexion.getConexion();
            PreparedStatement actualizarDependencia = connection.prepareStatement("update dependencias set nombre = ?, colonia = ?, calle = ?, numero = ?, nombreEncargado = ?, apellidoPaternoEncargado = ?,  apellidoMaternoEncargado = ?, correoEncargado = ?, telefono = ?, idCoordinador = ? where idDependencia = ?");
            actualizarDependencia.setString(1, dependencia.getNombre());
            actualizarDependencia.setString(2, dependencia.getColonia());
            actualizarDependencia.setString(3, dependencia.getCalle());
            actualizarDependencia.setInt(4, dependencia.getNumero());
            actualizarDependencia.setString(5, dependencia.getNombreEncargado());
            actualizarDependencia.setString(6, dependencia.getApellidoPaternoEncargado());
            actualizarDependencia.setString(7, dependencia.getApellidoMaternoEncargado());
            actualizarDependencia.setString(8, dependencia.getCorreoEncargado());
            actualizarDependencia.setString(9, dependencia.getTelefono());
            actualizarDependencia.setInt(10, dependencia.getIdCoordinador());
            actualizarDependencia.setInt(11, dependencia.getIdDependencia());
            actualizarDependencia.execute();
            validacion = true;
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        } catch (URISyntaxException ex){
            System.out.println(ex.getLocalizedMessage());
        }finally{
            try {
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
        return validacion;
    }
    public static Dependencia getDependenciaById(int idDependencia){
        Dependencia d=null;
        Statement statement;
        try{
            Connection conn= Conexion.getConexion();
            statement = conn.createStatement();
            ResultSet rs=statement.executeQuery("select * from dependencias where idDependencia="+idDependencia+";");
            if(rs.next()){
                d=new Dependencia();
                d.setNombreEncargado(rs.getString("nombreEncargado"));
                d.setApellidoPaternoEncargado(rs.getString("apellidoPaternoEncargado"));
                d.setApellidoMaternoEncargado(rs.getString("apellidoMaternoEncargado"));
            }
            rs.close();
            statement.close();
            conn.close();
        }catch(SQLException | URISyntaxException e){
            System.out.println(e.getMessage());
        }
        return d;
    }
    public static List<Dependencia> visualizarDependencias(){
        Dependencia d=null;
        List<Dependencia> dependencias=new ArrayList<>();
        try{
            Connection c= Conexion.getConexion();
            Statement statement = c.createStatement();
            ResultSet rs=statement.executeQuery("select * from dependencias" );
            if(rs.next()){
                d=new Dependencia();
                d.setNombre(rs.getString("nombre"));
                d.setColonia(rs.getString("colonia"));
                d.setCalle(rs.getString("calle"));
                d.setNumero(rs.getInt("numero"));
                d.setNombreEncargado(rs.getString("nombreEncargado"));
                d.setApellidoPaternoEncargado(rs.getString("apellidoPaternoEncargado"));
                d.setApellidoMaternoEncargado(rs.getString("apellidoMaternoEncargado"));
                d.setCorreoEncargado(rs.getString("correoEncargado"));
                d.setTelefono(rs.getString("telefono"));
                d.setIdCoordinador(rs.getInt("idCoordinador"));
                dependencias.add(d);
            }
            rs.close();
            statement.close();
            c.close();
        }catch(SQLException | URISyntaxException e){
            System.out.println(e.getMessage());
        }
        return dependencias;
    }
}
