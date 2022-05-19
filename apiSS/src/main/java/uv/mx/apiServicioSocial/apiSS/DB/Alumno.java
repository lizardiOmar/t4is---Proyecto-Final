package uv.mx.apiServicioSocial.apiSS.DB;

import java.net.URISyntaxException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alumno {
    private int idAlumno;
    private String nombres, apellidoPaterno, apellidoMaterno, matricula, correo, token, telefono;
    private double promedio;
    private int idCoordinador;
    private int idDependencia;
    public Alumno(int idAlumno, String nombres, String apellidoPaterno, String apellidoMaterno, String matricula,
            String correo, String token, double promedio, int idCoordinador, int idDependencia, String telefono) {
        this.idAlumno = idAlumno;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.matricula = matricula;
        this.correo = correo;
        this.token = token;
        this.promedio = promedio;
        this.idCoordinador = idCoordinador;
        this.idDependencia = idDependencia;
        this.setTelefono(telefono);
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getIdAlumno() {
        return idAlumno;
    }
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
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
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    public int getIdCoordinador() {
        return idCoordinador;
    }
    public void setIdCoordinador(int idCoordinador) {
        this.idCoordinador = idCoordinador;
    }
    public int getIdDependencia() {
        return idDependencia;
    }
    public void setIdDependencia(int idDependencia) {
        this.idDependencia = idDependencia;
    }
    @Override
    public String toString() {
        return "Alumno [apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno + ", correo="
                + correo + ", idAlumno=" + idAlumno + ", idCoordinador=" + idCoordinador + ", idDependencia="
                + idDependencia + ", matricula=" + matricula + ", nombres=" + nombres + ", promedio=" + promedio
                + ", token=" + token + "]";
    }
    public static List<Alumno> getAlumnosByCoordinador(int idCoordinador){
        List <Alumno> alumnos=new ArrayList<>();
        try{
            Connection c= Conexion.getConexion();
            Statement statement = c.createStatement();
            ResultSet rs=statement.executeQuery("select * from alumnos where idCoordinador  = " + idCoordinador + " order by apellidopaterno, apellidomaterno, nombres asc" );
            if(!rs.next()){
                System.out.println("no hubo una coincidencia con la base de datos");
                return null;
            }else{
                Alumno aux =new Alumno(rs.getInt("idalumno"), rs.getString("nombres"), rs.getString("apellidopaterno"),rs.getString("apellidomaterno"), rs.getString("matricula"), rs.getString("correo"), rs.getString("token"), rs.getFloat("promedio"),  rs.getInt("idCoordinador"), rs.getInt("idDependencia"), rs.getString("telefono"));
                alumnos.add(aux);
                while(rs.next()){
                    aux =new Alumno(rs.getInt("idalumno"), rs.getString("nombres"), rs.getString("apellidopaterno"),rs.getString("apellidomaterno"), rs.getString("matricula"), rs.getString("correo"), rs.getString("token"), rs.getFloat("promedio"),  rs.getInt("idCoordinador"), rs.getInt("idDependencia"), rs.getString("telefono"));
                    alumnos.add(aux);
                }
            }
            rs.close();
            statement.close();
            c.close();
        }catch(SQLException | URISyntaxException e){
            System.out.println(e.getMessage());
        }
        return alumnos;
    }
    //Agregar alumno
    public static boolean registrarAlumno(Alumno a){
        boolean resultado=false;
        try{
            String query =  " insert into alumnos (nombres, apellidopaterno, apellidomaterno, matricula, correo, token, promedio,  idCoordinador, idDependencia, telefono)"+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            Connection conn= Conexion.getConexion();
            PreparedStatement preparedStmt = conn.prepareStatement(query);

			Random rnd = new Random();
            int number = rnd.nextInt(999999999);
            String tokenAlumno=a.getNombres().substring(0, 2)+a.getApellidoPaterno().substring(0, 2)+a.getApellidoMaterno().substring(0, 2)+"-"+number;

            preparedStmt.setString(1, a.getNombres());
            preparedStmt.setString(2, a.getApellidoPaterno());
            preparedStmt.setString(3, a.getApellidoMaterno());
            preparedStmt.setString(4, a.getMatricula());
            preparedStmt.setString(5, a.getCorreo());
            preparedStmt.setString(6, tokenAlumno);
            preparedStmt.setDouble(7, a.getPromedio());
            preparedStmt.setInt(8, a.getIdCoordinador());
            preparedStmt.setInt(9, a.getIdDependencia());
            preparedStmt.setString(10, a.getTelefono());

            preparedStmt.execute();
            resultado=true;
            preparedStmt.close();
            conn.close();
        }catch(SQLException | URISyntaxException e){
            System.out.println(e.getMessage());
        }
        return resultado;
    }
}
