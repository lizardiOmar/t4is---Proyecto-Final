package uv.mx.apiServicioSocial.apiSS;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.alumnos.BuscarAlumnosRequest;
import https.t4is_uv_mx.alumnos.BuscarAlumnosResponse;
import https.t4is_uv_mx.alumnos.ConsultarHorasRequest;
import https.t4is_uv_mx.alumnos.ConsultarHorasResponse;
import https.t4is_uv_mx.alumnos.ReporteMensualRequest;
import https.t4is_uv_mx.alumnos.ReporteMensualResponse;
import uv.mx.apiServicioSocial.apiSS.DB.Actividad;
import uv.mx.apiServicioSocial.apiSS.DB.Alumno;
import uv.mx.apiServicioSocial.apiSS.DB.Coordinador;
import uv.mx.apiServicioSocial.apiSS.DB.Dependencia;

@Endpoint
public class AlumnosEndPoint {
    // Endpoint del reporte mensual
    // Requiere el token del alumno y el mes del que se quieren los datos del repote

    @PayloadRoot(localPart = "BuscarAlumnosRequest", namespace = "https://t4is.uv.mx/alumnos")
    @ResponsePayload
    public ReporteMensualResponse reporteMensual(@RequestPayload ReporteMensualRequest peticion) {
        // Formato de la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, peticion.getMes() + 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String fechaInicio = sdf.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        String fechaFin = sdf.format(calendar.getTime());
        // Inicia el response
        ReporteMensualResponse reporteMensualResponse = new ReporteMensualResponse();
        // Alumno que solicita el reporte
        Alumno alumno = Alumno.buscarAlumnoToken(peticion.getToken());
        // Nombre del coordinador
        Coordinador coordinador = Coordinador.getCoordinadorById(alumno.getIdCoordinador());
        // Nombre del encargado de la dependencia
        Dependencia dependencia = Dependencia.getDependenciaById(alumno.getIdDependencia());
        // Obtener nombre del alumno
        reporteMensualResponse.setNombreAlumno(
                alumno.getNombres() + " " + alumno.getApellidoPaterno() + " " + alumno.getApellidoMaterno());
        // Obtener nombre del coordinador del SS
        reporteMensualResponse.setNombreCoordinador(coordinador.getNombres() + " " + coordinador.getApellidoPaterno()
                + " " + coordinador.getApellidoMaterno());
        // Obtener nombre del responsable del SS
        reporteMensualResponse.setNombreResponsable(dependencia.getNombreEncargado() + " "
                + dependencia.getApellidoPaternoEncargado() + " " + dependencia.getApellidoMaternoEncargado());
        // Obtener actividades del reporte
        List<Actividad> actividades = Actividad.getActividadesByRange(fechaInicio, fechaFin, alumno.getIdAlumno());
        if (!actividades.isEmpty()) {
            for (Actividad actividad : actividades) {
                ReporteMensualResponse.Actividad aux = new ReporteMensualResponse.Actividad();
                aux.setFecha(actividad.getFecha());
                aux.setHoras(actividad.getHoras());
                aux.setActividad(actividad.getDescripcion());
                reporteMensualResponse.getActividad().add(aux);
            }
        }
        // Obtener horas del reporte por mes
        
        // Obtener horas del reporte en total

        return reporteMensualResponse;
    }

    @PayloadRoot(localPart = "BuscarAlumnosRequest", namespace = "https://t4is.uv.mx/alumnos")
    @ResponsePayload
    public BuscarAlumnosResponse buscarAlumnos(@RequestPayload BuscarAlumnosRequest peticion) {
        BuscarAlumnosResponse respuesta = new BuscarAlumnosResponse();

        Coordinador c = Coordinador.getCoordinadorByToken(peticion.getToken());
        if (c != null) {
            List<Alumno> alumnos = Alumno.getAlumnosByCoordinador(c.getIdCoordinador());
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

    @PayloadRoot(localPart = "ConsultarHorasRequest", namespace = "https://t4is.uv.mx/alumnos")
    @ResponsePayload
    public ConsultarHorasResponse consultarHoras(@RequestPayload ConsultarHorasRequest peticion) {
        ConsultarHorasResponse response = new ConsultarHorasResponse();
        int total = Alumno.contarHoras(peticion.getIdAlumno());
        response.setHorasRealizadas(total);
        response.setHorasFaltantes(480-total);
        return response;
    }

}
