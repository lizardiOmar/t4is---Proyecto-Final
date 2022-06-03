package uv.mx.apiServicioSocial.apiSS.DB;

import java.net.URISyntaxException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private int idActividad;
    private String descripcion;
    private String fecha;
    private int horas;  
    private int idAlumno;
    public Actividad() {
    }
    public Actividad(int idActividad, String descripcion, String fecha, int horas, int idAlumno) {
        this.idActividad = idActividad;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horas = horas;
        this.idAlumno = idAlumno;
    }
    public int getIdActividad() {
        return idActividad;
    }
    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }
    public int getIdAlumno() {
        return idAlumno;
    }
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    @Override
    public String toString() {
        return "Actividad [descripcion=" + descripcion + ", fecha=" + fecha + ", horas=" + horas + ", idActividad="
                + idActividad + ", idAlumno=" + idAlumno + "]";
    }
    public static List <Actividad> getActividadesByRange(String fechaInicio, String fechaFin, int idAlumno){
        List <Actividad> actividades=new ArrayList<>();
        
        try{
            Connection c= Conexion.getConexion();
            Statement statement = c.createStatement();
            ResultSet rs=statement.executeQuery("select * from actividades where '[" + fechaInicio +", "+ fechaFin + "]'::daterange @> fecha and idAlumno="+idAlumno+"order by fecha asc;" );
            if(!rs.next()){
                System.out.println("no hubo una coincidencia con la base de datos");
                return null;
            }else{
                //Actividad, descripcion, fecha, horas, alumno
                
                Actividad a=new Actividad(rs.getInt("idactividad"), rs.getString("descripcion"), String.valueOf(rs.getDate("fecha")), rs.getInt("horas"), rs.getInt("idalumno"));
                actividades.add(a);
                while(rs.next()){
                    a=new Actividad(rs.getInt("idactividad"), rs.getString("descripcion"), String.valueOf(rs.getDate("fecha")), rs.getInt("horas"), rs.getInt("idalumno"));
                    actividades.add(a); 
                }
            }
            rs.close();
            statement.close();
            c.close();
        }catch(SQLException | URISyntaxException e){
            System.out.println(e.getMessage());
        }
        return actividades;
    }
}
