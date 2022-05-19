package uv.mx.apiServicioSocial.apiSS.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.net.URISyntaxException;
public class Dependencia {
    private int idDependencia;
    private String nombre;
    private String colonia;
    private String calle;
    private String numero;
    private String nombreEncargado;
    private String apellidoPaternoEncargado;
    private String apellidoMaternoEncargado;
    private String correoEncargado;
    private String telefono;
    private int idCoordinador; 

    public Dependencia(int idDependencia, String nombre, String colonia, String calle, String numero, String nombreEncargado, String apellidoPaternoEncargado, String apellidoMaternoEncargado, String correoEncargado, String telefono, int idCoordinador) {
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

    public String getNumero() {
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

    public void setNumero(String numero) {
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
            preparedStmt.setString(4, a.getNumero());
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

}
