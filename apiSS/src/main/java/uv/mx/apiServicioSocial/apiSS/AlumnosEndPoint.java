package uv.mx.apiServicioSocial.apiSS;

import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.alumnos.BuscarAlumnosRequest;
import https.t4is_uv_mx.alumnos.BuscarAlumnosResponse;
import uv.mx.apiServicioSocial.apiSS.DB.Alumno;
import uv.mx.apiServicioSocial.apiSS.DB.Coordinador;

@Endpoint
public class AlumnosEndPoint {
    @PayloadRoot(localPart = "BuscarAlumnosRequest", namespace = "https://t4is.uv.mx/alumnos")
    @ResponsePayload
    public BuscarAlumnosResponse buscarAlumnos(@RequestPayload BuscarAlumnosRequest peticion) {
        BuscarAlumnosResponse respuesta = new BuscarAlumnosResponse();

        Coordinador c=Coordinador.getCoordinadorByToken(peticion.getToken());
        if(c!=null){
            List<Alumno>alumnos=Alumno.getAlumnosByCoordinador(c.getIdCoordinador());
            for (Alumno a : alumnos) {
                BuscarAlumnosResponse.Alumnos alumno = new BuscarAlumnosResponse.Alumnos();

                alumno.setIdAlumno(a.getIdAlumno());
                alumno.setNombres(a.getNombres());
                alumno.setApellidoPaterno(a.getApellidoPaterno());
                alumno.setApellidoMaterno(a.getApellidoMaterno());
                alumno.setMatricula(a.getMatricula());
                alumno.setCorreo(a.getCorreo());
                alumno.setToken(a.getToken());
                alumno.setPromedio(a.getPromedio());
                alumno.setIdCoordinador(a.getIdCoordinador());
                alumno.setIdDependencia(a.getIdDependencia());
                alumno.setTelefono(a.getTelefono());
                respuesta.getAlumnos().add(alumno);
            }
        }
        return respuesta;
    }
}
